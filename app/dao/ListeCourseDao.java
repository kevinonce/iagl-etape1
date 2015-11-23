package dao;

import java.util.List;

import com.avaje.ebean.Model.Finder;

import models.ListeCourse;

public class ListeCourseDao {

  public static Finder<Long, ListeCourse> finderListeCourse = new Finder<>(ListeCourse.class);

  /**
   * Retourne toutes les listes de courses sauvees.
   * @return une liste de listeCourse
   */
  public List<ListeCourse> getAllListeCourse() {
    return finderListeCourse.all();
  }
  
  /**
   * Créé une liste de course
   * @param liste la liste à créer
   * */
  public void createList(ListeCourse liste){
	  liste.save();
  }
  
  /**
   * Récupère une liste de course
   * @param ID l'identifiant de la liste de course
   * @return la liste de course à récupérer
   */
  public ListeCourse getListeById (Long id)	{
	  return finderListeCourse.byId(id);
  }
  
  /**
   * supprime une liste de course
   * @param ID l'identifiant de la liste de course
   * @return true si elle a été supprimé
   */
  public boolean deleteListeById (Long id)	{
	if(finderListeCourse.byId(id) == null){
		return false;
	}
	finderListeCourse.byId(id);
	
	return true;
  }
}
