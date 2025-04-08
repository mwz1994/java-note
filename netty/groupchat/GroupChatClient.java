package netty.groupchat;

import netty.nio.BasicBuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class GroupChatClient {
    private final String HOST = "127.0.0.1";//服务器的ip
    private final int PORT = 6667;//服务器端口
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST,PORT));
        // 设置为非阻塞
        socketChannel.configureBlocking(false);

        socketChannel.register(selector, SelectionKey.OP_READ);
        //得到 username
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + " is ok...");
    }

    public void sendInfo(String info){
        String msg = username + " 说： "+info;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        }catch (Exception e){
            System.out.println("ex when sendInfo "+e.getMessage());
        }
    }

    public void readInfo(){
        try {
            int readChannels = selector.select();
            if (readChannels>0){
                var iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();

                    if (key.isReadable()){
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

                        sc.read(byteBuffer);

                        var msg = new String(byteBuffer.array());

                        System.out.println("client read msg is --> "+ msg);
                    }
                }
                iterator.remove();
            }else {
                System.out.println("没有可用的通道");
            }

        }catch (Exception e){
            System.out.println("ex when read info "+ e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        GroupChatClient chatClient = new GroupChatClient();

        new Thread(() -> {
            while (true){
                chatClient.readInfo();
                try {
                    Thread.sleep(1000*3);
                }catch (Exception e){
                    System.out.println("sleep ex");
                }
            }
        }).start();


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            chatClient.sendInfo(scanner.next());
        }
    }
}
