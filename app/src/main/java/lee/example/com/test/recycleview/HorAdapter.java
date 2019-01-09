package lee.example.com.test.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lee.example.com.test.R;

/***

 *Create By Lee  On 2019/1/9

 **/
public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

    private Context mContext;


    private  OnItemClickListener mListener;

    public HorAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener= listener;
    }


    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_ltem,parent,false));
    }

    @Override
    public void onBindViewHolder(HorAdapter.LinearViewHolder holder, final int position) {
        //设置数据！
        holder.textView.setText("水平滚动！！！");
        //设置点击事件方法
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }//list数量



    //做基础工作。。。

    class LinearViewHolder extends  RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    //设计点击事件接口！
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
