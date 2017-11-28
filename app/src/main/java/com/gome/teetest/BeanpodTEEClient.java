package com.gome.teetest;

/**
 * Created by jiamei on 6/26/15.
 */
public class BeanpodTEEClient {
    public static final int ENCRYPT = 0x10003;
    public static final int DECRYPT = 0x10004;

    static {
        System.loadLibrary("mtee");
        System.loadLibrary("teeclientsoft");
    }

//    public static native byte[] bigIntAdd();

//    public static native byte[] invokeCmd(int cmd, byte[] input, int length);
    public static native byte[] invokeCmd(int cmd, byte[] input, int length);
}
