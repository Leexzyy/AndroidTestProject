package lee.example.com.test.camera;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import lee.example.com.test.R;

/**
 * @author Administrator
 * 相机的Activity
 */
public class CameraAlbumActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO = 1;
    private ImageView mPicture;
    private Uri mImageUrl;
    private Button mTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mTakePhoto = findViewById(R.id.take_photo);
        mPicture = findViewById(R.id.picture);
        mTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建File对象，用于存储拍照后的照片
                File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
                //需要try catch一下
                try {
                    //如果存在的话就删除掉
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >=24) {
                    mImageUrl = FileProvider.getUriForFile(CameraAlbumActivity.this,"lee.example.com.test.fileprovider",outputImage);
                }else {
                    mImageUrl = Uri.fromFile(outputImage);
                }
                //启动相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,mImageUrl);
                startActivityForResult( intent, TAKE_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if (requestCode == RESULT_OK){
                    try {
                        //将拍好的照片显示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(mImageUrl));
                        mPicture.setImageBitmap(bitmap);
                    }catch (Exception e ){
                        e.printStackTrace();
                    }

                }
                break;
                default:

                    break;
        }
    }


}
