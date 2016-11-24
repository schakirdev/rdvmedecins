package ma.samidev.rdvmedecins.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "creneaux")
public class Creneau extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private int heureDebut;
	private int heureFin;
	private int minDebut;
	private int minFin;
	@ManyToOne
	@JoinColumn(name = "id_medecin", insertable = false, updatable = false)
	private Medecin medecin;

	public Creneau() {
	}

	public Creneau(int heureDebut, int heureFin, int minDebut, int minFin) {
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.minDebut = minDebut;
		this.minFin = minFin;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public int getMinDebut() {
		return minDebut;
	}

	public void setMinDebut(int minDebut) {
		this.minDebut = minDebut;
	}

	public int getMinFin() {
		return minFin;
	}

	public void setMinFin(int minFin) {
		this.minFin = minFin;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public String toString() {
		return String.format("Créneau[%d, %d, %d:%d, %d:%d, %d]", id, version, heureDebut, minDebut, heureFin,
				minFin, medecin.id);
	}

}
