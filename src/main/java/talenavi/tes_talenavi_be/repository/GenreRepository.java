package talenavi.tes_talenavi_be.repository;

import talenavi.tes_talenavi_be.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
