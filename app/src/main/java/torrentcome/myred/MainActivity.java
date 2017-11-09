package torrentcome.myred;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import torrentcome.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private TelephonyManager mTelephonyManager;
    private final PhoneStateListener phoneStateListener = new PhoneStateListener() {
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (mTelephonyManager != null) {
                set(mTelephonyManager.getNetworkType());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);

        mTelephonyManager = (TelephonyManager)
                getSystemService(Context.TELEPHONY_SERVICE);

        if (mTelephonyManager != null) {
            mTelephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_SERVICE_STATE);
            set(mTelephonyManager.getNetworkType());
        }
    }

    private void set(int type) {
        String networkClass = Network.getNetworkClass(type);
        String[] tab = networkClass.split("=");
        textView1.setText(tab[0]);
        textView2.setText(tab[1]);
    }
}
