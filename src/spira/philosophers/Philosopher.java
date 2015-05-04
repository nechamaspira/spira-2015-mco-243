package spira.philosophers;

import java.util.Random;

public class Philosopher extends Thread{
	
//can think and eat in run. will eat and think between half and 2 seconds
	
	public final static Random random = new Random();
	
	private boolean eating;
	private boolean thinking;
	private String name;
	private Fork left;
	private Fork right;

	public Philosopher(String name, Fork l, Fork r){
		this.name = name;
		left = l;
		right = r;
	}
	
	
	public boolean isEating() {
		return eating;
	}

	
	public void setEating(boolean eating) {
		this.eating = eating;
	}
	

	public boolean isThinking() {
		return thinking;
	}

	
	public void setThinking(boolean thinking) {
		this.thinking = thinking;
	}

	
			
	@Override
	public void run(){
		
		while(true){
			
			eat();
			sleep();
			
		}
	}


	private void sleep() {
		sleepRange(500,2000);
		
		
	}


	private void eat() {
		synchronized(right){
			
			System.out.println(name+ " picked up "+left.getName());

			sleepRange(2000,5000);
			
			synchronized(left){
				System.out.println(name+ " picked up "+left.getName());

				System.out.println(name+ " eating");
				sleepRange(500,2000);
			}
		}
		
	}
	private void sleepRange(int low, int high) {
		try {
			Thread.sleep(random.nextInt(high-low)+low);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//can have deadlock cuz everyone can pick up right fork b4 pick up left;
}
