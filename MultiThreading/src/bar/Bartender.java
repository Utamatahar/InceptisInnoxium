package bar;

import java.util.concurrent.TimeUnit;

import javax.management.timer.TimerNotification;

public class Bartender implements Runnable {

	private int numTimesWoken=0;
	
	@Override
	public void run() {

		System.out.println("Bartender: My boss isn't in today; time for a quick snooze");
		
		while (true){
			if(Thread.interrupted()) {
				System.out.println("Bartender: ZZzz er erm, is someone waiting?");
			}
			
			if(numTimesWoken==2) {
				break;
			}
			
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				numTimesWoken++;
				Thread.currentThread().interrupt();
			}
		}
		
	}

}
