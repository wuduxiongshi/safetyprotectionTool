package com.safetyprotection.SpUtil.Delegate;

import android.content.Context;

import com.safetyprotection.SpUtil.DelegateImp.SpUtilDelegateImpl;


/**
 * @类描述: SpUtil V1目录
 * @项目名称: 天骄平板
 * @包名称: com.lenovo.lfh.tianjiao.tablet.utils.SpUtil
 * ==================================================
 * @创建人: 张强
 * @联系方式: VX: 15354069488
 * @创建时间: 2022/9/19 15:35
 * @version: V3.0
 * ==================================================
 */
public abstract class SpUtilDelegate {
    public static final String TAG = "SpUtilDelegate";

    /**
     * 使用sharedPreferences存入String类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract void putString(Context mContext, String key, String value);

    /**
     * 使用sharedPreferences获取String类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract String getString(Context mContext, String key, String defaultValue);

    /**
     * 使用sharedPreferences存入boolean类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract void putBoolean(Context mContext, String key, boolean value);

    /**
     * 使用sharedPreferences获取boolean类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract boolean getBoolean(Context mContext, String key, boolean defaultValue);

    /**
     * 使用sharedPreferences存入int类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract void putInt(Context mContext, String key, int value);

    /**
     * 使用sharedPreferences获取int类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract int getInt(Context mContext, String key, int defaultValue);

    /**
     * 使用sharedPreferences存入long类型的数据
     *
     * @param key
     * @param value
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract void putLong(Context mContext, String key, long value);

    /**
     * 使用sharedPreferences获取long类型的数据,并设置默认值
     *
     * @param key
     * @param defaultValue
     * @return: void
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public abstract long getLong(Context mContext, String key, long defaultValue);

    /**
     * 创建一个MyTabDelegate对象
     *
     * @return SpUtilDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    public static SpUtilDelegate create() {
        return Mycreate();
    }

    /**
     * 创建一个MyTabDelegate对象，可向下继承，进行版本控制，之后版本都继承V1版本，进行重写
     *
     * @return SpUtilDelegate
     * ==================================================
     * @author: 张强 (VX:15354069488)
     * @version: V3.0  2022/9/19 16:07
     * ==================================================
     */
    private static SpUtilDelegate Mycreate() {
        return new SpUtilDelegateImpl();
    }
}
