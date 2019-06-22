package lee.example.com.test.datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lee.example.com.test.R;

public class FileActivity extends AppCompatActivity {
    private EditText mEtFileName;
    private Button mBtnFileSave,mBtnFileShow;
    private TextView mTvContent;
    private final String mFileName ="Lee.text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mEtFileName = findViewById(R.id.et_filename);
        mBtnFileSave = findViewById(R.id.btn_filesave);
        mBtnFileShow = findViewById(R.id.btn_file_show);
        mTvContent = findViewById(R.id.tv_filecontent);

        mBtnFileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用Save方法 将mEtFileName内容发送到save方法中 .trim（）的含义是去除前后空格
                save(mEtFileName.getText().toString().trim());
            }
        });

        mBtnFileShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });

    }
    //【1】先自定义一个方法用来存储数据
    private void save(String content){
        //申明变量
        FileOutputStream fileOutputStream = null;
        try {
            //设置文件名字以及文件类型
            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            //将String类型的数据写入 传的是getBytes字节数组
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //捕获异常最后需要关闭
        finally {
            //如果没有增加判断fileOutputStream不等于null 会有空指针异常的风险 也就是说close会有黄色的提示
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //【2】在定义一个方法用来读取数据
    private String read(){
        //申明变量
        FileInputStream fileInputStream = null;
        try {
            //读取呢个文件
            fileInputStream = openFileInput(mFileName);
            //设置一个1024字节的变量
            byte[] buff = new byte[1024];
            //设置一个拼接器 StringBuilder
            StringBuilder  sb = new StringBuilder();
            //设置一个int类型的字段len 用来转成int类型的数据
            int len = 0;
            //如果 fileInputStream.read(buff)字节数大于0，则用StringBuilder拼接一下
            while ((len = fileInputStream.read(buff)) >0){
                //StringBuilder中的append 穿的值第一个是byte类型，所以前面需要定义byte ，第二个是偏移量 就是第几个开始算起，
                //第三个是长度所以前面定义了一个len 用来存放长度
                sb.append(new String(buff,0,len));
            }
            //将拼出来的数组返回
            return sb.toString();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        //最后记得关掉！
        finally {
            if (fileInputStream !=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
