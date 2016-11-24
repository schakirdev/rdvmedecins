package ma.samidev.rdvmedecins.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Personne {

	private static final long serialVersionUID = 1L;
	
	public Client() {
	}

	public Client(String titre, String prenom, String nom) {
		super(titre, prenom, nom);
	}

	@Override
	public String toString() {
		return String.format("Client[%s]", super.toString());
	}

}
