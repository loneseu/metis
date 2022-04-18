package cn.edu.seu.lone.netty.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        // FileChannel
        // 1.输入输出流 2. RandomAccessFile
        try {
            FileChannel channel = new FileInputStream("metis-netty/data.txt").getChannel();
            // 准备缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            while (true) {
                // 从channel 读取数据，向buffer写入
                int len = channel.read(byteBuffer);
                log.info("读取到的字节数 {}", len);
                if (len == -1) {
                    break;
                }
                // 打印 buffer 内容
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    log.info("实际字节 {}", (char)b);
                }
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
