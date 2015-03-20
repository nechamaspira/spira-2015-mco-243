package spira.threads;

import java.net.MalformedURLException;

public class Main {

	public static void main(String[] args) {

		try {
			Thread1 thread1 = new Thread1(
					"http://www.ittrainingnepal.com/img/image/_42_article_slc.jpg",
					"computer.jpg");
			Thread1 thread2 = new Thread1(
					"http://suburbanfinance.com/wp-content/uploads/2013/04/streetinfo.jpg",
					"house.jpg");

			Thread1 thread3 = new Thread1(
					"http://www.koonysun.com/Images/Military%20Pilot%20Watch%209027big.jpg",
					"watch.jpg");

			thread1.start();
			thread2.start();
			thread3.start();

			if (!thread1.isAlive() && !thread2.isAlive()
					&& !thread3.isAlive()) {
				System.out.println("done");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
