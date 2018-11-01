package com.harlan.netty.first;

import io.netty.channel.ChannelInitializer;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class ServerInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pippeline = socketChannel.pipeline();

        pippeline.addLast("HttpServerCodec",new HttpServerCodec());
        pippeline.addLast("HttpServerHandler",new HttpServerHandler());

    }
}
