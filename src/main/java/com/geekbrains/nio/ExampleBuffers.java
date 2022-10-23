package com.geekbrains.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ExampleBuffers {

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(6);

        buffer.putInt(100500);
        buffer.putChar('a');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());

        buffer.rewind();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());

        buffer.clear();
        buffer.putChar('a');
        buffer.putChar('b');
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.getChar());
        }

        ByteBuffer hello = ByteBuffer.wrap(
                "Hello world".getBytes(StandardCharsets.UTF_8));
        RandomAccessFile raf = new RandomAccessFile("serverFiles/test.txt", "rw");
        FileChannel channel = raf.getChannel();
        channel.write(hello);
    }
}
