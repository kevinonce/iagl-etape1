package services;

import java.util.List;

import dao.ListeCourseDao;
import models.ListeCourse;

public class ListeCourseService {

  private ListeCourseDao daoListeCourse = new ListeCourseDao();

  /**
   * Retourne la liste de toutes les listes de courses enregistrees
   * @return Une liste de ListeCourse
   */
  public List<ListeCourse> getAllListeCourse() {
    return daoListeCourse.getAllListeCourse();
  }
  
  /**
   * Supprime une liste de course selon un id
   * @param id l'identifiant de la liste de course
   * */
  public boolean deleteById(Long id){
	  return daoListeCourse.deleteListeById(id);
  }
  
  /**
   * Créé une liste de course
   * @param liste la liste à créer
   * */
  public void createList(ListeCourse liste){
	  daoListeCourse.createList(liste);
  }
  
  
  /**
   * Récupère une liste de course à partir de son ID
   * @param ID l'identifiant de la liste à récupérer
   */
  public ListeCourse getListeById (Long id)	{
  	return daoListeCourse.getListeById(id);
  }
}
