package com.tool.collect.skytools.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/5/14 下午2:05
 **/
public class DemoClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" , "+s);
        System.out.println("client output: " + s);
        ctx.channel().writeAndFlush("from client" + LocalDateTime.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自客户端的问候");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
