package lee.example.com.test.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lee.example.com.test.R;

public class BFragment extends Fragment {
        private TextView mTvTitle;



    //设置布局文件！
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //相当于Activity中的setContentView(); 他的返回值为view 所以直接返回view就行
        View view =inflater.inflate(R.layout.fragment_b,container,false);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title1fragment);
    }
}
