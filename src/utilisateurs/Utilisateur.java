package utilisateurs;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Utilisateur {

	private String prenom;
	private String nom;
	private String email;
	private String numTel;
	private String agence;

	public Utilisateur() {
	}

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
	
	public boolean EmailEstIlPresentDansFichier(String nomFichierAVerifier, String email, int PositionElementAComparer) throws IOException {
		FileReader lecteurFichier = new FileReader(nomFichierAVerifier);
		BufferedReader lecteur = new BufferedReader(lecteurFichier);

		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantA;
 				if (PositionElementAComparer == -1) {
					identifiantA = ligne;
				} else {
					identifiantA = mots[PositionElementAComparer];
				}
				if (identifiantA.equals(email)) {
					return true;
				}
			}
		} finally {
			lecteur.close();
		}
		return false;
	}

	public boolean estDejaEnregistreConnexion(String email) throws IOException {
		String identifiantB = email;
		
		return EmailEstIlPresentDansFichier("identifiants.txt", identifiantB, 0);
	}

	public boolean verificationConnexion(String identifiant, String motDePasse) throws IOException {
		String identifiantB = identifiant + "," + motDePasse;
		
		return EmailEstIlPresentDansFichier("identifiants.txt", identifiantB, -1);
	}
	
	public boolean estDejaEnregistreAgent(String email) throws IOException {
		String identifiantB = email;
		
		return EmailEstIlPresentDansFichier("agents.txt", identifiantB, 6);
	}

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
