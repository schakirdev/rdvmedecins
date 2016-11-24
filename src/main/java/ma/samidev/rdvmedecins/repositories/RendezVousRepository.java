package ma.samidev.rdvmedecins.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ma.samidev.rdvmedecins.entities.RendezVous;

public interface RendezVousRepository extends CrudRepository<RendezVous, Long> {
	
	@Query("SELECT r FROM RendezVous r WHERE r.jour = :jour AND r.creneau.medecin.id = :idMedecin")
	Iterable<RendezVous> getRendezVousJourMedecin(@Param("idMedecin") Long idMedecin, @Param("jour") Date Jour);

}
