package hellojni.hubin.com.hellojni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView jni_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.e("hellojni", "onCreate: " + stringFromJNI());
        //Log.e("hellojni", "onCreate: " + stringFromJNI2());

        jni_text = (TextView) findViewById(R.id.jni_text);
        String text = HelloJni.getInstance().stringFromJNI();
        String text1 = HelloJni.getInstance().stringFromJNI2();
        jni_text.setText(text + "-" + text1);
    }

//    static {
//        System.loadLibrary("hello-jni");
//    }
//
//    public static native String stringFromJNI();
//    public static native String stringFromJNI2();

}
