package com.safetyprotection;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.safetyprotection.EasyPermissions.EasyPermissionsManage;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;
import com.safetyprotection.SafetyProtectionManageD.SafetyProtectionManage;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @类描述: Activity基类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 17:43
 * @version: V1.0
 * ==================================================
 */
public class BaseActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks,
        EasyPermissions.RationaleCallbacks {

    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_LOCATION_CONTACTS_PERM = 124;
    private static final int RC_LOCATION_PERM = 125;

    private static final String[] LOCATION_AND_CONTACTS =
            {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS};

    private static final String LOG_TAG = "BaseActivity";

    private String[] CUSTOM;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SafetyProtectionManage.getInstance().isIslocationTask()){
            locationTask();

        }

    }

    /**
     * EasyPermissions 获取权限返回结果
     *
     * @param requestCode  The request code passed in {@link (
     *                     android.app.Activity, String[], int)}
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link android.content.pm.PackageManager#PERMISSION_GRANTED}
     *                     or {@link android.content.pm.PackageManager#PERMISSION_DENIED}. Never null.
     *                     <p>
     *                     ==================================================
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 请求自定义权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public void customTask() {
        if (EasyPermissionsManage.getInstance().hasCustomPermission(this, EasyPermissionsManage.getInstance().getCustomPermissions())) {
            // Have permission, do the thing!
            Log.d(LOG_TAG, "TODO: Camera things");
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_custom),
                    EasyPermissionsManage.getInstance().getCustomPerm(),
                    EasyPermissionsManage.getInstance().getCustomPermissions());
        }
    }

    /**
     * 请求拍照权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     */
    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() {
        if (EasyPermissionsManage.getInstance().hasCameraPermission(this)) {
            // Have permission, do the thing!
            Log.d(LOG_TAG, "TODO: Camera things");
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_camera),
                    RC_CAMERA_PERM,
                    Manifest.permission.CAMERA);
        }
    }

    /**
     * 请求定位和读取联系人权限
     */
    @AfterPermissionGranted(RC_LOCATION_CONTACTS_PERM)
    public void locationAndContactsTask() {
        if (EasyPermissionsManage.getInstance().hasLocationAndContactsPermissions(this)) {
            // Have permissions, do the thing!
            Log.d(LOG_TAG, "TODO: Location and Contacts things");
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_location_contacts),
                    RC_LOCATION_CONTACTS_PERM,
                    LOCATION_AND_CONTACTS);
        }
    }

    /**
     * 请求定位权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     */
    @AfterPermissionGranted(RC_LOCATION_PERM)
    public void locationTask() {
        if (EasyPermissionsManage.getInstance().hasLocationPermissions(this)) {
            // Have permissions, do the thing!

            Log.d(LOG_TAG, "TODO: Location things");
        } else {
//            // Ask for both permissions
            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_location),
                    RC_LOCATION_PERM,
                    Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.d(LOG_TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(LOG_TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());

        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onRationaleAccepted(int requestCode) {
        Log.d(LOG_TAG, "onRationaleAccepted:" + requestCode);
    }

    @Override
    public void onRationaleDenied(int requestCode) {
        Log.d(LOG_TAG, "onRationaleDenied:" + requestCode);
    }
}
