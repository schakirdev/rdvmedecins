package ma.samidev.rdvmedecins.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ma.samidev.rdvmedecins.entities.Creneau;

public interface CreneauRepository extends CrudRepository<Creneau, Long> {
	
	@Query("SELECT c FROM Creneau c WHERE c.medecin.id = :idMedecin")
	Iterable<Creneau> getAllCreneauxParMedecin(@Param("idMedecin") Long idMedecin);

}
