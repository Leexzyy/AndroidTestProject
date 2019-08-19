package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.didichuxing.doraemonkit.DoraemonKit;

import lee.example.com.test.camera.CameraAlbumActivity;
import lee.example.com.test.broadcast_receiver.BroadcastUiActivity;
import lee.example.com.test.datastorage.DataStorageActivity;
import lee.example.com.test.notification.NotificationActivity;
import lee.example.com.test.util.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnAct,mBtnEvrnt,mBtnView,mBtnData,mBtnBroadcast,mBtnNotification,mBtnCamera;
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnAct = findViewById(R.id.btn_act);
        mBtnEvrnt = findViewById(R.id.btn_event);
        mBtnView = findViewById(R.id.btn_view);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);
        mBtnNotification = findViewById(R.id.btn_notification);
        mBtnCamera = findViewById(R.id.btn_camera);


        DoraemonKit.install( getApplication());
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnAct.setOnClickListener(onClick);
        mBtnEvrnt.setOnClickListener(onClick);
        mBtnView.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnNotification.setOnClickListener(onClick);
        mBtnCamera.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case  R.id.btn_act:
                    intent = new Intent(MainActivity.this, ActActivity.class);
                    break;
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this,UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_view:
                    intent = new Intent(MainActivity.this,ViewActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadcastUiActivity.class);
                    break;
                case R.id.btn_notification:
                    intent = new Intent(MainActivity.this, NotificationActivity.class);
                    break;
                case R.id.btn_camera:
                    intent = new Intent(MainActivity.this, CameraAlbumActivity.class);
                    break;
                default:
            }
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() ==KeyEvent.ACTION_DOWN){
            int s = 2000;
            if ((System.currentTimeMillis()-exitTime> s)){
                ToastUtil.showMsg(MainActivity.this,"再按一次退出程序");
                exitTime = System.currentTimeMillis();
            }else {
                    finish();
                    System.exit(0);
            }
        }return true;
    }
}
