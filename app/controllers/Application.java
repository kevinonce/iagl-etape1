package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import dao.ArticleDao;
import dao.ListeCourseDao;
import models.Article;
import models.ListeCourse;
import play.api.mvc.BodyParser;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.ArticleService;
import services.ListeCourseService;
import play.libs.Json.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Application extends Controller {

  private ListeCourseService serviceListeCourse;
  private ArticleService serviceArticle;
  public static Form<ListeCourse> listeForm = Form.form(ListeCourse.class);
  public static Form<Article> articleForm = Form.form(Article.class);
  private static final  String CATEGORIE = "Legumes";

  
  private void build() {
    this.serviceListeCourse = new ListeCourseService();
    this.serviceArticle = new ArticleService();
  }
  
  /*
   * Route : /
   * Point d'entree de l'application
   */
  public Result index() {
    build();
    return ok(views.html.index.render(serviceListeCourse.getAllListeCourse(),listeForm));
  }
  
	public Result newList() {
		  Form<ListeCourse> filledForm = listeForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest
		    		(views.html.index.render(serviceListeCourse.getAllListeCourse(),filledForm));
		  } else {
			serviceListeCourse.createList(filledForm.get());
		    return redirect(routes.Application.index());  
		  }
		}
  
  public Result deleteList(Long id){
	  if(serviceListeCourse.deleteById(id)){
	    return ok(views.html.index.render(serviceListeCourse.getAllListeCourse(), listeForm));
	  }else
	  {
		  return badRequest("La liste n'existe pas");
	  }
  }
  
  public Result show(Long id)	{
	  ListeCourse liste = serviceListeCourse.getListeById(id);
	  if(liste == null){
		  return badRequest("Liste inexistante !");
	  }else{
		  return ok(views.html.viewliste.render(liste,articleForm));
	  }
  }
  
  public Result newArticle(Long idListe){
	  Form<Article> filledForm = articleForm.bindFromRequest();
	  if(filledForm.hasErrors()){
		  return badRequest(views.html.viewliste.render(serviceListeCourse.getListeById(idListe),filledForm));
	  }else{
		  Article article = filledForm.get();
		  ListeCourse liste = serviceListeCourse.getListeById(idListe);
		  if(liste == null){
			  return badRequest("Liste inexistante !");
		  }
		  article.setListeCourse(liste);
		  serviceArticle.createArticle(article);
		  return redirect(routes.Application.show(idListe));
	  }
  }
  public Result deleteArticle(){
	  JsonNode json = request().body().asJson();
	  if(json == null) {
	      return badRequest();
	  }else {
		  Long id = json.findPath("id").longValue();
	      if(id == null || id == 0l) {
	          return badRequest("L'identifiant de l'article est manquant !");
	      }else {
	    	  if(serviceArticle.deleteArticleById(id)){
				ObjectNode result = play.libs.Json.newObject();
				response().setContentType("application/json");
				result.put("status", "OK");
	    		return ok(result);
	    	  }else
	    	  {
	    		  return badRequest("L'article n'existe pas");
	    	  }
	      }
	    }
  }
}
