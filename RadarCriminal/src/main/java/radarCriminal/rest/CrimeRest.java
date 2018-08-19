package radarCriminal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radarCriminal.repository.CrimeRepository;

@RestController
@RequestMapping("/crimes")
public class CrimeRest {

	@Autowired
	private CrimeRepository crimeRepository;
	
	
}
