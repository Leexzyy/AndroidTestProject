package lee.example.com.test.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.R;

public class ContainerActivity extends AppCompatActivity {
    //实例化各个Fragment PS 可以在直接使用其他Java文件的class；
    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //实例化AFragment
//         aFragment = new AFragment();
        //在实列化时传一个参数（这个方法在aFragment中）
        aFragment = AFragment.newInstance("我是参数（AFragment）");
        //把AFragment添加到Activity中,记得调用commitAllowingStateLoss
        //.add方法是添加一个Fragment  添加了一个tag a 在后面需要找到这个tag进行判断以及操作
        getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }
}
