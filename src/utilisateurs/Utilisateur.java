package utilisateurs;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Utilisateur {

	private String prenom;
	private String nom;
	private String email;
	private String numTel;
	private String agence;
	
	public Utilisateur() {}
	
	public Utilisateur(String prenom, String nom, String email, String numTel, String agence) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.numTel = numTel;
		this.agence = agence;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getAgence() {
		return this.agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}
	
	public boolean comparerUtilisateurConnexion(String identifiant, String motDePasse, String nomFichier) throws IOException {
		String identifiantsB = identifiant + "," + motDePasse;
		FileReader lecteurFichier = new FileReader(nomFichier);
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[0] + "," + mots[1];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public boolean comparerUtilisateur(String identifiant, String motDePasse, String nomFichier) throws IOException {
		String identifiantsB = identifiant + "," + motDePasse;
		FileReader lecteurFichier = new FileReader(nomFichier);
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[0] + "," + mots[1];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public void ajouterUtilisateurConnexion(String identifiant, String motDePasse, String role, String nomFichier) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiants = identifiant + "," + motDePasse + "," + role;
		FileWriter fichier = new FileWriter(nomFichier, true);
		
		if (!comparerUtilisateurConnexion(identifiant, motDePasse, nomFichier)) {
			try {
				fichier.append(identifiants + sauterLigne);
				System.out.println("Utilisateur enregistré dans le fichier !");
			} finally {
				fichier.close();
			} 
		} else {
			System.out.println("Utilisateur "+ identifiant + " déjà enregistré dans le fichier !");
		}
	}
	
	public void ajouterUtilisateur(String identifiant, String motDePasse, String role, String nomFichier) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiants = identifiant + "," + motDePasse + "," + role;
		FileWriter fichier = new FileWriter(nomFichier, true);
		
		if (!comparerUtilisateur(identifiant, motDePasse, nomFichier)) {
			try {
				fichier.append(identifiants + sauterLigne);
				System.out.println("Utilisateur enregistré dans le fichier !");
			} finally {
				fichier.close();
			} 
		} else {
			System.out.println("Utilisateur "+ identifiant + " déjà enregistré dans le fichier !");
		}
	}
}
