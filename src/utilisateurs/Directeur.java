package utilisateurs;

public class Directeur extends Utilisateur {
	private int directeurId;
	
	public Directeur(String prenom, String nom, String email, String numTel, String agence, int directeurId) {
		super(prenom, nom, email, numTel, agence);
		this.directeurId = directeurId;
	}
	
	public int getDirecteurId() {
		return this.directeurId;
	}
}
