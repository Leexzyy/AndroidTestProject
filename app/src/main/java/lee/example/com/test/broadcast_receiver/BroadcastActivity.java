package lee.example.com.test.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lee.example.com.test.R;
import lee.example.com.test.util.ToastUtil;

public class BroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    //声明一个内部类 继承自BroadcastReceiver 重写onReceive方法
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        intentFilter = new IntentFilter();
        //添加了一个值为android.net.conn.CONNECTIVITY_CHANGE的action ，因为网络发生变化是传播的值为android.net.conn.CONNECTIVITY_CHANGE。
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //创建networkChangeReceiver的实列
        networkChangeReceiver = new NetworkChangeReceiver();
        //调用registerReceiver 将networkChangeReceiver和intentFilter的实列传入
        // 这样networkChangeReceiver就会收到所有值为android.net.conn.CONNECTIVITY_CHANGE的广播
        registerReceiver(networkChangeReceiver,intentFilter);
    }

    // 取消注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ToastUtil.showMsg(context,"network changes");
        }
    }
}
