package torrentcome.myred.exoplayer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.util.Log
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import torrentcome.myred.db.AudioEntity

const val TAG = "exoplayer"
private val VOLUME_DUCK = 0.2f
private val VOLUME_NORMAL = 1.0f
private val AUDIO_NO_FOCUS_NO_DUCK = 0
private val AUDIO_NO_FOCUS_CAN_DUCK = 1
private val AUDIO_FOCUSED = 2

class Manager(private val context: Context) {
    private var currentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK
    private var audioNoisyReceiverRegistered: Boolean = false
    private var audioManager: AudioManager? = null
    private var simpleExoPlayer: SimpleExoPlayer? = null
    private var playOnFocusGain: Boolean = false
    private var currentAudio: AudioEntity? = null
    private val audioNoisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
    private val eventListener = ExoPlayerEventListener()
    private val audioNoisyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY == intent.action) {
                Log.d(TAG, "headphone disconnected")
                /*if (isPlaying()) {
                    val i = Intent(context, PlayerService::class.java)
                    i.action = PlayerService.ACTION_CMD
                    i.putExtra(PlayerService.CMD_NAME, PlayerService.CMD_PAUSE)
                    context.applicationContext.startService(i)
                }*/
            }
        }
    }

    init {
        audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    inner class ExoPlayerEventListener : Player.EventListener{

    }
}

interface ManagerCallback {

}