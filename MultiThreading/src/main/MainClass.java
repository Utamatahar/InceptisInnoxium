package main;

import java.util.concurrent.TimeUnit;

import bar.Bartender;
import bar.Customer;
import goodbyeworld.Kenny;
import goodbyeworld.ThreadExceptionHandler;
import nowsynchronized.SychronizedWay;

public class MainClass {

	private static void bartenderRun() {
		Bartender barTender = new Bartender();
		Thread bartenderThread = new Thread(barTender, "Bartender");
		bartenderThread.start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Integer numCustomers = 5;
		Thread[] customerThreads = new Thread[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			String customerName = "Customer " + i;
			int randomtime = (int) (Math.random() * 20);
			System.out.println(randomtime);
			Customer customer = new Customer(bartenderThread, customerName, randomtime);
			customerThreads[i] = new Thread(customer, customerName);
			customerThreads[i].start();
		}

		try {
			bartenderThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("A voice: Hey! Isn't that bartender sneaking out he door?");

		for (int i = 0; i < numCustomers; i++) {
			System.out.println("i=" + i);
			customerThreads[i].interrupt();
		}
	}

	private static void goodByeWorld() {
		Kenny kenny = new Kenny();
		System.out.println("Starting Kenny");

		Thread t = new Thread(kenny, "kenny");

		ThreadExceptionHandler threadExceptionHandler = new ThreadExceptionHandler();
		t.setUncaughtExceptionHandler(threadExceptionHandler);

		t.start();

		try {
			TimeUnit.SECONDS.sleep(2);

		} catch (InterruptedException e) {

		}

		t.interrupt();

		try {
			t.join();
			System.out.println("Kenny is dead");
		} catch (InterruptedException e) {

		}
	}

	public static void main(String[] args) {
		System.out.println("Multithreading");

		// new RealHelloWorldSingleThreaded();

		// new RealHelloWorldMultiThreaded();

		// bartenderRun();

		// goodByeWorld();

		// new DateFormatterExample();

		// new UnsychronizedWay();

		new SychronizedWay();

	}

}
