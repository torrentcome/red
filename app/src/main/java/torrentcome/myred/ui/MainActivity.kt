package torrentcome.myred.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.content_main.*
import torrentcome.myred.R
import torrentcome.myred.model.Mp3

const val REQUEST_PERMISSION_READ_EXTERNAL_STORAGE_CODE = 7031

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        if (isReadPhoneStatePermissionGranted()) {
            textview?.text = getAudio(this).map { it.name }.toString()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_PERMISSION_READ_EXTERNAL_STORAGE_CODE
                )
            }
        }
    }

    private fun getAudio(context: Context): List<Mp3> {
        val list: MutableList<Mp3> = ArrayList()
        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        )
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
        val c: Cursor? = context.contentResolver.query(
                uri,
                projection,
                selection,
                null,
                null)

        if (c != null) {
            while (c.moveToNext()) {
                val id = c.getString(c.getColumnIndex(MediaStore.Audio.Media._ID))
                val path = c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA))
                val name = path.substring(path.lastIndexOf("/") + 1)
                val mp3 = Mp3(
                        songId = id.toInt(),
                        name = name,
                        downloadPath = path
                )
                list.add(mp3)
            }
            c.close()
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
                    textview?.text = getAudio(this).map { it.name }.toString()
                } else {
                }
            }
        }
    }
}

