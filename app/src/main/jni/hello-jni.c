//
// Created by Administrator on 2017/12/9.
//
#include <string.h>
#include <jni.h>
#include  <android/log.h>
#define  TAG    "JNITAG"
// 定义debug信息，其他级别的Log亦如此
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)

// 这就是JNI的规则，方法名必须是Java_包名_类名_方法名, 千万不要偷懒，Java的首字母一定要大些,包名之间要下划线
jstring Java_hellojni_hubin_com_hellojni_HelloJni_stringFromJNI( JNIEnv* env, jobject thiz ) {
    return (*env)->NewStringUTF(env, "Hello from JNI !");
}

jstring Java_hellojni_hubin_com_hellojni_HelloJni_stringFromJNI2( JNIEnv* env, jobject thiz ) {
    jstring str = "what a fucking good test";
    LOGD("str=%s", str);
    return (*env)->NewStringUTF(env, "Hello from JNI2 ! ");
}
