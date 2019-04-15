package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import lee.example.com.test.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPop;
    private PopupWindow mPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView = view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this,"好");
                    }
                });
                //（view，宽度，wrap_content）
            mPop = new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
            //点击外部区域自动关闭popup
            mPop.setOutsideTouchable(true);
            //点击POP按钮打开 再点一次关闭
            mPop.setFocusable(true);
            //显示在mBtnPop控件上方或下方
            mPop.showAsDropDown(mBtnPop);
            }
        });

    }
}
