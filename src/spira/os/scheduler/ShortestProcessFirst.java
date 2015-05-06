package spira.os.scheduler;

import java.util.List;

public class ShortestProcessFirst implements SchedulerAlgorithm {

	//public boolean preemtive;
	public ShortestProcessFirst(){
		//preemtive = false;
	}
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {

		return getTime(list);
		
	}

	private FakeProcess getTime(List<FakeProcess> list) {

		FakeProcess shortest = list.get(0);
		
		for(int i=1;i<list.size();i++){
			FakeProcess process= list.get(i);
			if(process.getTimeToCompletion()<=shortest.getTimeToCompletion()){
				shortest = process;
			}
		}
		return shortest;
	}

	@Override
	public Boolean isPreemtive() {
		//return preemtive;
		return false;
	}
	

}
