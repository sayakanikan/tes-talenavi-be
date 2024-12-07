package talenavi.tes_talenavi_be.controller;

import org.springframework.http.HttpStatus;
import talenavi.tes_talenavi_be.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talenavi.tes_talenavi_be.model.MovieRequest;
import talenavi.tes_talenavi_be.model.MovieResponse;
import talenavi.tes_talenavi_be.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public List<Movie> getAll(@RequestParam(required = false) String title) {
    return movieService.getAll(title);
  }

  @GetMapping("/{id}")
  public Movie getById(@PathVariable int id) {
    return movieService.getById(id);
  }

  @PostMapping
  public ResponseEntity<MovieResponse> create(@RequestBody MovieRequest movieRequest) {
    Movie movie = movieService.create(movieRequest);
    MovieResponse response = movieService.mapToResponse(movie);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MovieResponse> update(@PathVariable int id, @RequestBody MovieRequest movieRequest) {
    Movie updatedMovie = movieService.update(id, movieRequest);
    MovieResponse response = movieService.mapToResponse(updatedMovie);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    movieService.delete(id);
    return ResponseEntity.ok("Movie has been deleted successfully");
  }
}
