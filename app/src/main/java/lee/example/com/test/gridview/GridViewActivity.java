package lee.example.com.test.gridview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
        mGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"点击 pos："+position,Toast.LENGTH_SHORT).show();
            }
        });
        mGV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"长按 pos："+position,Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }

}
