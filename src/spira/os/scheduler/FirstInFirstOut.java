package spira.os.scheduler;

import java.util.List;

public class FirstInFirstOut implements SchedulerAlgorithm{

	//public boolean preemtive;
	public FirstInFirstOut(){
		//preemtive = false;
	}
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return list.get(0);
		
	}

	@Override
	public Boolean isPreemtive() {
		//return preemtive;
		return false;
	}
	
	

}
