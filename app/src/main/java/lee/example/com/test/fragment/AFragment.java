package lee.example.com.test.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lee.example.com.test.R;

public class AFragment extends Fragment {
        private TextView mTvTitle;
//        private Activity mActivity;


    //重新构造一个newInstance的方法 用来传递参数
    public  static  AFragment newInstance ( String title){
        // new 一个AFragment，还有Bundle；
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        //传递的值 用putString 在Activity中接收到的值
        bundle.putString("title",title);
        //被die掉之后还会接着传值
        fragment.setArguments(bundle);
        return fragment;
    }

    //设置布局文件！
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //相当于Activity中的setContentView(); 他的返回值为view 所以直接返回view就行
        View view =inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_titlefragment);

        //将值发送到mTvTitle中

        if ( getArguments() != null){
            mTvTitle.setText(getArguments().getString("title"));
        }
//       if (getActivity()!= null){
//        }else{
//
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity  = (Activity) context;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }
}
