package com.safetyprotection.EasyPermissions;

import android.content.Context;

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
abstract class EasyPermissionsManageDeletage {

    /**
     * 设置自定义权限列表
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/

    protected abstract void setCustomPermissions(String[] customPermissions);

    /**
     * 设置自定义请求码
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract void setCustomPerm(int customPerm);

    /**
     * 获取自定义权限列表
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract String[] getCustomPermissions();

    /**
     * 获取自定义请求码
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract int getCustomPerm();

    /**
     * 检测是否有拍照权限
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract boolean hasCameraPermission(Context mContext);

    /**
     * 检测是否有自定义权限
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract boolean hasCustomPermission(Context mContext, String[] customPermissions);

    /**
     * 检测是否有定位和联系人列表权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract boolean hasLocationAndContactsPermissions(Context mContext);

    /**
     * 检测是否有定位权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract boolean hasLocationPermissions(Context mContext);

    /**
     * 检测是否有sms权限
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract boolean hasSmsPermission(Context mContext);

    /**
     * 创建一个 AppsFlyerManagerDelegate 对象
     *
     * @return AppsFlyerManagerDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    protected static EasyPermissionsManageDeletage create() {
        return Mycreate();
    }

    /**
     * 创建一个 AppsFlyerManagerDelegate 对象，可向下继承，进行版本控制，之后版本都继承V1版本，进行重写
     *
     * @return AppsFlyerManagerDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    private static EasyPermissionsManageDeletage Mycreate() {
        return new EasyPermissionsManageDeletageImpl();
    }
}
