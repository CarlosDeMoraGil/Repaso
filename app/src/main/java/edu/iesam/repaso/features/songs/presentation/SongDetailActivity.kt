package edu.iesam.repaso.features.songs.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.repaso.R
import edu.iesam.repaso.app.extensions.loadUrl
import edu.iesam.repaso.features.songs.domain.Song

class SongDetailActivity : AppCompatActivity() {

    private lateinit var songFactory: SongFactory
    private lateinit var viewModel: SongDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        songFactory = SongFactory(this)
        viewModel = songFactory.buildDetailViewModel()

        getSongId()?.let { songId ->
            viewModel.viewCreated(songId)?.let { song ->
                bindData(song)
            }
        }



    }

    private fun getSongId(): String?{
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(song: Song){
        val imageView = findViewById<ImageView>(R.id.poster)
        imageView.loadUrl(song.Url)
    }

    companion object{
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, id: String): Intent {
            val intent = Intent(context, SongDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, id)
            return intent
        }

    }

}