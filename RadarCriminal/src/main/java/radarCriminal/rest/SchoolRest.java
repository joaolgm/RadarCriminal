package radarCriminal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import radarCriminal.entity.School;
import radarCriminal.repository.SchoolRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolRest {

	@Autowired
	private SchoolRepository schoolRepository;
	
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

    
    
}
