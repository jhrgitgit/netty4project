package com.harlan.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test4 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChanel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true){
            buffer.clear();

            int read = inputChannel.read(buffer);

            System.out.println(read);

            if(-1 == read){
                break;
            }

            buffer.flip();

            outputChanel.write(buffer);

        }

        inputChannel.close();
        outputChanel.close();

    }
}
