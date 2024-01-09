package com.safetyprotection.AppFlyer;

import android.content.Context;

import java.util.HashMap;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.AppFlyer.AppFlyerDelegate
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 14:14
 * @version: V1.0
 * ==================================================
 */
abstract class AppsFlyerManagerDelegate {

    /**
     * 获取 AF_DEV_KEY
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract String getAF_DEV_KEY();

    /**
     * 设置 AF_DEV_KEY
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract void setAF_DEV_KEY(String AF_DEV_KEY);

    /**
     * 初始化归因
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract void initAppsflyer(Context context,AppsFlyerCallBase appsFlyerCallBase);

    /**
     * 发送归因事件
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract void Logevent(String eventName, HashMap<String, Object> eventValue);

    /**
     * 获取归因数据
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    protected abstract AppsFlyerBean getAppsFlyerBean();

    /**
     * 创建一个 AppsFlyerManagerDelegate 对象
     *
     * @return AppsFlyerManagerDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    protected static AppsFlyerManagerDelegate create() {
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
    private static AppsFlyerManagerDelegate Mycreate() {
        return new AppsFlyerManagerDelegateImpl();
    }
}
