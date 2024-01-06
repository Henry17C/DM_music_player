package com.coyago.musicplayer.ui.activities

// MainActivity.kt
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.coyago.musicplayer.R
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay: Button = findViewById(R.id.btnPlay)
        val btnStop: Button = findViewById(R.id.btnStop)

        btnPlay.setOnClickListener { checkPermissionAndPlayMusic() }
        btnStop.setOnClickListener { stopMusic() }
    }

    private fun checkPermissionAndPlayMusic() {
        if (checkPermission()) {
            playMusic()
        } else {
            requestPermission()
        }
    }

    private fun playMusic() {
        stopMusic() // Detener la música actual si hay alguna reproducción en curso

        val songPath = getSongPath()
        if (songPath != null) {
            mediaPlayer = MediaPlayer()
            try {
                mediaPlayer?.setDataSource(songPath)
                mediaPlayer?.prepare()
                mediaPlayer?.start()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun getSongPath(): String? {
        val musicResolver = contentResolver
        val musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"

        val musicCursor = musicResolver.query(
            musicUri,
            null,
            selection,
            null,
            null
        )

        if (musicCursor != null && musicCursor.moveToFirst()) {
            val musicPathIndex = musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA)
            val musicPath = musicCursor.getString(musicPathIndex)
            return musicPath
        }

        musicCursor?.close()
        return null
    }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
            READ_EXTERNAL_STORAGE_REQUEST_CODE
        )
    }

    companion object {
        private const val READ_EXTERNAL_STORAGE_REQUEST_CODE = 1
    }
}