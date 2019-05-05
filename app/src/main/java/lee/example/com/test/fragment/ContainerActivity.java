package lee.example.com.test.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.R;

public class ContainerActivity extends AppCompatActivity {
    //实例化各个Fragment PS 可以在直接使用其他Java文件的class；
    private AFragment aFragment;
    private  BFragment bFragment;

    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnChange = findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (bFragment == null){
                bFragment = new BFragment();

            }
                //replace为更换一个Fragment；
                getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
            }
        });

        //实例化AFragment
//        aFragment = new AFragment();
        aFragment = AFragment.newInstance("我是参数");
        //把AFragment添加到Activity中,记得调用commitAllowingStateLoss
        //.add方法是添加一个Fragment
        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();
    }
}
