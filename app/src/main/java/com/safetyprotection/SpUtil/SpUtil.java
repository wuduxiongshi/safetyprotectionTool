package com.safetyprotection.SpUtil;

import android.content.Context;

import com.safetyprotection.SpUtil.Delegate.SpUtilDelegate;


/**
 * @类描述: sharedPreferences的管理类
 * @项目名称: 天骄平板
 * @包名称: com.lenovo.lfh.tianjiao.tablet.utils.SpUtil
 * ==================================================
 * @创建人: 张强
 * @联系方式: VX: 15354069488
 * @创建时间: 2022/9/19 16:38
 * @version: V3.0
 * ==================================================
 */
public class SpUtil {
    private static SpUtilDelegate mSpUtilDelegate;

    /**
     * 创建一个SpUtilDelegate对象
     *
     * @return SpUtilDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    private static SpUtilDelegate getmSpUtilDelegate() {
        if (mSpUtilDelegate == null) {
            mSpUtilDelegate = SpUtilDelegate.create();
        }
        return mSpUtilDelegate;
    }

    /**
     * 使用sharedPreferences存入String类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static void putString(Context mContext, String key, String value) {
        getmSpUtilDelegate().putString(mContext, key, value);
    }

    /**
     * 使用sharedPreferences获取 String类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: String
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static String getString(Context mContext, String key, String defaultValue) {
        return getmSpUtilDelegate().getString(mContext, key, defaultValue);
    }

    /**
     * 使用sharedPreferences存入boolean类型的数据
     *
     * @param key
     * @param value
     * @return: String
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static void putBoolean(Context mContext, String key, boolean value) {
        getmSpUtilDelegate().putBoolean(mContext, key, value);
    }

    /**
     * 使用sharedPreferences获取boolean类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: String
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static boolean getBoolean(Context mContext, String key, boolean defaultValue) {
        return getmSpUtilDelegate().getBoolean(mContext, key, defaultValue);
    }

    /**
     * 使用sharedPreferences存入int类型的数据
     *
     * @param key
     * @param value
     * @return: String
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static void putInt(Context mContext, String key, int value) {
        getmSpUtilDelegate().putInt(mContext, key, value);
    }

    /**
     * 使用sharedPreferences获取int类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: int
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static int getInt(Context mContext, String key, int defaultValue) {
        return getmSpUtilDelegate().getInt(mContext, key, defaultValue);
    }

    /**
     * 使用sharedPreferences存入long类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static void putLong(Context mContext, String key, long value) {
        getmSpUtilDelegate().putLong(mContext, key, value);
    }

    /**
     * 使用sharedPreferences获取long类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:38
     * ==================================================
     */
    public static long getLong(Context mContext, String key, long defaultValue) {
        return getmSpUtilDelegate().getLong(mContext, key, defaultValue);
    }
}
