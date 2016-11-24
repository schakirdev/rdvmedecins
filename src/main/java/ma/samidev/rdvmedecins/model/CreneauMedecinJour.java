package ma.samidev.rdvmedecins.model;

import ma.samidev.rdvmedecins.entities.Creneau;
import ma.samidev.rdvmedecins.entities.RendezVous;

public class CreneauMedecinJour {

	private RendezVous rendezVous;
	private Creneau creneau;
	
	public CreneauMedecinJour() {
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	
	@Override
	public String toString() {
		return String.format("[%s %s]", creneau, rendezVous);
	}

}
