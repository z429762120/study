package com.tool.collect.skytools.netty;

import java.util.UUID;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/5/14 下午2:05
 **/
public class DemoServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" , "+s);
        ctx.channel().writeAndFlush("from server" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
