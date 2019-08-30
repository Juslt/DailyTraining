package com.example.juslt.retorfitdemo.random_access_file;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Juslt on 2019/7/30
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("./app/raw/random.txt", "rw");
            FileChannel fileChannel = file.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(48);

            int byteRead = fileChannel.read(buffer);
            while (byteRead != -1) {
                System.out.println("read"+byteRead);
                buffer.flip();

                while (buffer.hasRemaining()){
                    System.out.println("buffer _"+buffer.get());
                }
                buffer.clear();
                byteRead = fileChannel.read(buffer);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
