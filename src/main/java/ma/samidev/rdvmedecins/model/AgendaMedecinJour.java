package ma.samidev.rdvmedecins.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import ma.samidev.rdvmedecins.entities.Medecin;

public class AgendaMedecinJour {

	private Date jour;
	private Medecin medecin;
	private CreneauMedecinJour[] creneauxMedecinJour;

	public AgendaMedecinJour() {
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public CreneauMedecinJour[] getCreneauxMedecinJour() {
		return creneauxMedecinJour;
	}

	public void setCreneauxMedecinJour(CreneauMedecinJour[] creneauxMedecinJour) {
		this.creneauxMedecinJour = creneauxMedecinJour;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("");
		for (CreneauMedecinJour cr : creneauxMedecinJour) {
			stringBuilder.append(" ").append(cr.toString());
		}
		return String.format("Agenda[%s, %s, %s]", medecin, new SimpleDateFormat("dd/MM/yyyy").format(jour),
				stringBuilder.toString());
	}

}
