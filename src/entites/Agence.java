package entites;

@Deprecated
public class Agence {
	private int agenceId;
	private int directeurAgenceId;
	private String nomAgence;
	private Adresse adresseAgence;
	private int numTelAgence;
	private String emailAgence;
	private int siretAgence;

	public Agence(int agenceId, int directeurAgenceId, String nomAgence, Adresse adresseAgence, int numTelAgence,
			String emailAgence, int siretAgence) {
		this.agenceId = agenceId;
		this.directeurAgenceId = directeurAgenceId;
		this.nomAgence = nomAgence;
		this.adresseAgence = adresseAgence;
		this.numTelAgence = numTelAgence;
		this.emailAgence = emailAgence;
		this.siretAgence = siretAgence;
	}

	public int getDirecteurAgenceId() {
		return directeurAgenceId;
	}

	public void setDirecteurAgenceId(int directeurAgenceId) {
		this.directeurAgenceId = directeurAgenceId;
	}

	public Adresse getAdresseAgence() {
		return adresseAgence;
	}

	public void setAdresseAgence(Adresse adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public int getNumTelAgence() {
		return numTelAgence;
	}

	public void setNumTelAgence(int numTelAgence) {
		this.numTelAgence = numTelAgence;
	}

	public int getSiretAgence() {
		return siretAgence;
	}

	public void setSiretAgence(int siretAgence) {
		this.siretAgence = siretAgence;
	}

	public String getEmailAgence() {
		return emailAgence;
	}

	public void setEmailAgence(String emailAgence) {
		this.emailAgence = emailAgence;
	}

	public int getAgenceId() {
		return agenceId;
	}
}
