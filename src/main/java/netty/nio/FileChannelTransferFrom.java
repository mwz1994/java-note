package netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileChannelTransferFrom {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/wenzhenma/Desktop/1719907396609_54.png");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wenzhenma/Desktop/1719907396609_54_copy.png");


        var inputStreamChannel = fileInputStream.getChannel();
        var outputStreamChannel = fileOutputStream.getChannel();

        // 使用 transferFrom 完成拷贝
        outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());

        fileOutputStream.close();
        fileInputStream.close();
        inputStreamChannel.close();
        outputStreamChannel.close();

        System.out.println("拷贝完成");
    }
}
