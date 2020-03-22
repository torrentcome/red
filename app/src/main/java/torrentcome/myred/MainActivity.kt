package torrentcome.myred

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.ServiceState
import android.telephony.TelephonyManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var mTelephonyManager: TelephonyManager? = null
    private val phoneStateListener: PhoneStateListener = object : PhoneStateListener() {
        override fun onServiceStateChanged(serviceState: ServiceState) {
            super.onServiceStateChanged(serviceState)
            if (mTelephonyManager != null) {
                set(mTelephonyManager!!.networkType)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        textView1 = findViewById(R.id.textview1)
        textView2 = findViewById(R.id.textview2)
        mTelephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (mTelephonyManager != null) {
            mTelephonyManager!!.listen(phoneStateListener, PhoneStateListener.LISTEN_SERVICE_STATE)
            set(mTelephonyManager!!.networkType)
        }
    }

    private fun set(type: Int) {
        val networkClass = Network.getNetworkClass(type)
        val tab = networkClass!!.split("=").toTypedArray()
        textView1!!.text = tab[0]
        textView2!!.text = tab[1]
    }
}