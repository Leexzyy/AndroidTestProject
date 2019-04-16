package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {


    //onCreate()在活动第一次创建时被调用，主要用于加载布局 ps：创建
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle ","-----onCreate-----");
    }

   // onStart()这个方法在活动由不可见变为可见的时候调用。 ps：开始

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle ","-----onStart-----");
    }

    //onResume这个方法在活动准备好和用户进行交互的时候调用。此时的活动一定位于返回栈的栈顶，并且处于运行状态.
    // ps：继续（其实就是相当于准备完成可以进行交互了）
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle ","-----onResume-----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle ","-----onPause-----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle ","-----onStop-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle ","-----onRestart-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle ","-----onCreate-----");
    }
}
