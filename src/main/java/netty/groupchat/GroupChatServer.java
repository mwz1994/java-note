package netty.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private final static int PORT = 6667;


    public GroupChatServer() {
        try {
            // 得到选择器
            selector  = Selector.open();

            serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        }catch (Exception e){
            System.out.println("ex when start group-chat server "+ e.getMessage());
        }
    }

    public void listen(){
        try{
            while (true){
                int count = selector.select();
                if (count>0){ // 有事件需要处理
                    // 遍历得到 keys 集合
                    var iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        // 取出 key
                        SelectionKey key = iterator.next();
                        // 监听 accept
                        if (key.isAcceptable()){
                            SocketChannel sc = serverSocketChannel.accept();
                            sc.configureBlocking(false);
                            // 将该 sc 注册到 selector
                            sc.register(selector,SelectionKey.OP_READ );
                            System.out.println("sc "+ sc.getRemoteAddress()+ " 上线了");
                        }
                        if (key.isReadable()){
                            // 处理读
                            readData(key);
                        }

                        iterator.remove();
                    }
                }else {
                    System.out.println("等待。。。");
                }
            }
        }catch (Exception e){
            System.out.println("ex when listen "+ e.getMessage());
        }finally {
            System.out.println("this is finally print");
        }
    }

    public void readData(SelectionKey key){
        SocketChannel channel = null;
        try {
            // 得到 channel
            channel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);

            int count = channel.read(byteBuffer);
            if (count>0){
                // 缓冲区数据转为字符串
                String str = new String(byteBuffer.array());
                // 输出该消息
                System.out.println("from客户端 "+ str);
                sendMsgToOtherClients(str, channel);
            }
        }catch (Exception e){
            System.out.println("ex when read data "+ e.getMessage());
            try {
                System.out.println(channel.getRemoteAddress() + "离线了..");
                key.cancel();
                //关闭通道
                channel.close();
            }catch (Exception ex){
                System.out.println("ex when read data "+ ex.getMessage());
            }
        }

    }

    //转发消息给其它客户(通道)
    private void sendMsgToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中...");
        for (var key : selector.keys()){
            Channel targetChannel = key.channel();

            // 排除自己
            if (targetChannel instanceof SocketChannel && targetChannel!=self){
                // 转型
                SocketChannel dst = (SocketChannel) targetChannel;

                // msg 写到 buffer
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                dst.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }


}
