package spira.philosophers;

public class Fork {

	private String name;
	private boolean taken;

	public Fork(String name){
		this.name = name;
	}
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean isTaken) {
		taken = isTaken;
	}
	public String getName() {
		return name;
	}

}
