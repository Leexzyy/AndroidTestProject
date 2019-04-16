package lee.example.com.test.jump;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lee.example.com.test.ActActivity;
import lee.example.com.test.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private Button mBtnFinish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvTitle = findViewById(R.id.tv_title);
        mBtnFinish = findViewById(R.id.btn_finish);


        Bundle bundle = getIntent().getExtras();
       String name =  bundle.getString("name");
       int number =   bundle.getInt("number");
       mTvTitle.setText(name+","+number);

       mBtnFinish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               Bundle bundle1 = new Bundle();
               bundle1.putString("title","BActivity的值传回");
               intent.putExtras(bundle1);
           setResult(ActActivity.RESULT_OK,intent);
           finish();
           }
       });
    }
}
