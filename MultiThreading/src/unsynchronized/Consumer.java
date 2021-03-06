package unsynchronized;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private Producer producer;

	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		System.out.println("Consumer starting");

		while (true) {

			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Produce produce = producer.getLatestProduce();

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

}
