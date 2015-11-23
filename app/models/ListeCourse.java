package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class ListeCourse extends Model {

  @Id
  @GeneratedValue
  private Long id;

  @Constraints.Required
  @Constraints.MaxLength(20)
  private String name;

  @OneToMany(mappedBy = "listeCourse", cascade = CascadeType.REMOVE)
  private List<Article> articles;

  public ListeCourse() {
    super();
  }

  public ListeCourse(String name) {
    this();
    this.name = name;
    this.articles = new ArrayList<Article>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Article> getArticles() {
    return this.articles;
  }

  public void addArticle(Article article) {
    this.articles.add(article);
  }

  public void removeArticle(Integer index) {
    this.articles.remove(index);
  }
}
