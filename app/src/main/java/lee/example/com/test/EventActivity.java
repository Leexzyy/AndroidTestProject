package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.util.ToastUtil;

public class EventActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button mBtnEve;
//当同一个事件源设置了多个监听器 系统只会执行最后一个监听器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEve = findViewById(R.id.btn_eve);
//       // 通过内部类实现事件
//        mBtnEve.setOnClickListener(new onClick());
//        //匿名内部类
//        mBtnEve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this,"通过匿名内部类实现事件。。。。");
//
//            }
//        });
//        通过事件源所在的类实现
//        mBtnEve.setOnClickListener(EventActivity.this);
//        通过外部类去实现
        mBtnEve.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    //通过事件源所在的类实现
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_eve:
                ToastUtil.showMsg(EventActivity.this,"通过activity实现事件（通过事件源所在的类实现）");
                break;
            default:

        }
    }

    //通过内部类实现事件
    class onClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_eve:
                    ToastUtil.showMsg(EventActivity.this,"通过内部类实现事件。。。。");
                    break;


                    default:

            }

        }
    }
}
