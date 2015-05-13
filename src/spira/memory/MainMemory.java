package spira.memory;

public class MainMemory {

	private int totalBytes;
	private String[][] memory;

	MainMemory(int totalBytes) {
		this.totalBytes = totalBytes;
		this.memory = new String[totalBytes / 128][128];

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				memory[i][j] = "-";
			}
		}

	}

	public boolean allocate(int processID, int numBytes) {
		
		int amount = 0;
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j].equals(String.valueOf('-'))) {
					amount++;
				}
			}
		}
		if (amount >= numBytes) {
			fillUp(processID, numBytes);// , ((i * 128) + j));
			return true;
		}
		return false;

	}

	private void fillUp(int processID, int numBytes) {// , int ij) {
		int amount = 0;

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j].equals(String.valueOf('-'))) {
					amount++;
					memory[i][j] = String.valueOf(processID);

				}
				if (amount == numBytes) {
					return;
				}
			}
		}
	}

	public void free(int pid) {

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j].equals(String.valueOf(pid))) {
					memory[i][j] = "-";
				}
			}
		}

	}

	public String print() { 
		StringBuilder info = new StringBuilder();

		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				info.append(memory[i][j]);
				info.append("|");
			}
			info.append("\n");
		}
		return info.toString();

	}

	public static void main(String[] args) {

		MainMemory mem = new MainMemory(1000);

		boolean bool1 = mem.allocate(1, 300);
		if (!bool1) {
			System.out.println("There is not enough memory for process 1");
		}
		boolean bool2 = mem.allocate(2, 200);
		if (!bool2) {
			System.out.println("There is not enough memory for process 2");
		}
		boolean bool3 =mem.allocate(3, 400);
		if (!bool3) {
			System.out.println("There is not enough memory for process 3");
		}
		
		boolean bool4 = mem.allocate(4, 250);
		if (!bool4) {
			System.out.println("There is not enough memory for process 4");
		}
		System.out.println(mem.print());
		
		
		MainMemory memory = new MainMemory(1280);

		boolean boo1 = memory.allocate(1, 300);
		if (!boo1) {
			System.out.println("There is not enough memory for process 1");
		}
		boolean boo2 = memory.allocate(2, 200);
		if (!boo2) {
			System.out.println("There is not enough memory for process 2");
		}
		boolean boo3 =memory.allocate(3, 400);
		if (!boo3) {
			System.out.println("There is not enough memory for process 3");
		}
		memory.free(2);
		System.out.println("freed space from process 2");
		boolean boo4 = memory.allocate(4, 250);
		if (!boo4) {
			System.out.println("There is not enough memory for process 4");
		}
		boolean boo5= memory.allocate(4, 500);
		if (!boo5) {
			System.out.println("There is not enough memory for process 5");
		}
		System.out.println(memory.print());

	}

}
