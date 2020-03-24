package torrentcome.myred.exoplayer

import android.content.IntentFilter
import android.media.AudioManager
import android.net.wifi.WifiManager
import com.google.android.exoplayer2.SimpleExoPlayer

class Manager {
    private var wifiLock: WifiManager.WifiLock? = null
    private var audioManager: AudioManager? = null
    private val audioNoisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
    private var audioNoisyReceiverRegistered: Boolean = false
    private var exoPlayer: SimpleExoPlayer? = null
}