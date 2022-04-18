package cn.edu.seu.lone.netty.c1;

import java.nio.ByteBuffer;

import static cn.edu.seu.lone.netty.c1.ByteBufferUtil.debugAll;

public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();
        // 从头开始头
        buffer.get(new byte[4]);
        debugAll(buffer);
        buffer.rewind();
        //System.out.println(buffer.get());

        // mark & reset
        // mark 做一个标记，记录position位置，reset 是将 position 重置到 mark 的位置

//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        buffer.mark();
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());
//        buffer.reset();
//        System.out.println(buffer.get());
//        System.out.println(buffer.get());

        // get(i) 不会改变读索引的位置
        System.out.println(buffer.get(3));
        debugAll(buffer);

    }
}
