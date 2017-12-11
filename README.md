# HelloJni
i下载安装studio, ndk, jdk这些步骤就免了。（我的环境是win7, studio 3.0.1, NDK r16, jdk1.8.0.51， gradle 3.0.1）
工具升级到最新版本总是不错的，旧版本可能不支持。所以建议版本过低的可以先升级后操作。
通过studio SDK Manager下载最新的NDK和cmake,可以免掉makefile，直接build apk便会产生so文件，直接调用。

1. 新建一个android工程（工程名HelloJni, 包名com.hubin.hellojni），在app/src/main根目录下新建jni目录
2. 在project的local.properties, 增加一行, 其实就是NDK的根目录:
   ndk.dir=E\:\\androidsdk\\studiosdk\\studiosdk\\ndk-bundle
   一般情况下，通过studio下载了NDK会自动帮你加上去，如果没有就手动添加
3. 在jni目录下新建C文件，编写c代码. 如我写了一个叫hello-jni.c， 内容如下
4. C文件写好了，在java代码写native方法：
5. c代码和java native代码也写好了，是时候编译了，在jni目录下新建文件：CMakeLists.txt, 内容如下：
6. 修改在app下的build.gradle，增加以下内容:
7. 在android中调用native方法
8. 编译运行, Build-->Clean Project
                      Build-->Build APK
   或gradlew clean
       gradlew assembleDebug 
  编译后，会在app/build/intermediates/cmake/arm7/debug/obj/armeabi-v7a目录下生成libhello-jni.so
  安装APK，运行会看到期望的结果。
9. 打印JNI日志, 在.c文件的头部加入
   #include  <android/log.h>
   #define  TAG    "JNITAG"
   // 定义debug信息，其他级别的Log亦如此
   #define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
   在方法中直接调用LOGD
   jstring str = "what a fucking good test";
   LOGD("str=%s", str);
   在studio logcat窗口过滤JNITAG即可看到JNI log

