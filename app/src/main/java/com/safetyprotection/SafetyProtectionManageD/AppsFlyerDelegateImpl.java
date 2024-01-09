package com.safetyprotection.SafetyProtectionManageD;

import android.content.Context;

import com.safetyprotection.AppFlyer.AppsFlyerCallBase;
import com.safetyprotection.AppFlyer.AppsFlyerManager;

import java.util.HashMap;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.SafetyProtectionManageD.SafetyProtectionManage.SafetyProtectionManageDelegate
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 15:12
 * @version: V1.0
 * ==================================================
 */
abstract class AppsFlyerDelegateImpl extends SafetyProtectionManageDelegateImpl implements AppsFlyerDelegate {
    @Override
    public void setAF_DEV_KEY(String AF_DEV_KEY) {
        AppsFlyerManager.getInstance().setAF_DEV_KEY(AF_DEV_KEY);
    }

    @Override
    public void initAppsflyer(Context context, AppsFlyerCallBase appsFlyerCallBase) {
        AppsFlyerManager.getInstance().initAppsflyer(context,appsFlyerCallBase);
    }

    @Override
    public void Logevent(String eventName, HashMap<String, Object> eventValue) {

    }
}
