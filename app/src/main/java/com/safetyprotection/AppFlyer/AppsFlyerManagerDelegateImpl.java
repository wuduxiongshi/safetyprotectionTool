package com.safetyprotection.AppFlyer;

import android.content.Context;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.safetyprotection.EasyPermissions.EasyPermissionsManage;
import com.safetyprotection.Location.LocationManage;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;
import com.safetyprotection.SafetyProtectionManageD.SafetyProtectionManage;

import java.util.HashMap;
import java.util.Map;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.AppFlyer.AppsFlyerDelegateImpl
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 14:15
 * @version: V1.0
 * ==================================================
 */
class AppsFlyerManagerDelegateImpl extends AppsFlyerManagerDelegate {
    private static Context sContext;

    public String AF_DEV_KEY;
    //    public String AF_DEV_KEY = "65KGjam4H3ZB5GVdDEmpp6";
    private static final String LOG_TAG = "AppsFlyerManager";

    @Override
    protected String getAF_DEV_KEY() {
        return AF_DEV_KEY;
    }

    @Override
    protected void setAF_DEV_KEY(String AF_DEV_KEY) {
        this.AF_DEV_KEY = AF_DEV_KEY;
    }

    /**
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    @Override
    protected void initAppsflyer(Context context, AppsFlyerCallBase appsFlyerCallBase) {
        Log.d(LOG_TAG, "initAppsflyer");
        sContext = context;
        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionDataMap) {
                for (Map.Entry<String, Object> entry : conversionDataMap.entrySet()) {
                    Log.d(LOG_TAG, "Conversion attribute: " + entry.getKey() + " = " + entry.getValue());
                    try {
                        // 获取JavaBean中的setter方法名
                        String setterMethodName = "set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1);
                        // 获取JavaBean中的setter方法
                        java.lang.reflect.Method setterMethod = AppsFlyerBean.class.getMethod(setterMethodName, entry.getValue().getClass());
                        // 调用setter方法，将数据放入JavaBean中
                        setterMethod.invoke(AppsFlyerBean.getInstance(), entry.getValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * 链条式获取所有的状态值
                 * 1.appsflyer 提供出来的非自然流状态
                 * 2.定位信息
                 * ==================================================
                 *
                 * @author: 雾都雄狮
                 * @version: V1.0  2024/1/2
                 * ==================================================
                 **/
                Log.d(LOG_TAG, "== AppsFlyerBean.toString: " + AppsFlyerBean.getInstance().toString());
                SafetyProtectionBean.getInstance().setAf_message(AppsFlyerManager.getInstance().getAppsFlyerBean().getAf_message());
                SafetyProtectionBean.getInstance().setAf_status(AppsFlyerManager.getInstance().getAppsFlyerBean().getAf_status());
                SafetyProtectionBean.getInstance().setIs_first_launch(AppsFlyerManager.getInstance().getAppsFlyerBean().isIs_first_launch());

                if (SafetyProtectionManage.getInstance().isIslocationTask() && EasyPermissionsManage.getInstance().hasLocationPermissions(context)) {
                    LocationManage.getInstance().getFusedLocationProviderClient(sContext, appsFlyerCallBase);
                } else {
                    appsFlyerCallBase.OnCallBack(SafetyProtectionBean.getInstance());
                }
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d(LOG_TAG, "error getting conversion data: " + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {
                // Must be overriden to satisfy the AppsFlyerConversionListener interface.
                // Business logic goes here when UDL is not implemented.
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d(LOG_TAG, "error onAttributionFailure : " + errorMessage);
            }
        };
        if ("".equals(AF_DEV_KEY)) {
            Log.d(LOG_TAG, "AF_ DEV_ KEY is empty ");
            return;
        }

        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionListener, context);
        AppsFlyerLib.getInstance().start(context, AF_DEV_KEY, new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG, "Launch sent successfully, got 200 response code from server");
            }

            @Override
            public void onError(int i, String s) {
                Log.d(LOG_TAG, "Launch failed to be sent:\nError code: " + i + "\nError description: " + s);
            }
        });
    }

    @Override
    protected void Logevent(String eventName, HashMap<String, Object> eventValue) {
        AppsFlyerLib.getInstance().logEvent(sContext, eventName, eventValue, new AppsFlyerRequestListener() {
            @Override
            public void onSuccess() {
                Log.e(LOG_TAG, "Logevent Event sent successfully to eventValue = " + eventValue + " from eventName = " + eventName);
            }

            @Override
            public void onError(int i, String s) {
                Log.d(LOG_TAG, "Event failed to be sent:\nError code: " + i + "\nError description: " + s);
            }
        });
    }

    @Override
    protected AppsFlyerBean getAppsFlyerBean() {
        return AppsFlyerBean.getInstance();
    }
}
