import java.util.List;

import dao.ListeCourseDao;
import models.Article;
import models.ListeCourse;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{
	
	  @Override
	  public void onStart(Application app) {
		  
		/*  List<ListeCourse> listes = ListeCourseDao.finderListeCourse.all();
		  if( listes == null || listes.size() <=0){
		    // Listes de courses
		    ListeCourse liste = new ListeCourse("Auchan");
				liste.save();
				
				ListeCourse liste2 = new ListeCourse("Lidl");
				liste2.save();
				
				// Articles
				Article article1 = new Article("Salade","Legumes", liste);
				Article article2 = new Article("Carottes","Legumes", liste);
				Article article3 = new Article("Tomates","Legumes", liste);
				Article article4 = new Article("Saumon","Poissons", liste2);
				Article article5 = new Article("Oeufs","viandes et substituts", liste2);
				
				article1.save();
				article2.save();
				article3.save();
				article4.save();
				article5.save();
		  }*/
	  }

}
