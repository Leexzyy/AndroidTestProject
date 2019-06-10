package lee.example.com.test.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.microedition.khronos.opengles.GL;

import lee.example.com.test.R;

/***

 *Create By Lee  On 2018/11/25

 **/
public class MyListAdapter extends BaseAdapter {


    private Context mContext;
    private LayoutInflater mLayoutInfalater;

    public MyListAdapter(Context context) {
        this.mContext = context;

    }


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    static class ViewHolder {
        public ImageView imageView;
        public TextView tvTitle, tvTime, tvContent;


    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {


        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInfalater.inflate(R.layout.layout_list_ltem, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2088-08-08");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://github.com/fluidicon.png").into(holder.imageView);

        return convertView;
    }
}
