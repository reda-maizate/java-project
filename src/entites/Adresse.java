package entites;

public class Adresse {
	private int adresseId;
	private int numVoieAdresse;
	private String typeVoieAdresse;
	private String nomVoieAdresse;
	private String villeAdresse;
	private int codePostalAdresse;
	private String paysAdresse;
	
	public Adresse(int adresseId, int numVoieAdresse, String typeVoieAdresse, String nomVoieAdresse, String villeAdresse, int codePostalAdresse, String paysAdresse) {
		this.adresseId = adresseId;
		this.numVoieAdresse = numVoieAdresse;
		this.typeVoieAdresse = typeVoieAdresse;
		this.nomVoieAdresse = nomVoieAdresse;
		this.villeAdresse = villeAdresse;
		this.codePostalAdresse = codePostalAdresse;
		this.paysAdresse = paysAdresse;
	}

	public int getNumVoieAdresse() {
		return numVoieAdresse;
	}
	
	public void setNumVoieAdresse(int numVoieAdresse) {
		this.numVoieAdresse = numVoieAdresse;
	}

	public int getAdresseId() {
		return adresseId;
	}

	public String getVilleAdresse() {
		return villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public String getTypeVoieAdresse() {
		return typeVoieAdresse;
	}

	public void setTypeVoieAdresse(String typeVoieAdresse) {
		this.typeVoieAdresse = typeVoieAdresse;
	}

	public String getNomVoieAdresse() {
		return nomVoieAdresse;
	}

	public void setNomVoieAdresse(String nomVoieAdresse) {
		this.nomVoieAdresse = nomVoieAdresse;
	}

	public String getPaysAdresse() {
		return paysAdresse;
	}

	public void setPaysAdresse(String paysAdresse) {
		this.paysAdresse = paysAdresse;
	}

	public int getCodePostalAdresse() {
		return codePostalAdresse;
	}

	public void setCodePostalAdresse(int codePostalAdresse) {
		this.codePostalAdresse = codePostalAdresse;
	}
}