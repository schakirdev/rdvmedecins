package ma.samidev.rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;

import ma.samidev.rdvmedecins.entities.Medecin;

public interface MedecinRepository extends CrudRepository<Medecin, Long> {

}
