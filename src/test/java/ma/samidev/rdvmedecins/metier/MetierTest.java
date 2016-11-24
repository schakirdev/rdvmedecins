package ma.samidev.rdvmedecins.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ma.samidev.rdvmedecins.entities.Client;
import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.Medecin;
import ma.samidev.rdvmedecins.entities.RendezVous;
import ma.samidev.rdvmedecins.model.AgendaMedecinJour;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MetierTest {

	@Autowired
	private IMetier metier;

	@Test
	public void test1() {
		List<Client> clients = metier.getAllClients();
		display("Liste des clients :", clients);
		List<Medecin> medecins = metier.getAllMedecins();
		display("Liste des médecins :", medecins);
		Medecin médecin = medecins.get(0);
		List<Creneau> creneaux = metier.getAllCreneauxParMedecin(médecin.getId());
		display(String.format("Liste des créneaux du médecin %s", médecin), creneaux);
		Date jour = new Date();
		display(String.format("Liste des rendez-vous du médecin %s, le [%s]", médecin, jour),
				metier.getRendezVousJourMedecin(médecin.getId(), jour));
		RendezVous rv = null;
		Creneau créneau = creneaux.get(2);
		Client client = clients.get(0);
		System.out.println(
				String.format("Ajout d'un rendez-vous le [%s] dans le créneau %s pour le client %s", jour, créneau, client));
		rv = metier.ajouterRendezVous(jour, créneau, client);
		RendezVous rv2 = metier.getRendezVousById(rv.getId());
		assertEquals(rv, rv2);
		display(String.format("Liste des rendez-vous du médecin %s, le [%s]", médecin, jour),
				metier.getRendezVousJourMedecin(médecin.getId(), jour));
		System.out.println(
				String.format("Ajout d'un rendez-vous le [%s] dans le créneau %s pour le client %s", jour, créneau, client));
		Boolean erreur = false;
		try {
			rv = metier.ajouterRendezVous(jour, créneau, client);
			System.out.println("Rendez-vous ajouté");
		} catch (Exception ex) {
			Throwable th = ex;
			while (th != null) {
				System.out.println(ex.getMessage());
				th = th.getCause();
			}
			erreur = true;
		}
		assertTrue(erreur);
		display(String.format("Liste des rendez-vous du médecin %s, le [%s]", médecin, jour),
				metier.getRendezVousJourMedecin(médecin.getId(), jour));
		AgendaMedecinJour agenda = metier.getAgendaMedecinJour(médecin.getId(), jour);
		System.out.println(agenda);
		assertEquals(rv, agenda.getCreneauxMedecinJour()[2].getRendezVous());
		System.out.println("Suppression du rendez-vous ajouté");
		metier.supprimerRendezVous(rv);
		rv2 = metier.getRendezVousById(rv.getId());
		assertNull(rv2);
		display(String.format("Liste des rendez-vous du médecin %s, le [%s]", médecin, jour),
				metier.getRendezVousJourMedecin(médecin.getId(), jour));

	}

	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}
	
}
