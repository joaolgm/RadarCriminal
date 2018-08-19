package radarCriminal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import radarCriminal.entity.Crime;

public interface CrimeRepository extends CrudRepository<Crime, String>{

	List<Crime> findCrimeByNeighbourhood(String neighbourhood);

}
