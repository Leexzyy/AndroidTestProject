package lee.example.com.test.main;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

import lee.example.com.test.R;
import lee.example.com.test.notification.GetNotificationActivity;

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
                 *新加内容  设置通知点击传递Activity
                 * */
                Intent intent = new Intent(this, GetNotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);


                /*
                 * 首先需要一个NotificationManager对通知进行管理，可以调用Context中的getSystemSerie（）方法取到
                 * getSystemService()方法接收一个字符串参数用于确定获取系统的那个服务这里我们传入NOTIFICATION_SERVICE即可
                 * */
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                //创建通知Manager 用v4库中的NotificationCompat方法创建
                Notification notification = new NotificationCompat.Builder(this,"Test")
                        .setContentTitle("消息通知的标题")
                        .setContentText("消息通知的内容，不点击下拉通知栏会有长文字")
                        //显示长文字
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("我这里有很长的文字Leexzyy，" +
                                "我这里有很长的文字Leexzyy，我这里有很长的文字Leexzyy，我这里有很长的文字Leexzyy我这里有很长的文字" +
                                "Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字" +
                                "Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字" +
                                "Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy我这里有很长的文字Leexzyy"))
                        //显示大图 如果有长文字和大图同事显示的话 它会默认只显示大图
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.image1)))
                        //指定创建的事件
                        .setWhen(System.currentTimeMillis())
                        //创建小图标 在下拉栏上显示的小的 只可以使用alpha图层的图
                        .setSmallIcon(R.drawable.image2)
                        //创建大图标 拉下下拉框的图片
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.image2))
                        //设置点击传递Activity
                        .setContentIntent(pi)
                        //设置点击之后去掉状态栏
                        .setAutoCancel(true)
                        //设置播放声音
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtons/Luna.ogg")))
                        //设置震动  第一个是来的时候手机静止的时长，第二个是手机震动一秒，静止一秒，震动一秒
                        .setVibrate(new long[]{0,1000, 1000,1000})
                        //设置LED灯效
                        .setLights(Color.WHITE,100,100)
                        //通知的默认效果 默认效果为 震动事件都只有0.5s
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        //设置通知的重要程度 MAX 代表最高 用户必须看到 比如QQ的消息通知
                        .setPriority(NotificationCompat.PRIORITY_MAX)
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
