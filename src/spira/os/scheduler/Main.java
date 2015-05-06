package spira.os.scheduler;

import java.util.Random;

public class Main {

	private Random random;
	private Schedular firstInOut;
	private Schedular shortestProcessFirst;
	private Schedular priorityBased;

	public Main() {
		random = new Random();
		firstInOut = new Schedular(new FirstInFirstOut());
		shortestProcessFirst = new Schedular(new ShortestProcessFirst());
		priorityBased = new Schedular(new PriorityBased());
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.makeFakeProcess();

		System.out.println(System.currentTimeMillis());
		main.firstInOut.run();
		System.out.println(System.currentTimeMillis());

		System.out.println(System.currentTimeMillis());
		main.shortestProcessFirst.run();
		System.out.println(System.currentTimeMillis());

		System.out.println(System.currentTimeMillis());
		main.priorityBased.run();
		System.out.println(System.currentTimeMillis());

	}

	private void makeFakeProcess() {
		for (int i = 0; i < 2000; i++) {
			int priority = random.nextInt(10) + 1;
			int length = random.nextInt(65);
			FakeProcess process = new FakeProcess(priority, length);
			firstInOut.addProcess(process);
			shortestProcessFirst.addProcess(process);
			priorityBased.addProcess(process);

		}

	}

}
