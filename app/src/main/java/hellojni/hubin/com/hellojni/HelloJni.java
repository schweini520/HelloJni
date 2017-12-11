package hellojni.hubin.com.hellojni;

/**
 * Created by Administrator on 2017/12/11.
 */

public final class HelloJni {
    private static HelloJni helloJni;
    private HelloJni ()
    {
        System.loadLibrary("hello-jni"); //不要写成libhello-jni, studio已经帮你做好了
    }
    public static HelloJni getInstance()
    {
        if (null == helloJni)
        {
            helloJni = new HelloJni();
        }
        return helloJni;
    }
    public native String stringFromJNI();
    public native String stringFromJNI2();
}
