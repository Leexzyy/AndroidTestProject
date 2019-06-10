package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import lee.example.com.test.pieview.PieData;
import lee.example.com.test.pieview.PieView;

public class PieViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pie_view);
        //新建视图 将PieView放入activity的视图中
        PieView view = new PieView(this);
        setContentView(view);
        //添加数据
        ArrayList<PieData> datas = new ArrayList<>();
        PieData pieData = new PieData("Lee",60);
        PieData pieData2 = new PieData("Lee",30);
        PieData pieData3 = new PieData("Lee",40);
        PieData pieData4 = new PieData("Lee",20);
        PieData pieData5 = new PieData("Lee",20);



        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
        view.setData(datas);

    }
}
