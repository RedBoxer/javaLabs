package elevators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElevatorController {
	ArrayList<Elevator> elevators = new ArrayList<>();
	Queue<elMessage> messages = new LinkedList<>();
	CallManager cMng = new CallManager();
	
	public ElevatorController(int elAmmount, int maxFloor){
		for(int i = 0; i < elAmmount; i++) {
			elevators.add(new Elevator(maxFloor, i));
		}
		cMng.activate();
		cMng.start();
	}
	
	public void addCall(elMessage mess) {
		messages.add(mess);
	}
	
	int findIdleElevator() {
		for (int i = 0; i < elevators.size(); i++) {
			if(elevators.get(i).curr == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void stopController() {
		cMng.deactivate();
	}
	
	class CallManager extends Thread{
		boolean active = false;
		public void activate() {
			active = true;
		}
		
		public void deactivate() {
			active = false;
		}
		public void run() {
			while(active) {
				if(findIdleElevator() != -1 && !messages.isEmpty()) {
					System.out.println("Processing message");
					elevators.get(findIdleElevator()).assignMessage(messages.poll());
				} 
			}
		}	
	}
}
