package com.safetyprotection.SafetyProtectionManageD;

import android.app.Activity;

import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.SafetyProtectionManageD.SafetyProtectionManageDelegate
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 15:30
 * @version: V1.0
 * ==================================================
 */
abstract class SafetyProtectionManageDelegate implements AppsFlyerDelegate,locationTaskDelegateV2 {

    /**
     * 获取安防数据
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public abstract SafetyProtectionBean getSafetyProtectionData();

    /**
     * 创建一个 SafetyProtectionManageDelegate 对象
     *
     * @return SafetyProtectionManageDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    protected static SafetyProtectionManageDelegate create() {
        return Mycreate();
    }

    /**
     * 创建一个 SafetyProtectionManageDelegate 对象，可向下继承，进行版本控制，之后版本都继承V1版本，进行重写
     *
     * @return SafetyProtectionManageDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    protected static SafetyProtectionManageDelegate Mycreate() {
        return new locationTaskDelegateImplV2();
    }


}
