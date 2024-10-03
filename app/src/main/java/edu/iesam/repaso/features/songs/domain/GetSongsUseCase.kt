package edu.iesam.repaso.features.songs.domain

class GetSongsUseCase (private val songRepository: SongRepository) {

   operator fun invoke(): List<Song>{
       return  songRepository.getSongs()
   }

}