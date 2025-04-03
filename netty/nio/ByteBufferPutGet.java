package netty.nio;

import java.nio.ByteBuffer;

public class ByteBufferPutGet {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(100);
        byteBuffer.putLong(9);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short) 2);


        byteBuffer.flip();

        System.out.println("-------------");

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());

    }
}
