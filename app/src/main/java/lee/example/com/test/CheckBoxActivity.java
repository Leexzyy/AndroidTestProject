
package lee.example.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mcb5,mcb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mcb5 = findViewById(R.id.cb_5);
        mcb6 = findViewById(R.id.cb_6);


        mcb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                Toast.makeText(CheckBoxActivity.this,checked?"5选中":"5未选中",Toast.LENGTH_SHORT).show();

            }
        });
        mcb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                Toast.makeText(CheckBoxActivity.this,checked?"6选中":"6未选中",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
