package torrentcome.myred;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by come on 04/01/2017.
 * see the connectivity stuff
 */

class Connectivity {


    /**
     * Check if the connection is fast
     *
     * @param context  get the telephonyManager of the activity
     * @return speed of the networks
     */
    static String getNetworkClass(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = mTelephonyManager.getNetworkType();
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return "NETWORK_TYPE_GPRS = 2G~ 100 kbps";
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return "NETWORK_TYPE_EDGE = 2G~ 50-100 kbps";
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return "NETWORK_TYPE_CDMA = 2G~ 14-64 kbps";
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return "NETWORK_TYPE_1xRTT = 2G ~ 50-100 kbps";
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "NETWORK_TYPE_IDEN = 2G~25 kbps";
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return "NETWORK_TYPE_UMTS = 3G~ 400-7000 kbps";
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return "NETWORK_TYPE_EVDO_0 = 3G~ 600-1400 kbps";
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return "NETWORK_TYPE_EVDO_A = 3G~ 400-1000 kbps";
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return "NETWORK_TYPE_HSDPA = 3G~ 2-14 Mbps";
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return "NETWORK_TYPE_HSUPA = 3G~ 1-23 Mbps";
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return "NETWORK_TYPE_HSPA = 3G~ 700-1700 kbps";
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return "NETWORK_TYPE_EVDO_B = 3G~ 5 Mbps";
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return "NETWORK_TYPE_EHRPD = 3G~ 1-2 Mbps";
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "NETWORK_TYPE_HSPAP = 3G~ 10-20 Mbps";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "NETWORK_TYPE_LTE = 4G~ 10+ Mbps";
            default:
                return "Unknown = Unknown";
        }
    }


}
