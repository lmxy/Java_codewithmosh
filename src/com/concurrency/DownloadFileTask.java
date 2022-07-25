package com.concurrency;

public class DownloadFileTask implements Runnable {

	private DownloadStatus status;

	public DownloadFileTask() {

		this.status = new DownloadStatus();
	}

	@Override
	public void run() {

		System.out.println("Downloading a file: " + Thread.currentThread());

		for (int i = 0; i < 10_000; i++) {
			if (Thread.currentThread().isInterrupted()) return;
			status.incrementTotalBytes();
		}

		System.out.println("Download complete: " + Thread.currentThread());
	}

	public DownloadStatus getStatus() {
		return status;
	}
}
