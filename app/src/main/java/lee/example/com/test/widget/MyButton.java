package lee.example.com.test.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
/**
 * @author Administrator
 * 自定义一个Buton 然后重写onTouchEvent方法  在触摸的时候打印log日志
 */
public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //所有事件的入口开始！
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton.java", "----dispatchTouchEvent----");
        return super.dispatchTouchEvent(event);
    }

    /**首先在控件内部进行回调 回调完之后再进入activity中进行回调 ，事件是向外传播的 由Button本身向外传播 如果在Button中将返回return false;改为ture
     * 则这个返回值就在此处被消费了 不会接着向外面传递 则不会传递到activity中的 回调方法中
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         switch (event.getAction()){
             case MotionEvent.ACTION_DOWN:
                 Log.d("MyButton.java", "----onTouchEvent---- ");
                 break;
                 default:
         }
        return super.onTouchEvent(event);
         //这种返回值如果改为true的话 不会往下传递事件了 这个已经被消费了 他的下级为EventActivity中onTouchEvent不会被调用到
    }
}
