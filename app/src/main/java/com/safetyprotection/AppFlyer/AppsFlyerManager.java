package com.safetyprotection.AppFlyer;

import android.content.Context;

import java.util.HashMap;

/**
 * @类描述: AppsFlyer 归因服务管理类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 17:43
 * @version: V1.0
 * ==================================================
 */
public class AppsFlyerManager {

    private static AppsFlyerManagerDelegate mAppsFlyerManagerDelegate;

    private static AppsFlyerManager instance;

    public static AppsFlyerManager getInstance() {
        if (instance == null) {
            synchronized (AppsFlyerManager.class) {
                if (instance == null) {
                    instance = new AppsFlyerManager();
                }
            }
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
    public static AppsFlyerManagerDelegate getAppsFlyerManagerDelegate() {
        if (mAppsFlyerManagerDelegate == null) {
            mAppsFlyerManagerDelegate = AppsFlyerManagerDelegate.create();
        }
        return mAppsFlyerManagerDelegate;
    }

    /**
     * 获取 AF_DEV_KEY
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public String getAF_DEV_KEY() {
        return getAppsFlyerManagerDelegate().getAF_DEV_KEY();
    }

    /**
     * 设置 AF_DEV_KEY
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public void setAF_DEV_KEY(String AF_DEV_KEY) {
        getAppsFlyerManagerDelegate().setAF_DEV_KEY(AF_DEV_KEY);
    }

    /**
     * 初始化归因
     *
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public void initAppsflyer(Context context,AppsFlyerCallBase appsFlyerCallBase) {
        getAppsFlyerManagerDelegate().initAppsflyer(context,appsFlyerCallBase);
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
        getAppsFlyerManagerDelegate().Logevent(eventName, eventValue);
    }

    /**
     * 获取归因数据
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public AppsFlyerBean getAppsFlyerBean() {
        return getAppsFlyerManagerDelegate().getAppsFlyerBean();
    }
}
