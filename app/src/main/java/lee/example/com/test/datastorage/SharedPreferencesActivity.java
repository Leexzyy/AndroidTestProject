package lee.example.com.test.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lee.example.com.test.R;

/**
 * @author Administrator
 */
public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;

    /**申明SharedPreferences和editor （SharedPreferences）是读 ，（SharedPreferences.Editor）是写！*/
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_content);

        //MODE_PRIVATE只有在本应用中进行读写 也是最常用的 ,MODE_WORLD_READABLE等已经废弃了 MODE_APPEND文件已经有了 往末尾追加去写入的过程
        //使用getSharedPreferences去实列化mSharedPreferences
        mSharedPreferences = getSharedPreferences("Data",MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在EtName中得到text文字 然后put到mEditor，第一个是key 第二个是值
                mEditor.putString("Name",mEtName.getText().toString());
                //commit提交也可以用apply() apply()是异步存储过程 建议优先使用apply
                mEditor.apply();
            }
        });


        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                在tv_content得到文字就是读的方法 需要setText 应用mSharedPreferences 第一个是key 第二个可以写空 就是没有值的时候显示什么
                mTvContent.setText(mSharedPreferences.getString("Name",""));
            }
        });
    }
}
