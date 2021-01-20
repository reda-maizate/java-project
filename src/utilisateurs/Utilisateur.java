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
	
	public boolean estDejaEnregistreConnexion(String email) throws IOException {
		String identifiantB = email;
		FileReader lecteurFichier = new FileReader("identifiants.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[0];
				if (identifiantsA.equals(identifiantB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public boolean verificationConnexion(String identifiant, String motDePasse) throws IOException {
		String identifiantsB = identifiant + "," + motDePasse;
		FileReader lecteurFichier = new FileReader("identifiants.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[0]+","+mots[1];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public boolean estDejaEnregistreAgent(String email) throws IOException {
		String identifiantsB = email;
		FileReader lecteurFichier = new FileReader("agents.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[6];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	/*
	public void ajouterUtilisateurConnexion(String identifiant, String motDePasse, String nomFichier) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiants = identifiant + "," + motDePasse;
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
	
	public void ajouterUtilisateur(String identifiant, String motDePasse, String nomFichier) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiants = identifiant + "," + motDePasse;
		FileWriter fichier = new FileWriter(nomFichier, true);
		
		if (!comparerUtilisateur(identifiant, nomFichier)) {
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
	*/
	
	public void afficherListeMandat(int id) throws IOException {
		String identifiantB = String.valueOf(id);
		FileReader lecteurFichier = new FileReader("mandats.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantA = mots[3];
				if (identifiantA.equals(identifiantB)) {
					System.out.println(ligne);
				}
			} 
		} finally {
			lecteur.close();	
		}
	}
	
	public int prochainId(String nomFichier) throws IOException {
		FileReader lecteurFichier = new FileReader(nomFichier);
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		int identifiantA = 0;
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				identifiantA = Integer.parseInt(mots[0]);
				identifiantA = identifiantA + 1;
			} 
		} finally {
			lecteur.close();	
		}
		return identifiantA;
	}
}
