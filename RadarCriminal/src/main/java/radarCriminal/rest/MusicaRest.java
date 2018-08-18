package radarCriminal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import radarCriminal.entity.School;
import radarCriminal.repository.SchoolRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/schools")
public class MusicaRest {

	@Autowired
	SchoolRepository schoolRepository;
	
    @RequestMapping(method = RequestMethod.GET)
    public List<School> listSchoolByNbhdAndCity(
            @RequestParam(value="bairro", required = false) String neighbourhood,
            @RequestParam(value="municipio", required = true) String city) {
    	
    	if(neighbourhood == null) {
    		return schoolRepository.findSchoolByCity(city);
    	} else {
    		return schoolRepository.findSchoolByNeighbourhoodAndCity(neighbourhood, city);
    	}
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public School findSchoolByCode(@RequestParam(value="schoolCode", required = false) String schoolCode) {
    	return schoolRepository.findSchoolByCode(schoolCode);
    }

}
