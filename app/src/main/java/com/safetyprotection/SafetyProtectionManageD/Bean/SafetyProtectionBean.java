package com.safetyprotection.SafetyProtectionManageD.Bean;

import com.safetyprotection.AppFlyer.AppsFlyerBean;

/**
 * @类描述:
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.SafetyProtectionManageD.Bean
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/3 16:59
 * @version: V1.0
 * ==================================================
 */
public class SafetyProtectionBean {
    private String af_status;
    private String af_message;
    private boolean is_first_launch = false;

    private String countryName;

    private static SafetyProtectionBean instance;

    public static SafetyProtectionBean getInstance() {
        if (instance == null) {
            instance = new SafetyProtectionBean();
        }
        return instance;
    }

    public String getAf_status() {
        return af_status;
    }


    public String getAf_message() {
        return af_message;
    }


    public boolean isIs_first_launch() {
        return is_first_launch;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setAf_status(String af_status) {
        this.af_status = af_status;
    }

    public void setAf_message(String af_message) {
        this.af_message = af_message;
    }

    public void setIs_first_launch(boolean is_first_launch) {
        this.is_first_launch = is_first_launch;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "SafetyProtectionBean{" +
                "af_status='" + af_status + '\'' +
                ", af_message='" + af_message + '\'' +
                ", is_first_launch=" + is_first_launch +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
