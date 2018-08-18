package br.edu.ufcg.jukeboxdozenanzin.repository;

import java.util.List;

import br.edu.ufcg.jukeboxdozenanzin.entity.School;

public interface SchoolRepository {
	
	List<School> findSchoolByNeighbourhoodAndCity(String neighbourhood, String city);
	
	List<School> findSchoolByCity(String city);
	
	School findSchoolByCode(String schoolCod);
	
	

}
