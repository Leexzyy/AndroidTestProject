package lee.example.com.test.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.util.Log;

import lee.example.com.test.R;
import lee.example.com.test.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);



        Log.d("AActivity","----------OnCreate-----------");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logtaskName();


        //显示跳转
        mBtnJump = findViewById(R.id.btn_jump1);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显式1
                Intent intent = new Intent(AActivity.this,BActivity.class);
               //传递数据 首先创建一组数据 然后用putExtra传递到BActivity中
                Bundle bundle = new Bundle();
                bundle.putString("name","运用putExtras在两个Activity里面传递数据");
                bundle.putInt("number",888);
                intent.putExtras(bundle);
//                startActivity(intent);

                startActivityForResult(intent,0);

                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);
                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"lee.example.com.test.jump.BActivity");
//                startActivity(intent);
                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"lee.example.com.test.jump.BActivity"));
//                startActivity(intent);

                //隐式
//                Intent intent = new Intent();
//                //里面的内容是在manifest里面设置activity 里面是字符串 其中category中要设置为DEFAULT
//                intent.setAction("lee.example.com.test.jump.BActivity");
//                startActivity(intent);
            }

        });


        mBtnJump2 = findViewById(R.id.btn_jump2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(this,data.getExtras().getString("title"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","----------onNewIntent-----------");
        Log.d("AActivity","taskid:"+getTaskId()+", hash:"+hashCode());
        logtaskName();
    }

    //设置一个打印当前任务栈的名称的方法！    没有设置任务栈名称是默认为包名
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
