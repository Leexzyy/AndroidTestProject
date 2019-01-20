package lee.example.com.test.recycleview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lee.example.com.test.R;

public class WebViewActivity extends AppCompatActivity {
        private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.wb);
        //加载本地html
//        mWebView.loadUrl("file:///android_asset/test.html");
        //加载网络URl
        //点击网页事件到时候打开自己的浏览器 不跳转出去 需要新建WebViewClient
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());
        //打开支持JS代码
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://baidu.com");
    }









    //自己创建一个WebViewClient 为了不跳转到外面到浏览器需要自己到一个WebViewClient

    class MyWebViewClient extends WebViewClient{
        //getUrl  传给自己的WebViewClient
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
        //网页打开之前
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted....");
        }
        //网页打开之后

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished....");
            //可以调用js代码的两种方式
           // mWebView.loadUrl("javascript:alert('js弹窗代码Leexzyy')");
            mWebView.evaluateJavascript("javascript:alert('js弹窗代码Leexzyy-----网页以加载完')",null);

        }
    }


    class MyWebChromeClient extends WebChromeClient{
        //设置进度条
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        //网页的title用到App的title上
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

//点击返回键返回上一级页面  没有回退到上一级Activity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
