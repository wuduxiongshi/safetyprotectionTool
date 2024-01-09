package com.safetyprotection.SpUtil.DelegateImp;

import android.content.Context;
import android.content.SharedPreferences;

import com.safetyprotection.SpUtil.Delegate.SpUtilDelegate;


/**
 * @类描述: SpUtil 实现类
 * @项目名称: 天骄平板
 * @包名称: com.lenovo.lfh.tianjiao.tablet.utils.SpUtil
 * ==================================================
 * @创建人: 张强
 * @联系方式: VX: 15354069488
 * @创建时间: 2022/9/19 16:00
 * @version: V3.0
 * ==================================================
 */
public class SpUtilDelegateImpl extends SpUtilDelegate {
    private static SharedPreferences mSp;

    /**
     * 校验sharedPreferences
     *
     * @return
     */
    private static SharedPreferences checkoutSP(Context mContext) {
        if (mSp == null) {
            mSp = mContext.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return mSp;
    }

    @Override
    public void putString(Context mContext, String key, String value) {
        mSp = checkoutSP(mContext);
        mSp.edit().putString(key, value).apply();
    }

    @Override
    public String getString(Context mContext, String key, String defaultValue) {
        mSp = checkoutSP(mContext);
        return mSp.getString(key, defaultValue);
    }

    @Override
    public void putBoolean(Context mContext, String key, boolean value) {
        mSp = checkoutSP(mContext);
        mSp.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(Context mContext, String key, boolean defaultValue) {
        mSp = checkoutSP(mContext);
        return mSp.getBoolean(key, defaultValue);
    }

    @Override
    public void putInt(Context mContext, String key, int value) {
        mSp = checkoutSP(mContext);
        mSp.edit().putInt(key, value).apply();
    }

    @Override
    public int getInt(Context mContext, String key, int defaultValue) {
        mSp = checkoutSP(mContext);
        return mSp.getInt(key, defaultValue);
    }

    @Override
    public void putLong(Context mContext, String key, long value) {
        mSp = checkoutSP(mContext);
        mSp.edit().putLong(key, value).apply();
    }

    @Override
    public long getLong(Context mContext, String key, long defaultValue) {
        mSp = checkoutSP(mContext);
        return mSp.getLong(key, defaultValue);
    }
}
