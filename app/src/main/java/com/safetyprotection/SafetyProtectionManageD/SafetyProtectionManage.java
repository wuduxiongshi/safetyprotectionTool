package com.safetyprotection.SafetyProtectionManageD;

import android.app.Activity;
import android.content.Context;

import com.safetyprotection.AppFlyer.AppsFlyerCallBase;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;

import java.util.HashMap;

/**
 * @类描述: 主配置类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection
 * 使用示例：
 * （1）建议在Application 中进行初始话操作 功能列表 ①动态设置AppFlyer 的 AF_DEV_KEY
 * ②初始化归因Appsflyer ③ 是否开启地理围栏 （注：如开启地理围栏Activity需基础BaseActivity类，以获取定位权限）
 * <p>
 * SafetyProtectionManage.getInstance()
 * .setAF_DEV_KEY("65KGjam4H3ZB5GVdDEmpp6") // 动态设置AppFlyer 的 AF_DEV_KEY
 * .initAppsflyer(this) // 初始化归因Appsflyer
 * .IslocationTaskEnabled(true); // 是否开启地理围栏 如开启地理围栏Activity需基础BaseActivity类，以获取定位权限
 * <p>
 * （2）获取地理围栏状态
 * <p>
 * boolean islocationTask = SafetyProtectionManage.getInstance().isIslocationTask();
 * <p>
 * (3) 发送归因事件
 * <p>
 * SafetyProtectionManage.getInstance().Logevent("key",new HashMap<>());
 * <p>
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 14:25
 * @version: V1.0
 * ==================================================
 */
public class SafetyProtectionManage {

    private static SafetyProtectionManageDelegate mSafetyProtectionManageDelegate;

    /**
     * 创建一个 SafetyProtectionManageDelegate 对象
     *
     * @return SafetyProtectionManageDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public static SafetyProtectionManageDelegate getSafetyProtectionManageDelegate() {
        if (mSafetyProtectionManageDelegate == null) {
            mSafetyProtectionManageDelegate = SafetyProtectionManageDelegate.create();
        }
        return mSafetyProtectionManageDelegate;
    }

    private static SafetyProtectionManage instance;

    public static SafetyProtectionManage getInstance() {
        if (instance == null) {
            synchronized (SafetyProtectionManage.class) {
                if (instance == null) {
                    instance = new SafetyProtectionManage();
                }
            }
        }
        return instance;
    }

    /**
     * 1. 动态设置AppFlyer 的 AF_DEV_KEY
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public SafetyProtectionManage setAF_DEV_KEY(String AF_DEV_KEY) {
        getSafetyProtectionManageDelegate().setAF_DEV_KEY(AF_DEV_KEY);
        return instance;
    }

    /**
     * 2. 初始化归因Appsflyer
     *
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public SafetyProtectionManage initAppsflyer(Context context, AppsFlyerCallBase appsFlyerCallBase) {
        getSafetyProtectionManageDelegate().initAppsflyer(context,appsFlyerCallBase);
        return instance;
    }

    /**
     * 是否开启地理围栏
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/3
     * ==================================================
     **/
    public SafetyProtectionManage IslocationTaskEnabled(boolean IslocationTask) {
        getSafetyProtectionManageDelegate().IslocationTaskEnabled(IslocationTask);
        return instance;
    }

    /**
     * 获取地理围栏状态
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/3
     * ==================================================
     **/
    public boolean isIslocationTask() {
        return getSafetyProtectionManageDelegate().isIslocationTask();
    }

    /**
     * 发送归因事件
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public void Logevent(String eventName, HashMap<String, Object> eventValue) {
        getSafetyProtectionManageDelegate().Logevent(eventName, eventValue);
    }

    /**
     * 获取安防数据
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public SafetyProtectionBean getSafetyProtectionData() {
        return getSafetyProtectionManageDelegate().getSafetyProtectionData();
    }
}
