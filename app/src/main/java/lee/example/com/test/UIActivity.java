package lee.example.com.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lee.example.com.test.gridview.GridViewActivity;
import lee.example.com.test.listview.ListViewActivity;
import lee.example.com.test.recycleview.RecyclerViewActivity;
import lee.example.com.test.recycleview.WebViewActivity;

public class UIActivity extends AppCompatActivity {
    //声明
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEdittext;
    private Button mBtnRadioButten;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mRecyclerView;
    private Button mBtnWebView;
    private Button mToast;
    private Button mDialog;
    private Button mPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

//找到空间
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_butten);
        mBtnEdittext = findViewById(R.id.btn_edittext);
        mBtnRadioButten = findViewById(R.id.btn_radiobutten);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mToast = findViewById(R.id.btn_toast);
        mDialog = findViewById(R.id.btn_dialog);
        mPopup = findViewById(R.id.btn_popupwindow);
        setListeners();
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //跳转到TextView
//                Intent intent = new Intent(UIActivity.this,TextViewActivity.class);
//               startActivities(new Intent[]{intent});
//            }
//        });


//        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到Butten界面
//                Intent intent = new Intent(UIActivity.this,ButtenActivity.class);
//                startActivities(new Intent[]{intent});
//
//            }
//        });


//        mBtnEdittext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到Edittext界面
//                Intent intent = new Intent(UIActivity.this,EditTextActivity.class);
//                startActivities(new Intent[]{intent});
//            }
//        });


    }

    //设置监听器，每个控件设置点击事件
    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEdittext.setOnClickListener(onClick);
        mBtnRadioButten.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mToast.setOnClickListener(onClick);
        mDialog.setOnClickListener(onClick);
        mPopup.setOnClickListener(onClick);

    }

    //点击事件
    private class OnClick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                //
                case R.id.btn_textview:
                    //跳转到TextView
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_butten:
                    //跳转到Butten界面
                    intent = new Intent(UIActivity.this, ButtenActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditText界面
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutten:
                    //跳转到TextView界面
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //跳转到CheckBox界面
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //跳转到ImageView界面
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    ////跳转到ListView界面
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this,GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this,RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this,DialogActivity.class);
                    break;
                case R.id.btn_popupwindow:
                    intent = new Intent(UIActivity.this,PopupWindowActivity.class);
                    break;
                default:
            }
            startActivity(intent);

        }
    }

}
