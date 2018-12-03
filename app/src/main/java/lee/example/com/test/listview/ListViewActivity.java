package lee.example.com.test.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import lee.example.com.test.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView mlv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(lee.example.com.test.R.layout.activity_list_view);
        mlv1 = findViewById(R.id.lv_1);
        mlv1.setAdapter(new MyListAdapter(ListViewActivity.this));

    }
}
