package com.springboot.demo.mutithread.ReadWriteLockPattern;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class ReadWriteLock {
    private int readerCount = 0;
    private int writerCount = 0;

    public synchronized void readLock() throws InterruptedException {
        if (writerCount > 0) {
            wait();
        }
        readerCount ++;
    }

    public synchronized void readUnLock() {
        readerCount --;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        if (readerCount > 0 || writerCount > 0) {
            wait();
        }
        writerCount ++;
    }

    public synchronized void writeUnLock() {
        writerCount --;
        notifyAll();
    }
}
