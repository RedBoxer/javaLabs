package elevators;

public class Elevator extends Thread {
	//номер лифта, чтобы было проще отслеживать каждый лифт в консоли
	int elNum;
	int currentFloor = 1;
	int maxFloor;
	elMessage curr = null;
	
	public Elevator(int maxFloor, int elNum) {
		this.elNum = elNum;
		this.maxFloor = maxFloor;
		System.out.println("Elevator " + elNum + " set");
		this.start();
	}
	
	void setMaxFloor(int floor) {
		maxFloor = floor;
	}
	
	public void run() {
		while(true) {
			if(curr != null) {
				this.moveToFloor(curr.callFloor);
				this.moveToFloor(curr.destFloor);
				curr = null;
			}
		}
	}
	
	public void assignMessage(elMessage mess) {
		curr = mess;
	}
	
	void moveToFloor(int reqFloor) {
		final int startFloor = currentFloor;
		int direction = 0;
		if(reqFloor < 1 || reqFloor > maxFloor) {
			return;
		}
		if(reqFloor < currentFloor) {
			direction = -1;
		} else {
			direction = 1;
		}
		for(int i = startFloor; i != reqFloor; i += direction) {
			try {
				Thread.sleep(1000);
				currentFloor += direction;
				System.out.println("Elevator " + elNum + " on " + currentFloor);
			}catch(Exception e) {System.out.println(e.toString());}
		}
		direction = 0;
	}
}
