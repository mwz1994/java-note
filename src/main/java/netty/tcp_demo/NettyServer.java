package netty.tcp_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) {
        // 创建 BossGroup 和 WorkerGroup
        // 说明
        // 1.创建两个线程组 bossGroup 和 workGroup
        // 2.bossGroup 只处理连接请求，真正和客户端业务处理，交给 workerGroup完成
        // 3.两个都是无限循环
        // 4. bossGroup 和 workerGroup 含有的子线程（NioEventLoop ）个数
        // 默认实际 cpu 核数*2

        var nThreads = Runtime.getRuntime().availableProcessors() * 2;

        System.out.println("default threads --> "+ nThreads);

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            // 创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 使用链式编程
            bootstrap.group(bossGroup, workerGroup) // 设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用 NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG,128) // 设置线程队列得到链接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动链接
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("客户 socketchannel hashcode = " + ch.hashCode());
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    }); // 给我们的 workerGroup 的 eventLoop 对应的管道设置处理器

            System.out.println("....服务器 is ready....");

            // 绑定一个端口并且同步，生成了一个 ChannelFuture
            ChannelFuture cf = bootstrap.bind(6668).sync();

            // 给 cf 注册监听器，监控我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (cf.isSuccess()){
                        System.out.println("监听端口 6668 成功");
                    }else {
                        System.out.println("监听端口 6668 失败");
                    }
                }
            });
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
