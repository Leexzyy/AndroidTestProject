package lee.example.com.test;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTV4;
    private TextView mTV5;
    private  TextView mTV6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTV4 = findViewById(R.id.tv_4);
        mTV4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mTV4.getPaint().setAntiAlias(true);//去除锯齿

        mTV5 = findViewById(R.id.tv_5);
        mTV5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mTV6 = findViewById(R.id.tv_6);
        mTV6.setText(Html.fromHtml("<u>text<u>"));

    }
}
