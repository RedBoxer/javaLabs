package main;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String input;
		HashMap<Character, Integer> alphabet = new HashMap<>();
		Scanner scrUser = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		
		String keys = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		for (int i = 0; i < keys.length(); i++) {
			alphabet.put(keys.charAt(i), 0);
		}
		
		System.out.println("Enter full input file name: ");
		input = scrUser.nextLine();
		
		File inpFile = new File(input);
		Scanner scr = null;
		try {
			scr = new Scanner(inpFile);
		}catch(Exception e) {
			System.out.println("file doesn't exist");
		}
		if(scr != null) {
			while (scr.hasNext()){
				String currLine = scr.nextLine();
				for(int i = 0; i < currLine.length(); i++) {
					char currChar = currLine.charAt(i);
					if(alphabet.containsKey(currChar)) {
						alphabet.put(currChar, alphabet.get(currChar)+1);
					}
				}
			}
			scr.close();
		
			for (int i = 0; i < keys.length(); i++) {
				output.append(keys.charAt(i) + " " + alphabet.get(keys.charAt(i)) + "\n");
			}
		
			System.out.println("Enter full output file name: ");
			input = scrUser.nextLine();
			
			FileOutputStream outFile = null;
			try {
				outFile = new FileOutputStream(new File(input));
				if(outFile != null) {
					outFile.write(output.toString().getBytes());
				}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		} else {
			System.out.println("Wrong file name");
		}
	}

}
