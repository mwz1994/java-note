package netty.tcp_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import static netty.tcp_demo.NettyServer.getThreadName;

public class MainReactorModel {
    public static void main(String[] args) {
        // 主Reactor，用于接受连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 从Reactor，用于处理连接后的读写操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            System.out.println(getThreadName()+"init channel, addLast");
                            // 在这里添加业务处理器，如解码器、编码器、业务逻辑处理器
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            ChannelFuture future = bootstrap.bind(6669).sync();
            System.out.println(getThreadName()+"Server started at port 8080");
            future.channel().closeFuture().sync(); // 等待服务器关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

