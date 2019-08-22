package lee.example.com.test.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.HandlerActivity;
import lee.example.com.test.MyClickListener;
import lee.example.com.test.R;
import lee.example.com.test.util.ToastUtil;
import lee.example.com.test.widget.MyButton;

/**
 * @author Administrator
 * 此Activity包含监听事件的
 */
public class EventActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button mBtnEve,mBtnHandler;
    private MyButton btnMy;
//当同一个事件源设置了多个监听器 系统只会执行最后一个监听器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEve = findViewById(R.id.btn_eve);
        btnMy = findViewById(R.id.btn_my);
        mBtnHandler = findViewById(R.id.btn_handler);

        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("listener", "----onClick----");
            }
        });


        /**从log中可以发现会优先执行监听里面的回调方法 然后在执行Button内部的方法  然后再执行Activity里面的回调方法**/
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("listener", "----onTouch:----- ");
                        break;
                        default:
                }
                return false;
            }
        });

//       // 通过内部类实现事件
        mBtnEve.setOnClickListener(new onClick());
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

//    //通过控件的onClick属性实现onClick事件
//    public void show(View v){
//        switch (v.getId()){
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this,"通过内部类实现事件。。。。");
//                break;
//                default:
//        }
//    }

//重写onTouchEvent
    /**首先在控件内部进行回调 回调完之后再进入activity中进行回调 ，事件是向外传播的 由Button本身向外传播 如果在Button中将返回return false;改为ture
     * 则这个返回值就在此处被消费了 不会接着向外面传递 则不会传递到activity中的 回调方法中
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "-----onTouchEvent-----");
            break;
            default:
        }
        return false;
    }


}
