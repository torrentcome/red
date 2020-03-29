package torrentcome.myred.exoplayer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.util.Log
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer

const val TAG = "exoplayer"
class Manager {
    private var audioManager: AudioManager? = null

    // Broadcast intent, a hint for applications that audio is about to become 'noisy' due to a change in audio outputs
    private val audioNoisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
    private var audioNoisyReceiverRegistered: Boolean = false

    private var exoPlayer: SimpleExoPlayer? = null
    private val eventListener = ExoPlayerEventListener()

    private val mAudioNoisyReceiver = object : BroadcastReceiver() {
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

    inner class ExoPlayerEventListener : Player.EventListener {
    }
}