package radarCriminal.repository;

import java.util.List;

import radarCriminal.entity.School;


public interface SchoolRepository {
	
	List<School> findSchoolByNeighbourhoodAndCity(String neighbourhood, String city);
	
	List<School> findSchoolByCity(String city);
	
	School findSchoolByCode(String schoolCod);
	
	

}
