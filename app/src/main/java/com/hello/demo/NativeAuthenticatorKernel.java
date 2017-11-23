package com.hello.demo;

/**
 * Created by jiamei on 6/26/15.
 */
public class NativeAuthenticatorKernel {
    static {
        System.loadLibrary("mtee");
        System.loadLibrary("teeclientsoft");
    }

    public static native byte[] bigIntAdd();

    public static native byte[] invokeCmd(int cmd, byte[] input, int length);
}
