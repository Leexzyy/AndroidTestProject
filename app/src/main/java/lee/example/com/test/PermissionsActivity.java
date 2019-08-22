package lee.example.com.test;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

import lee.example.com.test.main.ActActivity;
import lee.example.com.test.main.MainActivity;

/**
 * @author Administrator
 * 权限处理Activity 原理是遍历permissionCheckList 与AndroidManifest中的权利 然后调用权限申请
 */
public class PermissionsActivity extends ActActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private String[] permissionCheckList = new String[]{
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && getApplicationInfo().targetSdkVersion<Build.VERSION_CODES.M){
            closePermissionsActivity();
        }else {
            requestPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        requestPermission();
    }

    private void requestPermission() {
        PackageInfo packageInfo = null;
        String[] permissions = null;
        try {
            packageInfo = this.getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_PERMISSIONS);
            permissions = packageInfo.requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String permissionLog = "";
        ArrayList<String> needRequestPermissions = new ArrayList<String>();

        if (permissions != null){
            for (String permissionCheck: permissionCheckList){
                for (String permission:permissions){
                    if (permission.equalsIgnoreCase(permissionCheck)&&ActivityCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED) {
                        needRequestPermissions.add(permission);
                    }
                }
            }
        }
        if (needRequestPermissions.size() !=0){
            Log.e("","needRequestPermissions"+needRequestPermissions.size());
            String[] perssionArray = new String[needRequestPermissions.size()];
            perssionArray = needRequestPermissions.toArray(perssionArray);
                ActivityCompat.requestPermissions(this,perssionArray,0);
                for (String permi:perssionArray){
                    permissionLog = permissionLog +permi+",";
                }
        }else {
            closePermissionsActivity();
        }
    }

    private void closePermissionsActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
