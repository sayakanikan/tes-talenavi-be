package talenavi.tes_talenavi_be.controller;

import talenavi.tes_talenavi_be.entity.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talenavi.tes_talenavi_be.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping
  public List<Genre> getAll() {
    return genreService.getAll();
  }

  @GetMapping("/{id}")
  public Genre getById(@PathVariable int id) {
    return genreService.getById(id);
  }

  @PostMapping
  public Genre create(@RequestBody Genre genre) {
    return genreService.create(genre);
  }

  @PutMapping("/{id}")
  public Genre update(@PathVariable int id, @RequestBody Genre genre) {
    return genreService.update(id, genre);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    genreService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
