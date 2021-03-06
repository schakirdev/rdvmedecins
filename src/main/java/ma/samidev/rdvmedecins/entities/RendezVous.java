package ma.samidev.rdvmedecins.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rv")
public class RendezVous extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date jour;
	@ManyToOne
	@JoinColumn(name = "id_creneau")
	private Creneau creneau;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	public RendezVous() {
	}

	public RendezVous(Date jour) {
		this.jour = jour;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return String.format("RendezVous[%d, %d, %s, %d, %d]", id, version, jour, client.id, creneau.id);
	}

}
