package nowsynchronized;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable, ProduceObserver {

	private volatile Produce produce = null;

	@Override
	public void run() {
		System.out.println("Consumer starting");

		while (true) {

			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (produce != null) {
				int produceInstance = produce.getInstance();
				System.out.println("Last produce instance : " + produceInstance);
				System.out.println("Last produce color : " + produce.getColor().name());

				if (produceInstance == 10) {
					break;
				}
			}
		}

	}

	@Override
	public void onProduction(Produce produce) {
		this.produce = produce;
	}

}
