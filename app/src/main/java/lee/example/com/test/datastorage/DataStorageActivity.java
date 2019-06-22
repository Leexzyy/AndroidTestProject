package lee.example.com.test.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSharedPreferences,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this,FileActivity.class);
                break;
                default:
        }
        startActivity(intent);
    }
}
