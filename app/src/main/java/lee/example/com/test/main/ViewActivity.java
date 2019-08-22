package lee.example.com.test.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.PieViewActivity;
import lee.example.com.test.R;

public class ViewActivity extends AppCompatActivity {
    private Button mBtnPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mBtnPie = findViewById(R.id.btn_pie);
        OnClick onClick = new OnClick();

        mBtnPie.setOnClickListener(onClick);
    }


    class OnClick implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_pie:
                    intent = new Intent(ViewActivity.this, PieViewActivity.class);
                    break;
                   default:
            }
            startActivity(intent);
        }
    }
}
