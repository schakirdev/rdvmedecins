package ma.samidev.rdvmedecins.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medecins")
public class Medecin extends Personne {

	private static final long serialVersionUID = 1L;
	
	public Medecin() {	
	}

	public Medecin(String titre, String prenom, String nom) {
		super(titre, prenom, nom);
	}

	public String toString() {
		return String.format("Medecin[%s]", super.toString());
	}

}
