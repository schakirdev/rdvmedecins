package ma.samidev.rdvmedecins.metier;

import java.util.Date;
import java.util.List;

import ma.samidev.rdvmedecins.entities.Client;
import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.Medecin;
import ma.samidev.rdvmedecins.entities.RendezVous;

public interface IMetier {

	public List<Client> getAllClients();

	public List<Medecin> getAllMedecins();

	public List<Creneau> getAllCreneauxParMedecin(long idMedecin);
	
	public List<RendezVous> getRendezVousJourMedecin(long idMedecin, Date jour);
	
	public Client getClientById(long id);
	
	public Medecin getMedecinById(long id);
	
	public RendezVous getRendezVousById(long id);
	
	public Creneau getCreneauById(long id);
	
	public RendezVous ajouterRendezVous(Date jour, Creneau créneau, Client client);
	
	public void supprimerRendezVous(RendezVous rv);
	
	public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour);

}
