package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.broadcast_receiver.BroadcastActivity;

/**
 * @author Administrator\
 *1、Broadcast广播各类方法入口
 *2、按发送按钮 发送"lee.example.com.test.MY_BROADCAST"的广播 然后被MyBroadcastReceiver接收到 弹出Toast，
 *3、在另外一个程序收到"lee.example.com.test.MY_BROADCAST"的广播弹窗
 *4、当广播为有序广播时在MyBroadcastReceiver中被截断
 */
public class BroadcastUiActivity extends AppCompatActivity {
    private Button mBtnReceive,mBtnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_ui);
        mBtnReceive = findViewById(R.id.btn_receive);
        mBtnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BroadcastUiActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        mBtnSend = findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("lee.example.com.test.MY_BROADCAST");
                //发送标准广播
//                sendBroadcast(intent);
                //发送有序广播
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
