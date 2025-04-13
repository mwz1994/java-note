package netty.tcp_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import static netty.tcp_demo.NettyServer.getThreadName;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    // 当通道就绪就会触发该方法

    @Override
    public void channelActive(ChannelHandlerContext ctx ) {
        System.out.println(getThreadName()+"client : "+ ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server : 我是 client-handler", CharsetUtil.UTF_8));
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(getThreadName()+"服务端回复的消息："+ byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(getThreadName()+"服务器的地址："+ ctx.channel().remoteAddress());
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
