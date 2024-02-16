package com.coyago.musicplayer.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.coyago.musicplayer.R
import com.coyago.musicplayer.databinding.SongItemsBinding
import com.coyago.musicplayer.logic.Song

class SongAdapter (private val listSongs:List<Song>): RecyclerView.Adapter<SongAdapter.UsersViewHolder>() {



    class UsersViewHolder(view: View): RecyclerView.ViewHolder(view) {

        //se maneja los elementos(items)  uno por uno iterativamente. Esta se
        // manera de acuerdo a las necesidades de la aplicacion, es maneja la logica ligada a la UI, no a la logica de negocio
        private var binding: SongItemsBinding= SongItemsBinding.bind(view)

        fun render(item:Song){
           // binding.imageView.load("https://previews.123rf.com/images/bahtiarmaulana/bahtiarmaulana2204/bahtiarmaulana220400040/185159316-rebanada-de-dibujos-animados-de-pizza-ilustraci%C3%B3n-de-dibujos-animados-vectoriales-im%C3%A1genes.jpg"){

            Log.d("ImageLoading", "URI de carátula del álbum: ${item.albumArtUri}")

            try {
                binding.imageView.load(item.albumArtUri.toString()) {
                    crossfade(true)
                    placeholder(R.drawable.image)
                    transformations(CircleCropTransformation())
                }
            } catch (e: Exception) {
                Log.e("ImageLoading", "Error al cargar la imagen: ${e.message}")
            }
            binding.txtArtist.text=item.artist.toString()
            binding.txtTitle.text=item.title.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        //se hace el binding para el  layout que tenemos
        val  inflater= LayoutInflater.from(parent.context) //

        return UsersViewHolder(inflater.inflate(R.layout.song_items,parent, false)) //



    }

    //cuantos elementos hay para poder pintar en pantalla
    override fun getItemCount(): Int = listSongs.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.render(listSongs[position])
    }




}