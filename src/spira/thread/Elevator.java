package spira.thread;

public class Elevator {

	private int currentFloor;
	private int requestFloor;
	
	public boolean isInUse(){
		return requestFloor>0;
	}
	//need to make sure dont have 2 diff floors pressing it the same time= 2 threads not to conflict with eachother
	public void setRequestedFloor(int requestedFloor){//this is class is not threadsafe right now so must synchronize,
		synchronized(this){
			if(isInUse()){
				return;
			}
			this.requestFloor= requestedFloor;

		}
	}
}
