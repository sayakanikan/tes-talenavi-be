package talenavi.tes_talenavi_be.repository;

import talenavi.tes_talenavi_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
  List<Movie> findByTitleContainingIgnoreCase(String title);
}
