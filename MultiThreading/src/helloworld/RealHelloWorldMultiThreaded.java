package helloworld;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class RealHelloWorldMultiThreaded {

	public static class Greeter implements Runnable{

		private String country;
		
		
		
		public Greeter(String country) {
			
		//	super(country+ " thread");
			this.country=country;
		}
		
		@Override
		public void run() {
		//	long id=currentThread().getId();
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long id =Thread.currentThread().getId();
			System.out.println(id+": Hello "+country+"!");
		}
	}
	
	public RealHelloWorldMultiThreaded() {
		String countries []= {"France","India","China","USA","Germany"};
		
		for(String country:countries) {
			//System.out.println("Hello "+country+"!");
			//new Greeter(country).start();
			new Thread(new Greeter(country), country +" thread").start();
		}
			
		//System.out.println("\nJava 8 :");
		//Arrays.stream(countries).forEach(country -> System.out.println("Hello "+country+"!"));
		
	}
	
}
