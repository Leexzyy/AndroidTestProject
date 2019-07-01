package lee.example.com.test.broadcast_receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import lee.example.com.test.util.ToastUtil;

/**
 * @author Administrator
 * 静态的广播接收器
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {

        ToastUtil.showMsg(context,"Boot Complete");
        Log.d("onReceive", "onReceive: ");
    }
}
