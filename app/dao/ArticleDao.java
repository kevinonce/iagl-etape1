package dao;

import java.util.List;

import com.avaje.ebean.Model.Finder;

import models.Article;
import models.ListeCourse;

public class ArticleDao {
  
  public static Finder<Long, Article> finderArticle = new Finder<>(Article.class);
  
  /**
   * Retourne la liste des articles sauves.
   * @return Une liste d'Article
   */
  public List<Article> getAllArticle() {
    return finderArticle.all();
  }
  
  /**
   * Retourne la liste des articles d'une categorie
   * @param categorie La categorie pour laquelle on cherche les articles
   * @return Une liste d'Article
   */
  public List<Article> getArticleByCategorie(String categorie){
	  return finderArticle.db().find(Article.class).where().eq("categorie", categorie).findList();
  }

  /**
   * Récupère un article à partir de son ID
   * @param id l'identifiant de l'article à récupérer
   * @return l'article à trouver
   */
public Article getArticleById (Long id) {
	return finderArticle.byId(id);
}

/**
 * Créé un article
 * @param l'article à créer
 * */
public void createArticle(Article article){
	  article.save();
}

/**
 * Supprime un article
 * @param id l'identifiant de l'article à supprimer
 * @return true si l'article a bien été supprimé
 * */
public boolean deleteArticleById(Long id){
	Article article = finderArticle.byId(id);
	if(article == null){
		return false;
	}else{
		finderArticle.deleteById(id);
		return true;
	}
	
}

}
