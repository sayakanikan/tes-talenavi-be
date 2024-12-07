package talenavi.tes_talenavi_be.service;

import talenavi.tes_talenavi_be.entity.Genre;
import talenavi.tes_talenavi_be.entity.Movie;
import org.springframework.stereotype.Service;
import talenavi.tes_talenavi_be.model.MovieRequest;
import talenavi.tes_talenavi_be.model.MovieResponse;
import talenavi.tes_talenavi_be.repository.GenreRepository;
import talenavi.tes_talenavi_be.repository.MovieRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {
  private final MovieRepository movieRepository;
  private final GenreRepository genreRepository;

  public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
    this.movieRepository = movieRepository;
    this.genreRepository = genreRepository;
  }

  public List<Movie> getAll(String title) {
    List<Movie> movies;
    if (title != null && !title.isEmpty()) {
      movies = movieRepository.findByTitleContainingIgnoreCase(title);
    } else {
      movies = movieRepository.findAll();
    }

    return movies;
  }

  public Movie getById(int id) {
    return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
  }

  public Movie create(MovieRequest movieRequest) {
    Movie movie = new Movie();

    movie.setTitle(movieRequest.getTitle());
    movie.setDirector(movieRequest.getDirector());
    movie.setSummary(movieRequest.getSummary());

    Set<Genre> genres = new HashSet<>();
    for (int genreId : movieRequest.getGenresIds()) {
      Genre genre = genreRepository.findById(genreId)
              .orElseThrow(() -> new RuntimeException("Genre not found with ID: " + genreId));
      genres.add(genre);
    }
    movie.setGenres(genres);

    return movieRepository.save(movie);
  }

  public Movie update(int id, MovieRequest movieRequest) {
    Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));

    movie.setTitle(movieRequest.getTitle());
    movie.setDirector(movieRequest.getDirector());
    movie.setSummary(movieRequest.getSummary());

    Set<Genre> genres = new HashSet<>();
    for (int genreId : movieRequest.getGenresIds()) {
      Genre genre = genreRepository.findById(genreId)
              .orElseThrow(() -> new RuntimeException("Genre not found with ID: " + genreId));
      genres.add(genre);
    }
    movie.setGenres(genres);

    return movieRepository.save(movie);
  }

  public void delete(int id) {
    movieRepository.deleteById(id);
  }

  public MovieResponse mapToResponse(Movie movie) {
    MovieResponse response = new MovieResponse();

    response.setId(movie.getId());
    response.setTitle(movie.getTitle());
    response.setDirector(movie.getDirector());
    response.setSummary(movie.getSummary());

    Set<String> genreNames = new HashSet<>();
    for (Genre genre : movie.getGenres()) {
      genreNames.add(genre.getName());
    }
    response.setGenres(genreNames);

    return response;
  }
}
