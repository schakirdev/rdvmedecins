package ma.samidev.rdvmedecins.metier;

import java.util.Date;
import java.util.List;

import ma.samidev.rdvmedecins.entities.Client;
import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.Medecin;
import ma.samidev.rdvmedecins.entities.RendezVous;
import ma.samidev.rdvmedecins.model.AgendaMedecinJour;

public interface IMetier {

	public List<Client> getAllClients();

	public List<Medecin> getAllMedecins();

	public List<Creneau> getAllCreneauxParMedecin(Long idMedecin);
	
	public List<RendezVous> getRendezVousJourMedecin(Long idMedecin, Date jour);
	
	public Client getClientById(Long id);
	
	public Medecin getMedecinById(Long id);
	
	public RendezVous getRendezVousById(Long id);
	
	public Creneau getCreneauById(Long id);
	
	public RendezVous ajouterRendezVous(Date jour, Creneau creneau, Client client);
	
	public void supprimerRendezVous(RendezVous rv);
	
	public AgendaMedecinJour getAgendaMedecinJour(Long idMedecin, Date jour);

}
