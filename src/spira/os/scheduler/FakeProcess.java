package spira.os.scheduler;

public class FakeProcess {
	
	private int priority;
	private int timeToCompletion;
	
	public FakeProcess(int priority, int timeToCompletion){
		this.priority = priority;
		this.timeToCompletion = timeToCompletion;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeToCompletion() {
		return timeToCompletion;
	}

	public void setTimeToCompletion(int timeToCompletion) {
		this.timeToCompletion = timeToCompletion;
	}
	public void run(int quantum) {

		timeToCompletion-=quantum;
	}
	public boolean isStillRunning() {

		return timeToCompletion>0;
	}

	
	

}
