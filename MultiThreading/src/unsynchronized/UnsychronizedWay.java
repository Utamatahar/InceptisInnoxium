package unsynchronized;

public class UnsychronizedWay {

	public UnsychronizedWay() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer(producer);

		Thread producerThread = new Thread(producer, "producer");
		Thread consumerThread = new Thread(consumer, "producer");

		producerThread.start();
		consumerThread.start();
	}
}
