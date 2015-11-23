package models;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import dao.ListeCourseDao;


public class ListeCourseTest extends BaseModelTest{
	
	
	@Test
	public void insertTest(){
		ListeCourse liste = new ListeCourse("Carrefour");
		liste.save();
		List<ListeCourse> listeAll = ListeCourseDao.finderListeCourse.all();
		boolean found = false;
		for(ListeCourse listeBDD : listeAll){
			if(listeBDD.getName().equals("Carrefour")){
				found = true;
			}
		}
		assertTrue(found);
	}

}
