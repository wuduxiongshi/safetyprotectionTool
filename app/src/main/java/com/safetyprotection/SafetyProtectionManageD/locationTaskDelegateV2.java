package com.safetyprotection.SafetyProtectionManageD;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.SafetyProtectionManageD
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 16:22
 * @version: V1.0
 * ==================================================
 */
interface locationTaskDelegateV2 {
    /**
     * 是否开启地理围栏
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/3
     * ==================================================
     **/
    public void IslocationTaskEnabled(boolean IslocationTask);

    /**
     * 获取地理围栏状态
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/3
     * ==================================================
     **/
    public boolean isIslocationTask();
}
