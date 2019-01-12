package lee.example.com.test.recycleview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import lee.example.com.test.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu = findViewById(R.id.rv_pu);
        //瀑布流布局管理器 第一个是列 第二个是水平方向
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //绘制边框
        mRvPu.addItemDecoration(new MyDecoration());

        mRvPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
    //设置一个边框线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //使用视图为dimen里面都dividerHeight2属性
            int gap = getResources().getDimensionPixelSize(R.dimen.dividerHeight2);
            //设置边框属性
            outRect.set(gap,gap,gap,gap);

        }
    }
}
