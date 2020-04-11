package main;

import elevators.ElevatorController;
import elevators.elMessage;

public class main {

	public static void main(String[] args) {
		ElevatorController elCon = new ElevatorController(2, 9);
		elCon.addCall(new elMessage(2,9));
		elCon.addCall(new elMessage(1,4));
		elCon.addCall(new elMessage(5,1));
		elCon.addCall(new elMessage(4,6));
		elCon.addCall(new elMessage(2,9));
		elCon.addCall(new elMessage(1,4));
		elCon.addCall(new elMessage(5,1));
		elCon.addCall(new elMessage(4,6));
	}

}
