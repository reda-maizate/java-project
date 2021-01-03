public class Bien {
	private int bienId;
	private int mandatId;
	private String typeBien;
	private Adresse adresseId;
	private String descriptionBien;
	private int prixBien;
	private int surfaceBien;
	private CaracteristiquesInt caracteristiquesInt;
	private CaracteristiquesExt caracteristiquesExt;
	private Entreprise entreprise;
	private String statut;
	
	public Bien(int bienId, int mandatId, String typeBien, Adresse adresseId, String descriptionBien, int prixBien, int surfaceBien, CaracteristiquesInt caracteristiquesInt, CaracteristiquesExt caracteristiquesExt, Entreprise entreprise, String statut) {
		this.bienId = bienId;
		this.mandatId = mandatId;
		this.typeBien = typeBien;
		this.adresseId = adresseId;
		this.descriptionBien = descriptionBien;
		this.prixBien = prixBien;
		this.surfaceBien = surfaceBien;
		this.caracteristiquesInt = caracteristiquesInt;
		this.caracteristiquesExt = caracteristiquesExt;
		this.entreprise = entreprise;
		this.statut = statut;
	}

	
	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public int getBienId() {
		return bienId;
	}

	public int getMandatId() {
		return mandatId;
	}

	public void setMandatId(int mandatId) {
		this.mandatId = mandatId;
	}

	public Adresse getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(Adresse adresseId) {
		this.adresseId = adresseId;
	}

	public String getDescriptionBien() {
		return descriptionBien;
	}

	public void setDescriptionBien(String descriptionBien) {
		this.descriptionBien = descriptionBien;
	}

	public int getPrixBien() {
		return prixBien;
	}

	public void setPrixBien(int prixBien) {
		this.prixBien = prixBien;
	}

	public int getSurfaceBien() {
		return surfaceBien;
	}

	public void setSurfaceBien(int surfaceBien) {
		this.surfaceBien = surfaceBien;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	public CaracteristiquesInt getCaracteristiquesInt() {
		return caracteristiquesInt;
	}


	public void setCaracteristiquesInt(CaracteristiquesInt caracteristiquesInt) {
		this.caracteristiquesInt = caracteristiquesInt;
	}


	public CaracteristiquesExt getCaracteristiquesExt() {
		return caracteristiquesExt;
	}


	public void setCaracteristiquesExt(CaracteristiquesExt caracteristiquesExt) {
		this.caracteristiquesExt = caracteristiquesExt;
	}
	
}