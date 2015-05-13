package spira.memory;

public class Process {

	private int id;
	private int length;
	private int startigPlace;
	
	
	public Process(int id, int length){
		this.id=id;
		this.length = length;
	}
	
	public int getStartigPlace() {
		return startigPlace;
	}

	public void setStartigPlace(int startigPlace) {
		this.startigPlace = startigPlace;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
