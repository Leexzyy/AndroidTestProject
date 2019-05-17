package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.didichuxing.doraemonkit.DoraemonKit;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI;
    private Button mBtnAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnAct = findViewById(R.id.btn_act);

        DoraemonKit.install(getApplication());
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnAct.setOnClickListener(onClick);
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
            }
            startActivity(intent);
        }
    }
}
