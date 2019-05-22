package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import lee.example.com.test.fragment.AFragment;
import lee.example.com.test.fragment.ContainerActivity;
import lee.example.com.test.jump.AActivity;

public class ActActivity extends AppCompatActivity {

    private Button mBtnLife;
    private Button mBtnJump;
    private Button mBtnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        mBtnLife=findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);
        setListeners();
    }
    //设置监听器，每个控件设置点击事件

    private void setListeners() {
      OnClick onClick = new OnClick();
      mBtnLife.setOnClickListener(onClick);
      mBtnJump.setOnClickListener(onClick);
      mBtnFragment.setOnClickListener(onClick);
    }
    //点击事件

    @SuppressWarnings("AlibabaSwitchStatement")
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            //noinspection AlibabaSwitchStatement
            switch (v.getId()){

                case R.id.btn_lifecycle:
                    intent = new Intent(ActActivity.this,LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(ActActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(ActActivity.this, ContainerActivity.class);
                    break;
                default:
            }
            startActivity(intent);

        }
    }
}
