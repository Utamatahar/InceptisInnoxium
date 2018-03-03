package nowsynchronized;

public class SychronizedWay {

	public SychronizedWay() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		producer.registerObserver(consumer);

		Thread producerThread = new Thread(producer, "producer");
		Thread consumerThread = new Thread(consumer, "producer");

		producerThread.start();
		consumerThread.start();
	}
}
