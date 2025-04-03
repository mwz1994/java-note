package netty.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferReadOnly {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 1; i < 64; i++) {
            byteBuffer.put((byte) (i*3));
        }

        byteBuffer.flip();

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        System.out.println("class is --> "+ readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()){
            byte item = readOnlyBuffer.get();
            int i = item;
            System.out.println("read only buffer --> "+ i);
        }

//        readOnlyBuffer.put((byte) 100);
    }
}
