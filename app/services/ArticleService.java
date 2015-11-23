package services;

import java.util.List;

import dao.ArticleDao;
import models.Article;
import models.ListeCourse;

public class ArticleService {

  private ArticleDao daoArticle = new ArticleDao();

  /**
   * Retourne la liste de tous les articles enregistres
   * @return une liste d'Article
   */
  public List<Article> getAllArticle() {
    return daoArticle.getAllArticle();
  }

  /**
   * Retourne la liste des articles d'une categorie
   * @param Categorie la categorie pour laquelle on cherche les articles
   * @return Une liste d'Article
   */
  public List<Article> getArticleByCategorie(String categorie) {
    return daoArticle.getArticleByCategorie(categorie);
  }
  
  /**
   * Retourne un article particulier à partir de son ID
   * @param ID l'identifiant de l'article à récupérer
   */
  public Article getArticleById (Long id){
	  return daoArticle.getArticleById(id);
  }
  
  /**
   * Créé un article
   * @param l'article à créer
   * */
  public void createArticle(Article article){
	  daoArticle.createArticle(article);
  }
  
  public boolean deleteArticleById(Long id){
	  return daoArticle.deleteArticleById(id);
  }
}
