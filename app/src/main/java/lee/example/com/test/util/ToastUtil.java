package lee.example.com.test.util;

import android.content.Context;
import android.widget.Toast;

/***
 *Create By Lee  On 2019/2/3
 **/
public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context,String msg){
        if (mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
