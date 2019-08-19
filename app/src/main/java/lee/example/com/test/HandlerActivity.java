package lee.example.com.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lee.example.com.test.util.ToastUtil;

/**
 * @author Administrator
 */
public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
            mHandler = new Handler();
            //延迟跳转 或者是延迟执行某一段代码
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
                    startActivity(intent);
                }
            }, 3000);


                mHandler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        switch (msg.what){
                            case 1:
                                ToastUtil.showMsg(HandlerActivity.this,"利用Handler线程通讯成功");
                                break;
                                default:
                        }
                    }
                };

                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        Message message = new Message();
                        message.what = 1;
                        mHandler.sendMessage(message);
                    }
                }.start();

    }
}
