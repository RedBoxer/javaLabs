package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		String str;
		Scanner scn = new Scanner(System.in);
		str = scn.nextLine();
		try {
			System.out.println(parseInput(str));
		}catch(Exception e){
			System.out.println("Wrong input format " + e.toString());
		}
		scn.close();
	}
	
	private static String parseInput(String str) throws ParseException{
		String[] input;
		input = str.split(" ");
		if(input.length == 4) {
			StringBuilder output = new StringBuilder();
			output.append(input[0]);
			output.append(" " + input[1].charAt(0) + "." + input[2].charAt(0) + ".");
			if(input[2].charAt(input[2].length()-1) == 'а') {
				output.append(" жен. ");
			} else {
				output.append(" муж. ");
			}
			if(checkDateFormat(input[3])) {
			Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(input[3]);
			Date curr = new Date();
				if(curr.compareTo(birth) > 0) {
					long age = TimeUnit.DAYS.convert(curr.getTime() - birth.getTime(), TimeUnit.MILLISECONDS) / 365;
					output.append(age);
					if(age % 10 == 1) {
						output.append(" год");
					} else if (age % 10 < 5) {
						output.append(" года");
					} else {
						output.append(" лет");
					}
				} else {
					throw new ParseException("Wrong date", 0);
				}
			} else {
				throw new ParseException("Wrong date format", 0);
			}
			return output.toString();
		}else {
			throw new ParseException("Incorrect ammount of arguments!", 1);
		}
	}
	
	private static Boolean checkDateFormat(String date) {
		String[] input;
		input = date.split("/");
		if(input.length == 3) {
			int day = Integer.valueOf(input[0]);
			int mon = Integer.valueOf(input[1]);
			if(mon > 12 || mon == 0) {return false;}
			if(day > 31 || day == 0) {return false;}
		} else { return false;}
		return true;
	}
}

