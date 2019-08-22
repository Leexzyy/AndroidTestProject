package lee.example.com.test.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lee.example.com.test.main.ActActivity;
import lee.example.com.test.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private Button mBtnFinish,mBrnJump;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("AActivity","----------OnCreate-----------");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logtaskName();

        mTvTitle = findViewById(R.id.tv_title);
        mBtnFinish = findViewById(R.id.btn_finish);
        mBrnJump = findViewById(R.id.btn_JumpA);


        Bundle bundle = getIntent().getExtras();
       String name =  bundle.getString("name");
       int number =   bundle.getInt("number");
       mTvTitle.setText(name+","+number);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               Bundle bundle1 = new Bundle();
               bundle1.putString("title","BActivity的值传回");
               intent.putExtras(bundle1);
           setResult(ActActivity.RESULT_OK,intent);
           finish();
           }
       });

       mBrnJump.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(BActivity.this,AActivity.class);
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----------onNewIntent-----------");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logtaskName();
    }

    //设置一个打印当前任务栈的名称的方法！
    protected void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            //taskAffinity 就是task关系 也可以理解为名称
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
