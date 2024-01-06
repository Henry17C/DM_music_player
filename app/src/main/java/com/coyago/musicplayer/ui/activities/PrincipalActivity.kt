package com.coyago.musicplayer.ui.activities

import android.Manifest
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.coyago.musicplayer.R
import com.coyago.musicplayer.databinding.ActivityPrincipalBinding
import com.coyago.musicplayer.logic.MusicUtils
import com.coyago.musicplayer.logic.Song
import com.coyago.musicplayer.ui.adapters.SongAdapter
import com.coyago.musicplayer.ui.fragments.MusicFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initNavigationBar()
        initRecycleview()





        }

    private fun initRecycleview() {

        lifecycleScope.launch(Dispatchers.Main) {
            val songs= withContext(Dispatchers.IO){ getSongList()}
            val adapter: SongAdapter= SongAdapter(songs)
/////////

            val myUri: Uri = getSongList().get(5).contentUri
            val mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(applicationContext, myUri)
                prepare()
                start()
            }


///////


            binding.rvSongs.adapter= adapter
            binding.rvSongs.layoutManager=
                LinearLayoutManager(this@PrincipalActivity, LinearLayoutManager.VERTICAL, false)
           // binding.animationView.visibility= View.GONE
        }

    }


    suspend fun  getSongList():List<Song> = MusicUtils(this).getAllSongs()

    private fun playSong(song: Song) {

    }


    fun initNavigationBar(){


            val musicFragment= MusicFragment()

            val transaction = supportFragmentManager.beginTransaction()


            binding.bottomNavigation.setOnItemSelectedListener(){ item ->
                when(item.itemId) {
                    R.id.item_home -> {
                        // Respond to navigation item 1 click
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(binding.frmContainer.id, musicFragment)
                        transaction.commit()
                        true
                    }
                    R.id.item_music -> {
                        // Respond to navigation item 1 click
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(binding.frmContainer.id, musicFragment)
                        transaction.commit()
                        true
                    }

                    R.id.item_search -> {
                        // Respond to navigation item 1 click
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(binding.frmContainer.id, musicFragment)
                        transaction.commit()
                        true
                    }
                    else -> {

                        false

                    }
                }

        }

    }
}