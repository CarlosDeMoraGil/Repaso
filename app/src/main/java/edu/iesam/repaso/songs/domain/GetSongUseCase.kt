package edu.iesam.repaso.features.songs.domain

class GetSongUseCase (private val songRepository: SongRepository){

    operator fun invoke (id: String) : Song?{
        return songRepository.getSong(id)
    }

}