package com.safetyprotection.IpAddress;

import android.util.Log;

import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

import java.net.InetAddress;

/**
 * @类描述: 获取IP管理类
 * @项目名称: SafetyProtection
 * @包名称: com.safetyprotection.IpAddress
 * ==================================================
 * @创建人: 雾都雄狮
 * @创建时间: 2024/1/2 19:28
 * @version: V1.0
 * ==================================================
 */
public class IpAddressManage {

    private static IpAddressManage instance;
    private static final String LOG_TAG = "IpAddressManage";

    private static final int TIMEOUT_MS = 5000;

    /**
     * 单例模式
     * <p>
     * ==================================================
     *
     * @author: 雾都雄狮
     * @version: V1.0  2024/1/2
     * ==================================================
     **/
    public static IpAddressManage getInstance() {
        if (instance == null) {
            instance = new IpAddressManage();
        }
        return instance;
    }

    public String getIpAddress(String domainName) {
//        Response response = OKHttpUtils.instance().httpGet("https://www.example.com/");
        String lookupIP = lookupIP(domainName);
        return lookupIP;
    }

    public String lookupIP(String domainName) {
        InetAddress address = null;
        try {
            Lookup lookup = new Lookup(domainName, Type.A);
            Record[] records = lookup.run();

            if (lookup.getResult() == Lookup.SUCCESSFUL) {
                for (Record record : records) {
                    ARecord a = (ARecord) record;
                    address = a.getAddress();
                }
            } else {
                Log.e(LOG_TAG, "Error: " + lookup.getErrorString());
            }
        } catch (TextParseException e) {
            System.out.println("Invalid domain name");
        }
        Log.e(LOG_TAG, "IpAddress: " + address+"");
        if (address != null)
            return address.getHostAddress();

        return "";
    }
}
