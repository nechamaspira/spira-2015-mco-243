package spira.philosophers;

public class DiningPhilosophers {

	public static void main(String args[]){
		
		Fork forks [] = new Fork[5];
		for(int i = 0;i<5;i++){
			forks[i] = new Fork(String.valueOf(i));
		}
		
		Philosopher phils[] = new Philosopher[5];
		phils[0] = new Philosopher("A", forks[0],forks[1]);
		phils[1] = new Philosopher("B", forks[1],forks[2]);
		phils[2] = new Philosopher("C", forks[2],forks[3]);
		phils[3] = new Philosopher("D", forks[3],forks[4]);
		phils[4] = new Philosopher("E", forks[4],forks[0]);
		
		for(Philosopher p:phils){
			p.start();
		}

	}
}
