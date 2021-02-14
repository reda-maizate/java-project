package entites;

@Deprecated
public class Entreprise {
	private int entrepriseId;
	private int siretEntreprise;
	private String nomEntreprise;

	public Entreprise(int entrepriseId, int siretEntreprise, String nomEntreprise) {
		this.entrepriseId = entrepriseId;
		this.siretEntreprise = siretEntreprise;
		this.nomEntreprise = nomEntreprise;
	}

	public int getSiretEntreprise() {
		return siretEntreprise;
	}

	public void setSiretEntreprise(int siretEntreprise) {
		this.siretEntreprise = siretEntreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public int getEntrepriseId() {
		return entrepriseId;
	}
}
