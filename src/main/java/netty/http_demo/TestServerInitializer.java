package netty.http_demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        var pipeline = socketChannel.pipeline();

        // 加入一个 netty 提供的 httpServerCodec codec =>[coder - decoder]
        //HttpServerCodec 说明
        //1. HttpServerCodec 是netty 提供的处理http的 编-解码器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());
        System.out.println("ok~~~~");
    }
}
