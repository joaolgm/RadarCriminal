package radarCriminal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import radarCriminal.entity.School;

public interface SchoolRepository extends CrudRepository<School, String>{
	
	List<School> findSchoolByNeighbourhoodAndCity(String neighbourhood, String city);
	
	List<School> findSchoolByCity(String city);
	
	School findSchoolBySchoolCod(String schoolCod);	
	

}
