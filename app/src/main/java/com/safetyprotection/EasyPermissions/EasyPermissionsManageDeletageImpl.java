package com.safetyprotection.EasyPermissions;

import android.Manifest;
import android.content.Context;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.EasyPermissions
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 15:53
 * @version: V1.0
 * ==================================================
 */
class EasyPermissionsManageDeletageImpl extends EasyPermissionsManageDeletage {

    private String[] customPermissions;
    private int customPerm;
    private static final String[] LOCATION_AND_CONTACTS =
            {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS};

    @Override
    protected void setCustomPermissions(String[] customPermissions) {
        this.customPermissions = customPermissions;
    }

    @Override
    protected void setCustomPerm(int customPerm) {
        this.customPerm = customPerm;
    }

    @Override
    protected String[] getCustomPermissions() {
        return customPermissions;
    }

    @Override
    protected int getCustomPerm() {
        return customPerm;
    }

    @Override
    protected boolean hasCameraPermission(Context mContext) {
        return EasyPermissions.hasPermissions(mContext, android.Manifest.permission.CAMERA);
    }

    @Override
    protected boolean hasCustomPermission(Context mContext, String[] customPermissions) {
        return EasyPermissions.hasPermissions(mContext, customPermissions);
    }

    @Override
    protected boolean hasLocationAndContactsPermissions(Context mContext) {
        return EasyPermissions.hasPermissions(mContext, LOCATION_AND_CONTACTS);
    }

    @Override
    protected boolean hasLocationPermissions(Context mContext) {
        return EasyPermissions.hasPermissions(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    protected boolean hasSmsPermission(Context mContext) {
        return EasyPermissions.hasPermissions(mContext, android.Manifest.permission.READ_SMS);
    }
}
