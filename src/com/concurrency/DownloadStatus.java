package com.concurrency;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private boolean isDone;
//    private LongAdder totalBytes = new LongAdder();
    private int totalBytes;
    private int totalFiles;

    public int getTotalBytes() {
        return totalBytes;
//        return totalBytes.intValue();
    }

    public void incrementTotalBytes() {
        totalBytes++;
//        totalBytes.increment();
    }
}
