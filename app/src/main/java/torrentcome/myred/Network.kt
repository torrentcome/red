package torrentcome.myred

import android.telephony.TelephonyManager

/**
 * Created by come on 04/01/2017.
 * see the connectivity stuff
 */
internal object Network {
    /**
     * Check state of the connection
     */
    fun getNetworkClass(networkType: Int): String {
        return when (networkType) {
            TelephonyManager.NETWORK_TYPE_GPRS -> "NETWORK_TYPE_GPRS = 2G~ 100 kbps"
            TelephonyManager.NETWORK_TYPE_EDGE -> "NETWORK_TYPE_EDGE = 2G~ 50-100 kbps"
            TelephonyManager.NETWORK_TYPE_CDMA -> "NETWORK_TYPE_CDMA = 2G~ 14-64 kbps"
            TelephonyManager.NETWORK_TYPE_1xRTT -> "NETWORK_TYPE_1xRTT = 2G ~ 50-100 kbps"
            TelephonyManager.NETWORK_TYPE_IDEN -> "NETWORK_TYPE_IDEN = 2G~25 kbps"
            TelephonyManager.NETWORK_TYPE_UMTS -> "NETWORK_TYPE_UMTS = 3G~ 400-7000 kbps"
            TelephonyManager.NETWORK_TYPE_EVDO_0 -> "NETWORK_TYPE_EVDO_0 = 3G~ 600-1400 kbps"
            TelephonyManager.NETWORK_TYPE_EVDO_A -> "NETWORK_TYPE_EVDO_A = 3G~ 400-1000 kbps"
            TelephonyManager.NETWORK_TYPE_HSDPA -> "NETWORK_TYPE_HSDPA = 3G~ 2-14 Mbps"
            TelephonyManager.NETWORK_TYPE_HSUPA -> "NETWORK_TYPE_HSUPA = 3G~ 1-23 Mbps"
            TelephonyManager.NETWORK_TYPE_HSPA -> "NETWORK_TYPE_HSPA = 3G~ 700-1700 kbps"
            TelephonyManager.NETWORK_TYPE_EVDO_B -> "NETWORK_TYPE_EVDO_B = 3G~ 5 Mbps"
            TelephonyManager.NETWORK_TYPE_EHRPD -> "NETWORK_TYPE_EHRPD = 3G~ 1-2 Mbps"
            TelephonyManager.NETWORK_TYPE_HSPAP -> "NETWORK_TYPE_HSPAP = 3G~ 10-20 Mbps"
            TelephonyManager.NETWORK_TYPE_LTE -> "NETWORK_TYPE_LTE = 4G~ 10+ Mbps"
            else -> "Unknown = Unknown"
        }
    }
}