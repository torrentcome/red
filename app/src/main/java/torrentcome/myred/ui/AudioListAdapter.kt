package torrentcome.myred.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_audio.view.*
import torrentcome.myred.R
import torrentcome.myred.db.AudioEntity
import kotlin.properties.Delegates

class AudioListAdapter(private val listener: (AudioEntity) -> Unit) : RecyclerView.Adapter<AudioListAdapter.AudioViewHolder>() {
    var list: List<AudioEntity> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder = AudioViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_audio, null))
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) = holder.bind(list[position], listener)
    inner class AudioViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(audio: AudioEntity, listener: (AudioEntity) -> Unit) = with(itemView) {
            title.text = audio.title
            path.text = audio.path
            setOnClickListener { listener(audio) }
        }
    }
}