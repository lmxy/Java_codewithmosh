package com.concurrency;

public class ThreadDemo {
	public static void show() {
		Thread thread = new Thread(new DownloadFileTask());
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("File is ready to be scanned");
	}
}
