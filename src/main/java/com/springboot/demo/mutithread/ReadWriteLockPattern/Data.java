package com.springboot.demo.mutithread.ReadWriteLockPattern;

import java.util.Arrays;

public class Data {
    private char[] buffer;
    private ReadWriteLock readWriteLock;

    public Data(int size) {
        readWriteLock = new ReadWriteLock();
        buffer = new char[size];
        Arrays.fill(buffer, '*');
    }

    public char[] read() throws InterruptedException {
        readWriteLock.readLock();
        try {
            return doRead();
        } finally {
            readWriteLock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        readWriteLock.writeLock();
        try {
            doWrite(c);
        } finally {
            readWriteLock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        Arrays.fill(buffer, c);
    }

    private char[] doRead() {
        char[] newBuffer = new char[buffer.length];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        return newBuffer;
    }
}
