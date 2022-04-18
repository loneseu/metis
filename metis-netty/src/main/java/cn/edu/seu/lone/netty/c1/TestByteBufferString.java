package cn.edu.seu.lone.netty.c1;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

import static cn.edu.seu.lone.netty.c1.ByteBufferUtil.debugAll;

public class TestByteBufferString {
    public static void main(String[] args) {
        // 1.字符串转为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello1".getBytes());
        debugAll(buffer);

        // 2. Charset
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello2");
        debugAll(buffer1);

        // 3.wrap
        ByteBuffer buffer2 = ByteBuffer.wrap("hello3".getBytes());
        debugAll(buffer2);

        // 4.转为字符串

        String str1 = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println(str1);

        buffer.flip();
        String str = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str);
    }
}
