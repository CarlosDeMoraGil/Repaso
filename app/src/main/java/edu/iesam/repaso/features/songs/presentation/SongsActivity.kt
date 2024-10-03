package edu.iesam.repaso.features.songs.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.repaso.R
import edu.iesam.repaso.features.songs.data.local.SongXmlLocalDataSource
import edu.iesam.repaso.features.songs.domain.Song
import edu.iesam.repaso.features.songs.presentation.SongDetailActivity

class SongsActivity : AppCompatActivity() {

    private lateinit var songFactory: SongFactory
    private lateinit var viewModel: SongsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songFactory = SongFactory(this)
        viewModel = songFactory.buildViewModel()

        /**
         * - VER TODAS LAS CANCIONES
         *  val songs = viewModel.viewCreated()
         *  Log.d("@dev", songs.toString())
         *
         * - VER UNA CANCION
         *  val song = viewModel.itemSelected("2")
         *  Log.d("@dev", song.toString())
         *
         * - VER CANCIONES POR PANTALLA
         *  val songs = viewModel.viewCreated()
         *  bindData(songs)
         *
         * - GUARDAR UNA CANCION EN XML
         *  saveSongXML()
         *
         * - DEVOLVER UNA CANCION
         *  val song = findSong("3")
         *  Log.d("@dev",song.toString())
         *
         * - VACIAR ARCHIVO XML
         *  cleanFile()
         *
         * - GUARDAR UNA LISTA
         *  val songs = viewModel.viewCreated()
         *  saveAll(songs)
         *
         * - DEVOLVER TODAS LAS CANCIONES
         *  val songs = findAll()
         *  Log.d("@dev", songs.toString())
         *
         * - BORRAR POR ID
         *  deleteById("3")
         *
         */

        val songs = viewModel.viewCreated()
        bindData(songs)



    }

    // MOSTRAR CANCIONES POR PANTALLA
    private fun bindData(songs : List<Song>){
        findViewById<TextView>(R.id.song_id_1).text = songs[0].id
        findViewById<TextView>(R.id.song_title_1).text = songs[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(songs[0].id)
        }

        findViewById<TextView>(R.id.song_id_2).text = songs[1].id
        findViewById<TextView>(R.id.song_title_2).text = songs[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(songs[1].id)
        }

        findViewById<TextView>(R.id.song_id_3).text = songs[2].id
        findViewById<TextView>(R.id.song_title_3).text = songs[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(songs[2].id)
        }

        findViewById<TextView>(R.id.song_id_4).text = songs[3].id
        findViewById<TextView>(R.id.song_title_4).text = songs[3].name
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToMovieDetail(songs[3].id)
        }

    }

    private fun navigateToMovieDetail(id: String){
        startActivity(SongDetailActivity.getIntent(this, id))
    }



    /**
     * private fun saveSongXML(){
     *         val local = SongXmlLocalDataSource(this)
     *         val song = viewModel.itemSelected("3")
     *
     *         song?.let { song ->
     *             local.save(song)
     *         }
     *
     *
     *     }
     *
     *     private fun findSong(id: String): Song{
     *         val local = SongXmlLocalDataSource(this)
     *
     *         return local.findSong(id)
     *     }
     *
     *     private fun cleanFile(){
     *         val local = SongXmlLocalDataSource(this)
     *         local.clear()
     *     }
     *
     *     private fun saveAll(songs: List<Song>){
     *         val local = SongXmlLocalDataSource(this)
     *         local.saveAll(songs)
     *
     *     }
     *
     *     private fun findAll(): List<Song>{
     *         val local = SongXmlLocalDataSource(this)
     *         return local.findAll()
     *
     *     }
     *
     *     private fun deleteById(id: String){
     *         val local = SongXmlLocalDataSource(this)
     *         local.deleteById(id)
     *     }
     */

}
