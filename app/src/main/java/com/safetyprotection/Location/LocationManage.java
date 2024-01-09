package com.safetyprotection.Location;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.safetyprotection.AppFlyer.AppsFlyerCallBase;
import com.safetyprotection.SafetyProtectionManageD.Bean.SafetyProtectionBean;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * @类描述: EasyPermissions 定位服务管理类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 17:43
 * @version: V1.0
 * ==================================================
 */
public class LocationManage {
    private static LocationManage instance;
    private static final String LOG_TAG = "LocationManage";

    private String countryName = "";


    /**
     * 单例模式
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public static LocationManage getInstance() {
        if (instance == null) {
            instance = new LocationManage();
        }
        return instance;
    }

//    public void getFusedLocationProviderClient(Context mContext, AppsFlyerCallBase appsFlyerCallBase) {
//        String countryName = getFusedLocationProviderClient(mContext);
//        SafetyProtectionBean.getInstance().setCountryName(countryName);
//        appsFlyerCallBase.OnCallBack(SafetyProtectionBean.getInstance());
//
//    }

    public String getFusedLocationProviderClient(Context mContext, AppsFlyerCallBase appsFlyerCallBase) {
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);

        if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            new AppSettingsDialog.Builder((Activity) mContext).build().show();
            return "";
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                // 使用位置信息
                Log.d(LOG_TAG, "location: " + location);
                if (Geocoder.isPresent()) {
                    Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        if (addresses != null && !addresses.isEmpty()) {
                            countryName = addresses.get(0).getCountryName();
                            // 使用国家名称
                            Log.d(LOG_TAG, "countryName: " + countryName);
                            SafetyProtectionBean.getInstance().setCountryName(countryName);
                            if (appsFlyerCallBase != null) {
                                appsFlyerCallBase.OnCallBack(SafetyProtectionBean.getInstance());
                            }
                        }
                    } catch (IOException e) {
                        // 处理异常
                    }
                }
            }
        }).addOnFailureListener(OnFailureListener -> {
            Log.d(LOG_TAG, "OnFailureListener: " + OnFailureListener);
        });
        return countryName;
    }

}
