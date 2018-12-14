package lee.example.com.test.gridview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import lee.example.com.test.R;

/***

 *Create By Lee  On 2018/12/14

 **/
public class GridViewActivity extends AppCompatActivity {
    private GridView mGV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGV = findViewById(R.id.gv);
        mGV.setAdapter(new MyGridViewAdapter(GridViewActivity.this));



    }

}
