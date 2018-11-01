package com.harlan.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁
 */
public class Test10 {
    public static void main(String[] args) throws  Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileLock fileLock = fileChannel.lock(3,6,true);

        System.out.println("valid: " + fileLock.isValid());
        System.out.println("lock type: " + fileLock.isShared());

        fileLock.release();

        randomAccessFile.close();
    }
}
