package com.safetyprotection.SafetyProtectionManageD;

import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.SafetyProtectionManageD
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 17:10
 * @version: V1.0
 * ==================================================
 */
abstract class SafetyProtectionManageDelegateImpl extends SafetyProtectionManageDelegate {

    /**
     * 获取安防数据
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/

    @Override
    public SafetyProtectionBean getSafetyProtectionData() {
        return SafetyProtectionBean.getInstance();
    }
}
