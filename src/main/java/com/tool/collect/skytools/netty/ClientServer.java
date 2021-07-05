package com.tool.collect.skytools.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/5/14 下午2:17
 **/
public class ClientServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new DemoClientHandler());

                    }
                });
        try {
            final ChannelFuture future = bootstrap.connect("localhost",8889).sync();
            future.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
