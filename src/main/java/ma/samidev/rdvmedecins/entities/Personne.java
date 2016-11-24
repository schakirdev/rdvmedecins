package ma.samidev.rdvmedecins.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 5)
	private String titre;
	@Column(length = 20)
	private String prenom;
	@Column(length = 20)
	private String nom;	
	
	public Personne() {
	}

	public Personne(String titre, String prenom, String nom) {
		this.titre = titre;
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return String.format("Personne[%d, %d, %s, %s, %s]", id, version, titre, nom, prenom);
	}

}
