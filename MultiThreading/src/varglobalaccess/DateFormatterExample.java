package varglobalaccess;

import java.text.SimpleDateFormat;

public class DateFormatterExample {

	// public static SimpleDateFormat dateFormatter= new SimpleDateFormat("EEE MMM
	// d, hh:mm:ss");

	public static class DateFormatterThreadLocal extends ThreadLocal<SimpleDateFormat> {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("EEE MMM d, hh:mm:ss");
		}
	}

	public static DateFormatterThreadLocal dateFormatterThreadLocal = new DateFormatterThreadLocal();

	public DateFormatterExample() {
		System.out.println("Globale variable access:");

		Thread t1 = new Thread(new DatePrinter("Formatter 1"), "Formatter 1");
		Thread t2 = new Thread(new DatePrinter("Formatter 2"), "Formatter 2");

		t1.start();
		t2.start();

	}

}
