package com.harlan.netty;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

public class Test {
    public static void main(String[] args) {
        int num = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(isPowerOfTwo(3));
    }

    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }
}
