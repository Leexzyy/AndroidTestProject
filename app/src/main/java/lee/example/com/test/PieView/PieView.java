package lee.example.com.test.PieView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class PieView extends View {
    //颜色表
    private int[] mColor  ={0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,0xFFE6B800, 0xFF7CFC00};
    //饼状图初始绘制角度
    private float mStartAngle = 0;
    //数据
    private ArrayList <PieData> mData;
    //框高
    private int mWidth,mHeight;
    //画笔
    private Paint mPaint = new Paint();



    public PieView(Context context) {
        this(context,null);
    }

    //View的构造函数  初始化（初始化画笔Paint）
    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //画笔的填充模式 还有STROKE 为描边模式 还有一个FILL_AND_STROKE为填充加描边
        mPaint.setStyle(Paint.Style.FILL);
        //抗锯齿
        mPaint.setAntiAlias(true);
    }


    //重构onSizeChanged 方法 是为了确定View大小；
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }
    //实际绘制内容（绘制饼状图）
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(null ==mData) {
            return;
        }
        //当前起始角度
        float currentStartAngle = mStartAngle;
        //当画布坐标原点移动到中心位置
        canvas.translate(mWidth,mHeight);
        //饼状图半径
        float r = (float)(Math.min(mWidth,mHeight)/2*0.8);
        //饼状图绘制的区域
        RectF rect = new RectF(-r,-r,r,r);

        //设置各个区域的颜色 有一组数据的话就用第一种颜色 而且接着上面画后面的区域 一次类推
        for (int i = 0 ; i<mData.size();i++){
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect,currentStartAngle,pie.getAngle(),true,mPaint);
            currentStartAngle += pie.getAngle();
        }
    }

    //设置起始角度
    public void setStartAngle(int mStartAngle){
        this.mStartAngle = mStartAngle;
        //刷新
        invalidate();
    }

    //设置数据
    public void setData(ArrayList<PieData> mData){
        this.mData = mData;
        //初始化数据
        initdata(mData);
        invalidate();
    }
//todo
    private void initdata(ArrayList<PieData> mData) {
        //数据有问题直接返回
        if(null == mData || mData.size() == 0) {
            return;
        }


        float sumValue = 0 ;
        for ( int i = 0 ;i < mData.size(); i++){
            PieData pie = mData.get(i);
            //计算数值之和
//            sumValue = pie.getValue() +1 ;
            sumValue += pie.getValue();

            //j的值为mColor的长度取模  .length的意思是mColor有几个字段
            //%取模的意思为（取模）有个规律就是：左边小于右边，结果为左边，左边大于右边，看余数
            //主要是用来确定用第几个颜色
            int j  = i% mColor.length;
            pie.setColor(mColor[j]);
        }

        float sumAngle = 0;
        for (int i = 0 ; i< mData.size(); i++) {
            PieData pie = mData.get(i);
            //百分比
            float percentage = pie.getValue()/sumAngle;
            //对应的角度
            float angle = percentage *360;

            //记录百分比
            pie.setPercentage(percentage);
            //记录角度大小
            pie.setAngle(angle);
            sumAngle = sumAngle + angle;

            Log.i("angle", ""+pie.getAngle());
        }

    }

}
