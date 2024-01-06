package com.coyago.musicplayer.logic

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

class MusicUtils(private val context: Context) {

    fun getAllSongs(): List<Song> {
        val songs = mutableListOf<Song>()

        // Definir la proyección que a obtener
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.DATA
        )

        // Obtener el ContentResolver
        val contentResolver: ContentResolver = context.contentResolver

        // Consultar la base de datos de MediaStore
        val cursor: Cursor? = contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        // Procesar los resultados de la consulta
        cursor?.use { c ->
            val idColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val titleColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val albumColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)
            val durationColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
            val dataColumn = c.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

            while (c.moveToNext()) {
                val id = c.getLong(idColumn)
                val title = c.getString(titleColumn)
                val artist = c.getString(artistColumn)
                val album = c.getString(albumColumn)
                val duration = c.getLong(durationColumn)
                val data = c.getString(dataColumn)

                // Verificar que la extensión sea .mp3
                if (data.endsWith(".mp3", ignoreCase = true)) {
                    val contentUri: Uri = ContentUris.withAppendedId(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        id
                    )

                    val song = Song(id, title, artist, album, duration, data, contentUri)
                    songs.add(song)
                }
            }
        }

        return songs
    }
}

data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val album: String,
    val duration: Long,
    val data: String,
    val contentUri: Uri
)
