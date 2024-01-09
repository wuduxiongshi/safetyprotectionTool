package com.safetyprotection.AppFlyer;

import com.safetyprotection.App;
import com.safetyprotection.SpUtil.SpUtil;

import java.io.Serializable;

public class AppsFlyerBean implements Serializable {
    private String af_status;
    private String af_message;
    private boolean is_first_launch = false;

    private static AppsFlyerBean instance;

    protected static AppsFlyerBean getInstance() {
        if (instance == null) {
            instance = new AppsFlyerBean();
        }
        return instance;
    }

    public String getAf_status() {
        if ("".equals(af_status) && af_status == null) {
            af_status = SpUtil.getString(App.getContext(), "af_status", "");
        }
        return af_status;
    }

    public void setAf_status(String af_status) {
        SpUtil.putString(App.getContext(), "af_status", af_status);
        this.af_status = af_status;
    }

    public String getAf_message() {
        if ("".equals(af_message) && af_message == null) {
            af_message = SpUtil.getString(App.getContext(), "af_message", "");
        }
        return af_message;
    }

    public void setAf_message(String af_message) {
        SpUtil.putString(App.getContext(), "af_message", af_message);
        this.af_message = af_message;
    }

    public boolean isIs_first_launch() {
        return is_first_launch;
    }

    public void setIs_first_launch(boolean is_first_launch) {
        SpUtil.putBoolean(App.getContext(), "is_first_launch", is_first_launch);
        this.is_first_launch = is_first_launch;
    }

    @Override
    public String toString() {
        return "AppsFlyerBean{" +
                "af_status='" + af_status + '\'' +
                ", af_message='" + af_message + '\'' +
                ", is_first_launch='" + is_first_launch + '\'' +
                '}';
    }
}
