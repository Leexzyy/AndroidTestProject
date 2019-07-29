package lee.example.com.test.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.R;

/**
 * @author Administrator
 *创建通知弹窗
 */
public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mBtnSend = findViewById(R.id.btn_sendnotice);
        mBtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sendnotice:

                /*
                 * 首先需要一个NotificationManager对通知进行管理，可以调用Context中的getSystemSerie（）方法取到
                 * getSystemService()方法接收一个字符串参数用于确定获取系统的那个服务这里我们传入NOTIFICATION_SERVICE即可
                 * */
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                //创建通知Manager 用v4库中的NotificationCompat方法创建
                Notification notification = new NotificationCompat.Builder(this,"Test")
                        .setContentTitle("消息通知的标题")
                        .setContentText("消息通知的内容")
                        //指定创建的事件
                        .setWhen(System.currentTimeMillis())
                        //创建小图标 在下拉栏上显示的小的 只可以使用alpha图层的图
                        .setSmallIcon(R.drawable.image2)
                        //创建大图标 拉下下拉框的图片
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.image2))
                        .build();

                /*
                 *调用NotificationManager的notify（）方法就可以第一个参数是ID,要保证每个通知所指定的id都是不同的
                 * 第二参数则是notification对象，这里我们刚刚创建好的notification对象传入就可以
                 **/
                if (manager != null) {
                    manager.notify(1,notification);
                }
                break;
                default:
                    break;

        }

    }
}
