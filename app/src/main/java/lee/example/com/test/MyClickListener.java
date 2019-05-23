package lee.example.com.test;

import android.app.Activity;
import android.view.View;

import lee.example.com.test.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;
    //构造方法 这个是传入Activity 可以增加其他的 比如文字或者输入框
    public MyClickListener(Activity activity){
        this.mActivity = activity;
    }
    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(mActivity,"通过外部类实现click....");

    }
}
