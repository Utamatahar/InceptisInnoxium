package varglobalaccess;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePrinter implements Runnable {

	String name;

	public DatePrinter(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		if (name.equals("Formatter 1")) {
			System.out.println("Formatter 1 is setting the formatting pattern");
			DateFormatterExample.dateFormatterThreadLocal.get().applyPattern("hh:mm:ss");
		}

		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}

			Date now = new Date();

			System.out.println(name + " : " + DateFormatterExample.dateFormatterThreadLocal.get().format(now));
		}
	}

}
