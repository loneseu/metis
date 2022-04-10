package cn.edu.seu.lone.netty.c1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class TestByteBuffer {
    public static void main(String[] args) {
        // FileChannel
        // 1.输入输出流 2. RandomAccessFile
        try {
            System.out.println(TestByteBuffer.class.getResource("data.txt"));
            FileChannel channel = new FileInputStream(Objects.requireNonNull(TestByteBuffer.class.getResource("data.txt")).getPath()).getChannel();
            // 准备缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            // 从channel 读取数据，向buffer写入
            channel.read(byteBuffer);
            // 打印 buffer 内容
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                System.out.println((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
