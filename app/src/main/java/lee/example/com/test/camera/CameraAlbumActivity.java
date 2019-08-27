package lee.example.com.test.camera;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import lee.example.com.test.R;
import lee.example.com.test.util.ToastUtil;

/**
 * @author Administrator
 * 相机的Activity
 */
public class CameraAlbumActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO = 1;
    public static final int CHOOSE_PHOTO = 2;
    private ImageView mPicture;
    private Uri mImageUrl;
    private Button mBtnTakePhoto,mBtnChoosePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mBtnTakePhoto = findViewById(R.id.take_photo);
        mPicture = findViewById(R.id.picture);
        mBtnChoosePhoto = findViewById(R.id.btn_choose_photo);




        mBtnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                  创建File对象，用于存储拍照后的照片，放在应用的光剑缓存目录下面 就是指SD卡中专门用来存放当前应用缓存数据的位置
                  调用getExternalCacheDir（）方法就可以得到这个目录 位置是/sd card/Android/data/<package name>/cache
                  为什么要使用应用的关健缓存目录呢 是因为从Android 6.0开始读写SD卡就变成危险权限了 如果放在SD卡的任何目录的话都运行权限
                  处理才行 如果方便关健缓存目录则可以跳过这一步
                 */
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
                /*
                  如果Android小于7.0 就调用Uri的fromFile()方法将File对象转换为Uri对象 这个对象标识着output_image.jpg的正式路径
                   在后面onActivityResult方法中利用uri显示出来
                   如果大于7.0就需要调用FileProvider的getUriForFile（）方法将File转换成一个封装的Uri对象
                   第一个参数要求传入context 第二个参数可以是任意唯一的字符串 第三个则是我们刚刚创建的File对象

                    因为Android从7.0以开始 直接使用本地真实路径的Uri是不安全的 会排除一个异常 而FileProvider是一个特殊的内容容器
                    他使用了和内容提供器类似的机制对数据进行保护，可以选择地将封装过的Uri共享给外部 提高应用的安全
                */
                int sdkVersion = 24;
                if (Build.VERSION.SDK_INT < sdkVersion) {
                    mImageUrl = Uri.fromFile(outputImage);
                }else {
                    mImageUrl = FileProvider.getUriForFile(CameraAlbumActivity.this,"lee.example.com.test.fileprovider",outputImage);
                }
                /*
                 * 启动相机程序
                 * 使用隐形Intent
                 */
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
               //使用putExtra（）方法指定图片的输出地址，然后填入我们刚刚得到的Uri对象
                intent.putExtra(MediaStore.EXTRA_OUTPUT,mImageUrl);
                //使用startActivityForResult开启活动 结果将返回到onActivityResult中
                startActivityForResult( intent, TAKE_PHOTO);
            }
        });
        //选择照片
        mBtnChoosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 在这里运行了一个运行时权限的处理，动态申请WRITE_EXTERNAL_STORAGE这个危险权限 因为相册中的照片都是存储在SD卡上的 所以我们需要在SD卡中读取照片需要申请这个权限、
                 WRITE_EXTERNAL_STORAGE权限表示同时授予程序对SD卡的读写能力
                 */
                //就是检查这个Activity 中WRITE_EXTERNAL_STORAGE没有授予权限就在ActivityCompat中的requestPermissions（）方法 得到权限
                if (ContextCompat.checkSelfPermission(CameraAlbumActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CameraAlbumActivity.this,
                            new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else {
                    openAlbum();
                }
            }
        });
    }
    /**打开相册*/
    private void openAlbum() {
        /*
        先实列化一个intent对象 并且将它的action指定为android.intent.action.GET_CONTENT 然后设置一个基本参数
         然后调用startActivityForResult方法打开相册选择照片。第二个参数传入的值变成了CHOOSE_PHOTO
         这样case CHOOSE_PHOTO 做处理
        * */
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHOTO);
    }
        /**
        用户选择允许或拒绝后，会回调onRequestPermissionsResult方法, 该方法类似于onActivityResult
        */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 &&grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    openAlbum();
                   }else {
                    ToastUtil.showMsg(this,"需要激活权限");
                }
                break;
                default:

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            //上面方法中有传递TAKE_PHOTO的值 所以先判断如果是TAKE_PHOTO 就执行下面方法
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK){
                    try {
                        /*将拍好的照片显示出来
                        如果拍照成功
                            先使用BitmapFactory中的decodeStream（）方法将output_image.jpg解析成Bitmap对象 然后设置到ImageView中显示出来
                         * */
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(mImageUrl));
                        mPicture.setImageBitmap(bitmap);
                    }catch (Exception e ){
                        e.printStackTrace();
                    }

                }
            case CHOOSE_PHOTO:
                if(resultCode == RESULT_OK){
                //先判断手机系统版本号 因为从Android4.4系统开始 选取相册的图片不再返回真实的uri了
                    // 而是一个封装的Uri 因此如果是4.4版本以上的需要对这个Uri进行解析
                    int sdkVersion19 = 19;
                    if (Build.VERSION.SDK_INT>=sdkVersion19){
                        //4,4以及以上系统的使用这个方法处理图片
                        handleImageOnKitKat(data);
                    }else {
                        //4.4以下系统的使用这个方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
                default:
        }
    }
    /**4.4系统以上的使用这个方法处理图片，解析Uri*/
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        Log.d("handleImageOnKitKat","handleImageOnKitKat Uri is:  "+uri);
        //如果是Document类型的uri 则取出document id处理
        if (DocumentsContract.isDocumentUri(this,uri)){
            String docId = DocumentsContract.getDocumentId(uri);
            //另外如果Uri的Authority是media格式的话 document id还需要再一次进行解析，
            // 要通过字符串分隔的方式取出后半部分才能得到真正的数字id
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                //解析出数字格式的id
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID +"="+id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }
            else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUris = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUris,null);
            }
            //如果是content类型的图片，则使用普通方式处理
            else if ("content".equalsIgnoreCase(uri.getScheme())){
                imagePath = getImagePath(uri,null);
            }
            //如果是file类型的图片,直接获取图片路径即可
            else if ("file".equalsIgnoreCase(uri.getScheme())){
                    imagePath = uri.getPath();
            }
            //根据图片地址显示图片
            displayImage(imagePath);
        }
    }
    /**根据图片路径显示图片*/
    private void displayImage(String imagePath) {
        if (imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            mPicture.setImageBitmap(bitmap);
        }else {
            ToastUtil.showMsg(this,"图片路径错误");
        }
    }
    /**获得图片路径方法*/
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
    /**4，4系统以下的使用这个方法处理图片*/
    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }
}
