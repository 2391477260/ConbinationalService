package com.hnust.serverproviderc;

/**
 * Created by javy on 2021/7/5 13:58
 */
public class JNIDemo {
    static {
        try{
            System.loadLibrary("JNIDemo_c");
        }
        catch(Throwable e){
            System.out.println("The load problem");
        }
    }
    public native void sayHello();

    public static void main(String[] args) {
        new JNIDemo().sayHello();
    }
}
