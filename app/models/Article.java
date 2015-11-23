package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Constraint;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class Article extends Model {

  public Article(String name, String categorie, ListeCourse liste) {
    this.name = name;
    this.categorie = categorie;
    this.listeCourse = liste;
  }

  @Id
  @GeneratedValue
  private Long id;

  @Constraints.Required
  @Constraints.MaxLength(20)
  private String name;
  
  @Constraints.Required
  @Constraints.MaxLength(20)
  private String categorie;
  
  @ManyToOne
  private ListeCourse listeCourse;
  
  public String getName(){
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public ListeCourse getListeCourse() {
	return listeCourse;
}

public void setListeCourse(ListeCourse listeCourse) {
	this.listeCourse = listeCourse;
}
  
  
}