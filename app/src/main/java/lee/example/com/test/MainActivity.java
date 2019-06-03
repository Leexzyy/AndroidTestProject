package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.didichuxing.doraemonkit.DoraemonKit;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnAct,mBtnEvrnt,mBtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnAct = findViewById(R.id.btn_act);
        mBtnEvrnt = findViewById(R.id.btn_event);
        mBtnView = findViewById(R.id.btn_view);


        DoraemonKit.install( getApplication());
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnAct.setOnClickListener(onClick);
        mBtnEvrnt.setOnClickListener(onClick);
        mBtnView.setOnClickListener(onClick);
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
                default:
            }
            startActivity(intent);
        }
    }
}
