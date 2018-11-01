package com.harlan.netty.six.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Message msg) throws Exception {
        DataInfo.Message.DataType dataType = msg.getDataType();

        if(dataType == DataInfo.Message.DataType.StudentType){
            DataInfo.Student student = msg.getStudent();

            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddress());
        }else if(dataType == DataInfo.Message.DataType.DogType){
            DataInfo.Dog dog = msg.getDog();

            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else{
            DataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
