package lee.example.com.test.broadcast_receiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.Collector.BaseActivity;
import lee.example.com.test.R;

/**
 * @author Administrator
 * 点击按钮触发离线广播
 */
public class LoginSuccessActivity extends BaseActivity {
    private Button mBtnOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        mBtnOffline = findViewById(R.id.force_offline);
        mBtnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("lee.example.com.test.broadcast_receiver.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }
}
