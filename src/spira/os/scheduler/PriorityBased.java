package spira.os.scheduler;

import java.util.List;

public class PriorityBased implements SchedulerAlgorithm{
	public boolean preemtive;
	public PriorityBased(){
		preemtive = true;
	}
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {

		return getPriority(list);
		
	}

	private FakeProcess getPriority(List<FakeProcess> list) {

		FakeProcess greatest = list.get(0);
		
		for(int i=1;i<list.size();i++){
			FakeProcess process= list.get(i);
			if(process.getPriority()>=greatest.getPriority()){
				greatest = process;
			}
		}
		return greatest;
		
	}
	@Override
	public Boolean isPreemtive() {
		return preemtive;
	}
}
