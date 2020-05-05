package com.example.test;

import com.sun.jna.Native;

public class Helixcs {
    static {
        Native.register("c");
    }
    // 映射为本地方法
    public static  native void someFunction(String content);

    public static void main(String[] args) {
        someFunction("Hello World");
    }
}
