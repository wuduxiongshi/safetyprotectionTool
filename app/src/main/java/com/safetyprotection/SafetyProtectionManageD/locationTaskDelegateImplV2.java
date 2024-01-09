package com.safetyprotection.SafetyProtectionManageD;

import com.safetyprotection.App;
import com.safetyprotection.SpUtil.SpUtil;

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
class locationTaskDelegateImplV2 extends AppsFlyerDelegateImpl implements locationTaskDelegateV2 {
    private boolean IslocationTask = false;

    @Override
    public void IslocationTaskEnabled(boolean IslocationTask) {
        this.IslocationTask = IslocationTask;
        SpUtil.putBoolean(App.getContext(), "IslocationTask", IslocationTask);
    }

    @Override
    public boolean isIslocationTask() {
        return SpUtil.getBoolean(App.getContext(), "IslocationTask", false);
    }
}
