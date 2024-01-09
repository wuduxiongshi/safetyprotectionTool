package com.safetyprotection;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.safetyprotection.AppFlyer.AppsFlyerCallBase;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;
import com.safetyprotection.SafetyProtectionManageD.SafetyProtectionManage;

import java.util.HashMap;

/**
 * @类描述: Application基类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 17:43
 * @version: V1.0
 * ==================================================
 */
public class App extends Application {
    private static App tianjiaoApp;
    private static Context context;
    private static final String LOG_TAG = "App";

    public static App getInstants() {
        return tianjiaoApp;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        tianjiaoApp = this;
        context = getApplicationContext();
//        SafetyProtectionManage.getInstance()
//                .setAF_DEV_KEY("65KGjam4H3ZB5GVdDEmpp6") // 动态设置AppFlyer 的 AF_DEV_KEY
//                .initAppsflyer(this, new AppsFlyerCallBase() {
//                    @Override
//                    public void OnCallBack(SafetyProtectionBean mSafetyProtectionBean) {
//                        Log.d(LOG_TAG, "safetyProtectionData: " + mSafetyProtectionBean.toString());
//                    }
//                }) // 初始化归因Appsflyer
//                .IslocationTaskEnabled(true); // 是否开启地理围栏 如开启地理围栏Activity需基础BaseActivity类，以获取定位权限

//
//        boolean islocationTask = SafetyProtectionManage.getInstance().isIslocationTask();
//        SafetyProtectionManage.getInstance().Logevent("key", new HashMap<>());
    }
}
