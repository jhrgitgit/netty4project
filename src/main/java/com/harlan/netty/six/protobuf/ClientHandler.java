package com.harlan.netty.six.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ClientHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Message mes) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt = new Random().nextInt(3);

        DataInfo.Message message = null;

        if(0 == randomInt){
            message = DataInfo.Message.newBuilder().setDataType(DataInfo.Message.DataType.StudentType).setStudent
                    (DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("北京")).build();
        }else if (1 == randomInt){
            message = DataInfo.Message.newBuilder().setDataType(DataInfo.Message.DataType.DogType).setDog
                    (DataInfo.Dog.newBuilder().setName("狗").setAge(20)).build();
        }else{
            message = DataInfo.Message.newBuilder().setDataType(DataInfo.Message.DataType.DogType).setCat
                    (DataInfo.Cat.newBuilder().setName("猫").setCity("上海")).build();
        }

         ctx.channel().writeAndFlush(message);
    }
}
