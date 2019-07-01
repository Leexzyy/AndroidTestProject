package lee.example.com.test.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import lee.example.com.test.util.ToastUtil;

/**
 * @author Administrator
 * 先定义一个广播接收器来接收次广播
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        /* 当收到广播会弹一个Toast； */
        ToastUtil.showMsg(context,"received in MyBroadcastReceiver");
        //有序广播被截断
        abortBroadcast();
    }
}
