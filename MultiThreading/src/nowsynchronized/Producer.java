package nowsynchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

	private List<ProduceObserver> observers = new ArrayList<ProduceObserver>();

	public void registerObserver(ProduceObserver produceObserver) {
		observers.add(produceObserver);
	}

	@Override
	public void run() {
		System.out.println("Producer starting");

		for (int i = 1; i <= 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Produce.ProduceBuilder builder = new Produce.ProduceBuilder();
			builder.withInstance(i);
			builder.withColor(Produce.Color.values()[i % Produce.Color.values().length]);

			Produce latestProduce = builder.build();

			observers.forEach(observer -> observer.onProduction(latestProduce));
		}

		System.out.println("Producer terminating");
	}

}
