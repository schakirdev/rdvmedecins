package ma.samidev.rdvmedecins.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import ma.samidev.rdvmedecins.entities.Client;
import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.Medecin;
import ma.samidev.rdvmedecins.entities.RendezVous;
import ma.samidev.rdvmedecins.repositories.ClientRepository;
import ma.samidev.rdvmedecins.repositories.CreneauRepository;
import ma.samidev.rdvmedecins.repositories.MedecinRepository;
import ma.samidev.rdvmedecins.repositories.RendezVousRepository;

public class Metier implements IMetier {

	@Autowired
	private MedecinRepository medecinRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CreneauRepository creneauRepository;
	@Autowired
	private RendezVousRepository rendezVousRepository;

	@Override
	public List<Client> getAllClients() {
		return Lists.newArrayList(clientRepository.findAll());
	}

	@Override
	public List<Medecin> getAllMedecins() {
		return Lists.newArrayList(medecinRepository.findAll());
	}

	@Override
	public List<Creneau> getAllCreneauxParMedecin(long idMedecin) {
		return Lists.newArrayList(creneauRepository.findAll());
	}

	@Override
	public List<RendezVous> getRendezVousJourMedecin(long idMedecin, Date jour) {
		return Lists.newArrayList(rendezVousRepository.getRendezVousJourMedecin(idMedecin, jour));
	}

	@Override
	public Client getClientById(long id) {
		return clientRepository.findOne(id);
	}

	@Override
	public Medecin getMedecinById(long id) {
		return medecinRepository.findOne(id);
	}

	@Override
	public RendezVous getRendezVousById(long id) {
		return rendezVousRepository.findOne(id);
	}

	@Override
	public Creneau getCreneauById(long id) {
		return creneauRepository.findOne(id);
	}

	@Override
	public RendezVous ajouterRendezVous(Date jour, Creneau créneau, Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerRendezVous(RendezVous rv) {
		// TODO Auto-generated method stub

	}

	@Override
	public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour) {
		// TODO Auto-generated method stub
		return null;
	}

}
