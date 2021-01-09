package employe;

public class Directeur {
	private int directeurId;
	private int agenceId;
	private String prenomDirecteur;
	private String nomDirecteur;
	private String emailDirecteur;
	private int numTelDirecteur;
	
	public Directeur(int directeurId, int agenceId, String prenomDirecteur, String nomDirecteur,
					 String emailDirecteur, int numTelDirecteur) {
		this.agenceId = agenceId;
		this.prenomDirecteur = prenomDirecteur;
		this.nomDirecteur = nomDirecteur;
		this.emailDirecteur = emailDirecteur;
		this.numTelDirecteur = numTelDirecteur;
	}
	
	public int getDirecteurId(int id) {
		return directeurId;
	}

	public int getAgenceId() {
		return agenceId;
	}

	public void setAgenceId(int agenceId) {
		this.agenceId = agenceId;
	}

	public String getPrenomDirecteur() {
		return prenomDirecteur;
	}

	public void setPrenomDirecteur(String prenomDirecteur) {
		this.prenomDirecteur = prenomDirecteur;
	}

	public String getNomDirecteur() {
		return nomDirecteur;
	}

	public void setNomDirecteur(String nomDirecteur) {
		this.nomDirecteur = nomDirecteur;
	}

	public String getEmailDirecteur() {
		return emailDirecteur;
	}

	public void setEmailDirecteur(String emailDirecteur) {
		this.emailDirecteur = emailDirecteur;
	}

	public int getNumTelDirecteur() {
		return numTelDirecteur;
	}

	public void setNumTelDirecteur(int numTelDirecteur) {
		this.numTelDirecteur = numTelDirecteur;
	}
	
}
