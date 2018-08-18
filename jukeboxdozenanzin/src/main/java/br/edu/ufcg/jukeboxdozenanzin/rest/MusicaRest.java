package br.edu.ufcg.jukeboxdozenanzin.rest;

import br.edu.ufcg.jukeboxdozenanzin.entity.School;
import br.edu.ufcg.jukeboxdozenanzin.entity.Musica;
import br.edu.ufcg.jukeboxdozenanzin.repository.SchoolRepository;
import br.edu.ufcg.jukeboxdozenanzin.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
