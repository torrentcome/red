package torrentcome.myred.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_audio.*
import org.koin.android.viewmodel.ext.android.viewModel
import torrentcome.myred.R
import torrentcome.myred.db.AudioEntity

// permission
const val REQUEST_PERMISSION_READ_EXTERNAL_STORAGE_CODE = 7031

class ListAudioActivity : AppCompatActivity() {
    private val viewModel: AudioViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        if (isReadPhoneStatePermissionGranted()) {
            logic()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_PERMISSION_READ_EXTERNAL_STORAGE_CODE
                )
            }
        }
        val adapter = AudioListAdapter { selection -> Log.i("list", "" + selection.path) }
        recycler_view.adapter = adapter

        viewModel.playlist.observe(this, Observer { list ->
            if (list.isEmpty()) {
                text.visibility = View.VISIBLE
                text.text = getString(R.string.no_data)
            } else {
                text.visibility = View.GONE
                adapter.list = list
            }
        })
    }

    private fun logic() {
        val searchPhoneAudio = searchPhoneAudio(this)
        viewModel.saveData(searchPhoneAudio)
        viewModel.getData()
    }

    private fun searchPhoneAudio(context: Context): List<AudioEntity> {
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

    private fun isReadPhoneStatePermissionGranted(): Boolean {
        val firstPermissionResult = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return firstPermissionResult == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            @NonNull permissions: Array<String>,
            @NonNull grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_PERMISSION_READ_EXTERNAL_STORAGE_CODE -> if (grantResults.isNotEmpty()) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    logic()
                } else {
                }
            }
        }
    }
}