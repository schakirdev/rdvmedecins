package ma.samidev.rdvmedecins.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ma.samidev.rdvmedecins.entities.Client;
import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.Medecin;
import ma.samidev.rdvmedecins.entities.RendezVous;
import ma.samidev.rdvmedecins.model.AgendaMedecinJour;
import ma.samidev.rdvmedecins.model.CreneauMedecinJour;
import ma.samidev.rdvmedecins.repositories.ClientRepository;
import ma.samidev.rdvmedecins.repositories.CreneauRepository;
import ma.samidev.rdvmedecins.repositories.MedecinRepository;
import ma.samidev.rdvmedecins.repositories.RendezVousRepository;

@Service
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
	public List<Creneau> getAllCreneauxParMedecin(Long idMedecin) {
		return Lists.newArrayList(creneauRepository.findAll());
	}

	@Override
	public List<RendezVous> getRendezVousJourMedecin(Long idMedecin, Date jour) {
		return Lists.newArrayList(rendezVousRepository.getRendezVousJourMedecin(idMedecin, jour));
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findOne(id);
	}

	@Override
	public Medecin getMedecinById(Long id) {
		return medecinRepository.findOne(id);
	}

	@Override
	public RendezVous getRendezVousById(Long id) {
		return rendezVousRepository.findOne(id);
	}

	@Override
	public Creneau getCreneauById(Long id) {
		return creneauRepository.findOne(id);
	}

	@Override
	@Transactional
	public RendezVous ajouterRendezVous(Date jour, Creneau creneau, Client client) {
		RendezVous rv = new RendezVous(jour);
		rv.setClient(client);
		rv.setCreneau(creneau);
		return rendezVousRepository.save(rv);
	}

	@Override
	public void supprimerRendezVous(RendezVous rv) {
		rendezVousRepository.delete(rv);
	}

	@Override
	public AgendaMedecinJour getAgendaMedecinJour(Long idMedecin, Date jour) {
		List<Creneau> creneauxHoraires = getAllCreneauxParMedecin(idMedecin);
		List<RendezVous> rendezVous = getRendezVousJourMedecin(idMedecin, jour);
		AgendaMedecinJour agenda = new AgendaMedecinJour();
		agenda.setJour(jour);
		agenda.setMedecin(getMedecinById(idMedecin));
		CreneauMedecinJour[] creneauxMedecinJour = new CreneauMedecinJour[creneauxHoraires.size()];
		for (int i = 0; i < creneauxHoraires.size(); i++) {
			Creneau creneauHoraire = creneauxHoraires.get(i);
			CreneauMedecinJour creneauMedecinJour = new CreneauMedecinJour();
			creneauMedecinJour.setCreneau(creneauHoraire);
			for (RendezVous rv : rendezVous) {
				if (rv.getCreneau().getId() == creneauHoraire.getId()) {
					creneauMedecinJour.setRendezVous(rv);
					break;
				}
			}
			creneauxMedecinJour[i] = creneauMedecinJour;
		}
		agenda.setCreneauxMedecinJour(creneauxMedecinJour);
		return agenda;
	}

}
