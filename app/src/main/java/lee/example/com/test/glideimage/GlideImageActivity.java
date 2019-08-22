package lee.example.com.test.glideimage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.net.URI;
import java.net.URL;

import lee.example.com.test.R;

/**
 * @author Administrator
 * GlideImage第一个Activity 里面有Glide加载网络图片、bending图片、加载
 */
public class GlideImageActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Button mBtnLoadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        mImageView = findViewById(R.id.iv_glideimage);
        mBtnLoadImage = findViewById(R.id.btn_loadimage);
        mBtnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * with()可以用来接收Context/Activity/Fragment的参数 选择范围非常广
                * with（）传入的实列会决定Glide加载图片的生命周期
                * 如果传入的是Activity 或者是Fragment的实列 当他们被销毁的时候 图片加载就会停止
                * 如果传入的是ApplicationContext 那么只有等app被杀死之后 图片加载才会停止
                * Glide最基本的使用方式 先with（）然后在load（） 然后在into（）。
                *
                *占位图：在加载过程中事先显示一张图片 等图片加载出来后替换成要加载的图片
                *
                * Glide动态图 会自动辨别 不需要做处理 如果需要强制转换为动态或者今天图的话需要增加方法 下面会有注释
                *
                * Glide会根据ImageView 自动加载大小 如果还需要调整大小可以用.override(100,100)方法
                * 
                *
                * */
                //静态图片
                String url1 = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
                //Gif图片
                String url2 = "http://p1.pstatp.com/large/166200019850062839d3";
                Glide.with(GlideImageActivity.this)
                        .load(url2)
//                        强制转换为动态图 如果是静态图转换动态 则会加载失败
//                      //.asGif()
                        //强制转换静态图 如果是动态图的话会保留第一帧 但必须在load（）后面执行
//                      //.asBitmap()
                        //添加占位图
                        .placeholder(R.drawable.loding)
                        //异常占位图 加载失败时候 弹出来
                        .error(R.drawable.error)
                        //禁用Glide的缓存机制 因为原来的这个图已经被缓存了 加载很快
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(mImageView);

                //加载本地图片资源
//                File file = new File(getExternalCacheDir()+"/image.jpg");
//                Glide.with(getApplicationContext()).load(file).into(mImageView);
                //加载应用资源
//                int resource = R.id.image;
//                Glide.with(GlideImageActivity.this).load(resource).into(mImageView);
                //加载二进制流
//                byte[] image = getImageBytes();
//                Glide.with(GlideImageActivity.this).load(image).into(mImageView);
                //加载Uri对象
//                URI  imageUri = getImageUri();
//                Glide.with(GlideImageActivity.this).load(imageUri).into(mImageView);

            }
        });

    }
}
