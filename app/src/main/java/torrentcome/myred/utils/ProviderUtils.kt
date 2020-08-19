package torrentcome.myred.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import torrentcome.myred.data.db.AudioEntity

object ProviderUtils {

    fun searchPhoneAudio(context: Context): List<AudioEntity> {
        val list: MutableList<AudioEntity> = ArrayList()
        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        )
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
        val cursor: Cursor? = context.contentResolver.query(
                uri,
                projection,
                selection,
                null,
                null
        )

        if (cursor != null) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                val name = path.substring(path.lastIndexOf("/") + 1)
                val mp3 = AudioEntity(
                        id = id.toLong(),
                        title = name,
                        path = path
                )
                list.add(mp3)
            }
            cursor.close()
        }
        return list
    }
}