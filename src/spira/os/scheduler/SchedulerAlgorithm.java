package spira.os.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {

	
	FakeProcess getNextProcess(List<FakeProcess> list); // send in list and gives back whatever next one shud be, fifo
	// can change algorithm at any time... have diff schedular with diff algo
	
	Boolean isPreemtive();
}
