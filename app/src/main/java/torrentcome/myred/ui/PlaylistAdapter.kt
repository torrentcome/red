package torrentcome.myred.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_audio.view.*
import torrentcome.myred.R
import torrentcome.myred.db.Audio
import kotlin.properties.Delegates

class PlaylistAdapter(private val listener: (Audio) -> Unit) : RecyclerView.Adapter<PlaylistAdapter.AudioViewHolder>() {
    var list: List<Audio> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder = AudioViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_audio, null))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) = holder.bind(list[position], listener)

    class AudioViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(audio: Audio, listener: (Audio) -> Unit) = with(itemView) {
            title.text = audio.title
            path.text = audio.path
            setOnClickListener { listener(audio) }
        }
    }
}