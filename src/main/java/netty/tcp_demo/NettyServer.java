package netty.tcp_demo;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

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
    }
}
