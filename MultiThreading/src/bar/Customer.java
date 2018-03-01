package bar;

import java.util.concurrent.TimeUnit;

public class Customer implements Runnable{

	private int timetoWait;
	private Thread thread;
	private String name;
	
	public Customer(Thread thread,String name,int timeToWait) {
		this.timetoWait=timeToWait;
		this.thread=thread;
		this.name=name;
	}
	
	@Override
	public void run() {
		System.out.println(name+": Doesn't seem to be anyone around.I'll wait a moment");
		
		try {
			TimeUnit.SECONDS.sleep(timetoWait);
		} catch (InterruptedException e) {
			System.out.println(name+": Hey! Where is the bartender going? I'm teling my lawyer!");
			return;
		}
		
		System.out.println(name+": Oh there's a bell! Can I get some service around here ?");
		thread.interrupt();
	}
}
