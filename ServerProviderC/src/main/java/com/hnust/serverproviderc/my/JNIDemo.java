package com.hnust.serverproviderc.my;

/**
 * Created by javy on 2021/5/30 15:09
 */
public class JNIDemo {
    static {
        try{
            System.load("G://IdeaProjects//CombinationalService//ServerProviderC//src//main//java//com//hnust//serverproviderc//my//JNI_sayhello.dll");
        }
        catch(Throwable e){
            System.out.println("The load problem");
            System.out.println(e);
        }
    }
    public static native void sayHello();
    public static native String Hello(String str);

    public static void main(String[] args) {
        System.out.println(new JNIDemo().Hello("sad"));
        //new JNIDemo().sayHello();
    }

}
