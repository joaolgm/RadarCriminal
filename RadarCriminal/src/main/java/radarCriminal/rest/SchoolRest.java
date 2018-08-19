package radarCriminal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import radarCriminal.entity.Crime;
import radarCriminal.entity.School;
import radarCriminal.repository.CrimeRepository;
import radarCriminal.repository.SchoolRepository;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolRest {

	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private CrimeRepository crimeRepository;
	
    @RequestMapping(method = RequestMethod.GET)
    public List<School> listSchoolByNeighbourhoodAndCity(
            @RequestParam(value="neighbourhood", required = false) String neighbourhood,
            @RequestParam(value="city", required = true) String city) {
    	
    	if(neighbourhood == null || neighbourhood.trim() == "") {
    		return schoolRepository.findSchoolByCity(city);
    	} else {
    		return schoolRepository.findSchoolByNeighbourhoodAndCity(neighbourhood, city);
    	}
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public School findSchoolByCode(@PathVariable(value="id") String schoolCode) {
    	return schoolRepository.findSchoolBySchoolCod(schoolCode);
    }

    @RequestMapping(path = "/city/{city}", method = RequestMethod.GET)
    public List<School> findSchoolByCity(@PathVariable(value="city") String city) {
    	return schoolRepository.findSchoolByCity(city);
    }

    
    @RequestMapping(path = "/geral/{city}/{neighbourhood}", method = RequestMethod.GET)
    public List<Integer> infoBairro(@PathVariable(value="city") String city, @PathVariable(value="neighbourhood") String neighbourhood) {
    	List<School> schools = schoolRepository.findSchoolByNeighbourhood(neighbourhood);
    	int sumStudents = 0;
    	for (School school : schools) {
			sumStudents += school.getQtdAlunos();
		}
    	
    	List<Crime> crimes = crimeRepository.findCrimeByNeighbourhood(neighbourhood);
    	List<Integer> temp = new LinkedList<Integer>();
    	temp.add(sumStudents);
    	temp.add(crimes.size());
    	
    	return temp; 
    	
    	//return new infoBairro(sumStudents, crimes.size());
    	
    }
    
    
}
