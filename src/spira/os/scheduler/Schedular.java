package spira.os.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Schedular {
	// holds my list of processees

	private static final int QUANTUM = 10;

	List<FakeProcess> list;
	SchedulerAlgorithm algorithm;

	public Schedular(SchedulerAlgorithm algorithm) {
		this.algorithm = algorithm;
		list = new ArrayList<>();
	}

	public void run() {
		while (!list.isEmpty()) {

			FakeProcess process = algorithm.getNextProcess(list);
			list.remove(process);// remove from list
			if (algorithm.isPreemtive()) {
				process.run(QUANTUM);// run for certain amnt of time, reduces
										// the amnt of time to run
				// need process and make algorithm
				// gonna write first in first out scheduler, 344
				// cr8 shortest process first scheduler 348
				// do one based on priority pg 360 - execute proceses based on
				// priority. if process hasnt executed increase its priotity
				// cr8 processees all diff types...
				// run program for 100 iterations of this run method and see how
				// many processes u complete and tell me which one is best

				// only preemtive
				if (process.isStillRunning()) {// if still running add it to
												// list
					list.add(process);
				}

			}
			else{
				process.run(process.getTimeToCompletion());
			}

		}
	}
	

	public void addProcess(FakeProcess process) {
		list.add(process);
	}
}
