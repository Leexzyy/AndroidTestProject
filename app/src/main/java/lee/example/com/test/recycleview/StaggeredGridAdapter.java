package lee.example.com.test.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import lee.example.com.test.R;

/***

 *Create By Lee  On 2019/1/9

 **/
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;


    private  OnItemClickListener mListener;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener= listener;
    }


    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_recycleview_ltem,parent,false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        //设置图片 if函数是基数为bg_iron_man偶数为inmage1
        if(position % 2 !=0){
            holder.imageView.setImageResource(R.drawable.image2);
        }else {
            holder.imageView.setImageResource(R.drawable.image1);

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
    public int getItemCount() {
        return 102;
    }//list数量



    //做基础工作。。。

    class LinearViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    //设计点击事件接口！
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
