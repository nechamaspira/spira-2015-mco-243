package spira.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class IncrementThread extends Thread {

	// static int number = 0;

	private AtomicInteger number = new AtomicInteger(0);
	// when something is atomic that means it was done in on eoperation.
	// smallest slices... it is regular operation just can do regular
	// operations..like increnent and get method whic are synchronized, it will
	// return an int

	// static Semaphore semaphore = new Semaphore(1,true);
	// static Object lock = new Object();
	private CountDownLatch latch;//

	public IncrementThread(AtomicInteger numb,CountDownLatch latch) {
		this.latch = latch;
		number = numb;
	}

	// concurrent modification exception is when one thing is trying to access a
	// list while another thing is trying to modify list
	// a race condition is when have 2 threads doing something and no idea what
	// output gonna be, its indeterminate. this example
	// is a race condition.

	// need to identify part in code that can have this sort of prob. we only
	// want one thread accessing this line-(number = number + 1;) at a tie
	// this idea is called mutual exclusion
	// critical section=this block of code is what we need every thread to
	// execute separately, its not the whole for loop, just the inside.
	//
	// while(inSection); is called a busy loop. its not good in threads. y?
	//
	// thread safe means an object can be accessed by multiple threads without
	// causing this race condition, so would make the static synchronized
	//

	public void run() {

		for (int i = 0; i < 1000000; i++) {

			// synchronized (lock) {
			// number = number + 1;
			// }
			//
			// add();

			/*
			 * try { semaphore.acquire(); } catch (InterruptedException e) {
			 * e.printStackTrace(); } number = number + 1; semaphore.release();
			 */
			number.incrementAndGet();

		}

		latch.countDown();

	}

	// main is also running in a thread. the only way to get right output is to
	// print number after all threads are finished
	// we do this by using a countdown latch

	/*private static synchronized void add() {
		number = number + 1;
	}
*/
	public static void main(String args[]) throws InterruptedException {

		AtomicInteger numb = new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new IncrementThread(numb, latch).start();

		}

		latch.await();

		System.out.println(numb);
	}

}
