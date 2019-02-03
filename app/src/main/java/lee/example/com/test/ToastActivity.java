package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import lee.example.com.test.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        //新建一个Onclick 用的是自定义的点击事件
        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);

    }
    //自定义点击事件
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            //监听点击的控件id
            case R.id.btn_toast_1:
                Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_toast_2:
                //Toast居中
                Toast toastCenter = Toast.makeText(getApplicationContext(),"Toast居中",Toast.LENGTH_SHORT);
                //Toast居中关键代码
                toastCenter.setGravity(Gravity.CENTER,0,0);
                toastCenter.show();
                break;
            case R.id.btn_toast_3:
                Toast toastCustom = new Toast(getApplicationContext());
                LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                View view = inflater.inflate(R.layout.layout_toast,null);
                ImageView imageView = view.findViewById(R.id.iv_toast);
                TextView textView = view.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.password);
                textView.setText("自定义Toast");
                toastCustom.setView(view);
                toastCustom.setDuration(Toast.LENGTH_SHORT);
                toastCustom.show();
                break;
            case R.id.btn_toast_4:
                //调用自己封装好的Toast
                ToastUtil.showMsg(getApplicationContext(),"包装过的toast，不会排队显示Toast");
                break;
        }
        }
    }
}
