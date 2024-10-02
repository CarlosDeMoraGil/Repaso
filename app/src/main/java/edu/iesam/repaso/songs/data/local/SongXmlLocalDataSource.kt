package edu.iesam.repaso.features.songs.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.repaso.R
import edu.iesam.repaso.features.songs.domain.Song

class SongXmlLocalDataSource (private val context: Context){

    /**
     *
     * ALMACENAMOS EN FORMATO JSON
     * IMPLEMENTAMOS LA LIBRERIA GSON
     *
     */

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.file_name_xml), Context.MODE_PRIVATE)

    private val gson = Gson()

    fun save(song: Song){
        val editor = sharedPref.edit()
        editor.putString("id", song.id)
        editor.putString("name", song.name)
        editor.putString("artist", song.artist)
        editor.putString("duration", song.duration)
        editor.putString("album", song.album)
        editor.apply()
    }

    fun findSong(id: String): Song {
        val id = sharedPref.getString("id", " ")
        val name = sharedPref.getString("name", " ")
        val artist = sharedPref.getString("artist", " ")
        val duration = sharedPref.getString("duration", " ")
        val album = sharedPref.getString("album", " ")
        return Song(id!!, name!!, artist!!, duration!!, album!!)
    }

    fun clear(){
        sharedPref.edit().clear().apply()
    }

    fun saveAll(songs: List<Song>){
        val editor = sharedPref.edit()
        songs.forEach{song ->
            editor.putString(song.id, gson.toJson(song))
        }
        editor.apply()

    }

    fun findAll(): List<Song>{
        val songs = ArrayList<Song>()
        val mapSongs = sharedPref.all as Map<String, String>
        mapSongs.values.forEach{jsonSong ->
            val song = gson.fromJson(jsonSong, Song::class.java)
            songs.add(song)
        }
        return songs
        
    }

    fun deleteById(id: String){
        sharedPref.edit().remove(id).apply()
    }

}