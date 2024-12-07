package talenavi.tes_talenavi_be.repository;

import talenavi.tes_talenavi_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
