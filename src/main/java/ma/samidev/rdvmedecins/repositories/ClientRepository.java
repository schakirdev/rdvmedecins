package ma.samidev.rdvmedecins.repositories;

import org.springframework.data.repository.CrudRepository;

import ma.samidev.rdvmedecins.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
