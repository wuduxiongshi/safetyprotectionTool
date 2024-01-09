package com.safetyprotection.SafetyProtectionManageD;

import android.content.Context;

import com.safetyprotection.AppFlyer.AppsFlyerCallBase;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;

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
interface AppsFlyerDelegate {
    /**
     * 动态设置AppFlyer 的 AF_DEV_KEY
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
     void setAF_DEV_KEY(String AF_DEV_KEY);

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
     void initAppsflyer(Context context, AppsFlyerCallBase appsFlyerCallBase);

    /**
     * 发送归因事件
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    void Logevent(String eventName, HashMap<String, Object> eventValue);

}
