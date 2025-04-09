package netty.copy;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LegacyIOClient {
    public static void main(String[] args) throws IOException {

        String filename = "/Users/wenzhenma/Downloads/googlechrome.dmg";;
        InetSocketAddress address = new InetSocketAddress(7002);
        Socket socket = new Socket();
        socket.bind(address);

        try (
                FileInputStream inputStream = new FileInputStream(filename);
                OutputStream outputStream = socket.getOutputStream();
                ){
            byte[] bytes = new byte[512];


            int readCount;
            int sumCount = 0;

            var startTime = System.currentTimeMillis();

            while ( (readCount = inputStream.read(bytes) ) != -1){
                sumCount += readCount;
                outputStream.write(bytes, 0 , readCount);
            }

            outputStream.flush();

            System.out.println("发送的总的字节数 = "+ sumCount + " 耗时: " + (System.currentTimeMillis() - startTime));
        }
    }
}
