package lee.example.com.test.broadcast_receiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import lee.example.com.test.Collector.BaseActivity;
import lee.example.com.test.R;
import lee.example.com.test.util.ToastUtil;

/**
 * @author Administrator
 * 用于实验强制下线的登陆模块
 */
public class LoginActivity extends BaseActivity {
    private EditText mEdAccount,mEdPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEdAccount = findViewById(R.id.account);
        mEdPassword = findViewById(R.id.password);
        mBtnLogin = findViewById(R.id.login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mEdAccount.getText().toString();
                String password = mEdPassword.getText().toString();
                String admin = "admin";
                String successPassword = "123456";
                if (account.equals(admin)&&password.equals(successPassword)){
                    Intent intent = new Intent(LoginActivity.this,LoginSuccessActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    ToastUtil.showMsg(LoginActivity.this,"登陆失败，密码错误！");
                }
            }
        });
    }
}
