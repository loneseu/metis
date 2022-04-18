package cn.edu.seu.lone.netty.c1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static cn.edu.seu.lone.netty.c1.ByteBufferUtil.debugAll;

public class TestScatteringReads {
    public static void main(String[] args) {
        try {
            FileChannel channel = new RandomAccessFile("/Users/lone/Sites/metis/metis-netty/words.txt", "r").getChannel();
            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(5);

            channel.read(new ByteBuffer[]{b1, b2, b3});
            b1.flip();
            b2.flip();
            b3.flip();

            debugAll(b1);
            debugAll(b2);
            debugAll(b3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}