package talenavi.tes_talenavi_be.model;

import java.util.Set;


public class MovieRequest {
  private String title;
  private String director;
  private String summary;
  private Set<Integer> genresIds;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Set<Integer> getGenresIds() {
    return genresIds;
  }

  public void setGenresIds(Set<Integer> genresIds) {
    this.genresIds = genresIds;
  }
}
