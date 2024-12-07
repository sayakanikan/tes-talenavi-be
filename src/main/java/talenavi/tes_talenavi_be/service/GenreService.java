package talenavi.tes_talenavi_be.service;

import talenavi.tes_talenavi_be.entity.Genre;
import org.springframework.stereotype.Service;
import talenavi.tes_talenavi_be.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {
  private final GenreRepository genreRepository;

  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  public List<Genre> getAll() {
    return genreRepository.findAll();
  }

  public Genre getById(int id) {
    return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
  }

  public Genre create(Genre genre) {
    return genreRepository.save(genre);
  }

  public Genre update(int id, Genre genreDetails) {
    Genre genre = getById(id);
    genre.setName(genreDetails.getName());
    return genreRepository.save(genre);
  }

  public void delete(int id) {
    genreRepository.deleteById(id);
  }
}
