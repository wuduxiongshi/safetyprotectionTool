package com.safetyprotection.EasyPermissions;

import android.content.Context;

/**
 * @类描述: 动态权限弹窗管理类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.EasyPermissions
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 18:46
 * @version: V1.0
 * ==================================================
 */
public class EasyPermissionsManage {

    private static EasyPermissionsManage instance;
    private static final String LOG_TAG = "EasyPermissionsManage";

    private static EasyPermissionsManageDeletage mEasyPermissionsManageDeletage;

    /**
     * 单例模式
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public static EasyPermissionsManage getInstance() {
        if (instance == null) {
            instance = new EasyPermissionsManage();
        }
        return instance;
    }

    /**
     * 创建一个 AppsFlyerManagerDelegate 对象
     *
     * @return ApkUpdateManagerDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public static EasyPermissionsManageDeletage getEasyPermissionsManageDeletage() {
        if (mEasyPermissionsManageDeletage == null) {
            mEasyPermissionsManageDeletage = EasyPermissionsManageDeletage.create();
        }
        return mEasyPermissionsManageDeletage;
    }

    /**
     * 设置自定义权限列表
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/

    public EasyPermissionsManage setCustomPermissions(String[] customPermissions) {
        getEasyPermissionsManageDeletage().setCustomPermissions(customPermissions);
        return instance;
    }

    /**
     * 设置自定义请求码
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public EasyPermissionsManage setCustomPerm(int customPerm) {
        getEasyPermissionsManageDeletage().setCustomPerm(customPerm);
        return instance;
    }

    public String[] getCustomPermissions() {
        return getEasyPermissionsManageDeletage().getCustomPermissions();
    }

    public int getCustomPerm() {
        return getEasyPermissionsManageDeletage().getCustomPerm();
    }

    public boolean hasCameraPermission(Context mContext) {
        return getEasyPermissionsManageDeletage().hasCameraPermission(mContext);
    }

    public boolean hasCustomPermission(Context mContext, String[] customPermissions) {
        return getEasyPermissionsManageDeletage().hasCustomPermission(mContext, customPermissions);
    }

    public boolean hasLocationAndContactsPermissions(Context mContext) {
        return getEasyPermissionsManageDeletage().hasLocationAndContactsPermissions(mContext);
    }

    public boolean hasLocationPermissions(Context mContext) {
        return getEasyPermissionsManageDeletage().hasLocationPermissions(mContext);
    }

    public boolean hasSmsPermission(Context mContext) {
        return getEasyPermissionsManageDeletage().hasSmsPermission(mContext);
    }
}
