package netty.tcp_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

import static netty.tcp_demo.NettyServer.getThreadName;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    // 读取数据实际（这里我们可以读取客户端发送的消息）
    /**
     * 1. ChannelHandlerContext ctx:上下文对象，含有管道 pipeline, 通道 channel , 地址
     * 2. Object msg: 就是客户端发送的数据 默认 Object
     *
     */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        System.out.println(getThreadName()+"服务器读取线程 "+ Thread.currentThread().getName() + " channel = " + ctx.channel());

        System.out.println(getThreadName()+"server ctx = "+ ctx);

        System.out.println(getThreadName()+"看看 channel 和 pipeline 的关系");

        Channel channel = ctx.channel();

        ChannelPipeline pipeline = ctx.pipeline(); // 本质是一个双向链接，出站入站

        // 将 msg 转为一个 ByteBuf
        // ByteBuf 是 netty 提供的，不是 NIO 的 ByteBuffer
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println(getThreadName()+"客户端发送信息: " + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(getThreadName()+"客户端地址: " + channel.remoteAddress());
    }


    //数据读写完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        // writeAndFlush 是 write+ flush
        // 数据写入到缓存，并刷新
        // 一般讲 我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端～～ ", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
