package lee.example.com.test.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lee.example.com.test.R;

/***

 *Create By Lee  On 2019/1/2

 **/
public class LinearAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder> {

    private Context mContext;


    private  OnItemClickListener mListener;

    public  LinearAdapter(Context context,OnItemClickListener listener) {
        this.mContext = context;
        this.mListener= listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0 ){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_ltem,parent,false));
        }else{
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_ltem_2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, final int position) {
        //设置数据！
       if (getItemViewType(position) ==0){
           ((LinearViewHolder) holder).textView.setText("hello!!!!!!!!");


       }else {
           ((LinearViewHolder2) holder).textView.setText("Leexzyy");
       }
        //设置点击事件方法
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 ==0 ){
            return 0;
        }else{
            return 1;
        }

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

    class LinearViewHolder2 extends  RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }

    }

    //设计点击事件接口！
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
