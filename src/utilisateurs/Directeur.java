package utilisateurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entites.Mandat;

public class Directeur extends Utilisateur {
	private int directeurId;
	
	public Directeur() {}
	
	public Directeur(String prenom, String nom, String email, String numTel, String agence, int directeurId) {
		super(prenom, nom, email, numTel, agence);
		this.directeurId = directeurId;
	}
	
	public int getDirecteurId() {
		return this.directeurId;
	}
	
	public boolean comparerDirecteurs(String identifiant) throws IOException {
		String identifiantsB = identifiant;
		FileReader lecteurFichier = new FileReader("directeurs.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[5];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public Directeur from(String[] s) {
		String strDirecteurId = s[0].strip();
		String prenom = s[1].strip();
		String nom = s[2].strip();
		String numTel = s[3].strip();
		String agence = s[4].strip();
		String mail = s[5].strip();
			
		int directeurId = Integer.parseInt(strDirecteurId);
		Directeur dir = new Directeur(prenom, nom, mail, numTel, agence, directeurId);
		//System.out.println("0: ["+dir.getDirecteurId()+","+dir.getPrenom()+","+dir.getNom()+","+dir.getNumTel()+","+dir.getAgence()+","+dir.getEmail()+"]");
		return dir;
	}
		
	public Directeur recupererInfos(String mailB) throws IOException {
		// TODO : Retourner un directeur 
		Directeur dir = new Directeur();
		Directeur dirActuel;
		FileReader lecteurFichier = new FileReader("directeurs.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
				
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String mailA = mots[5];
				if (mailA.equals(mailB)) {
					dirActuel = dir.from(mots);
					//System.out.println("1: ["+dirActuel.getDirecteurId()+","+dirActuel.getPrenom()+","+dirActuel.getNom()+","+dirActuel.getNumTel()+","+dirActuel.getAgence()+","+dirActuel.getEmail()+"]");
					return dirActuel;
				}
			}
		} finally {
			lecteur.close();	
		}
		return dir;
	}
	
	//public Mandat modifierMandat(int idMandat) {
		//Mandat mand = new Mandat();
		//return mand;
	//}
	
	public void ajouterAgent(Agent ag, String identifiantsConnexion, Scanner scan) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiantsAgent = ag.getAgentId() + "," + ag.getDeptAgent() + "," + ag.getPrenom() + "," + ag.getNom() + "," + ag.getNumTel() + "," + ag.getAgence() + "," + ag.getEmail();
		
		String nomFichierAgent = "agents.txt";
		String nomFichierConnexion = "identifiants.txt";
				
		FileWriter fichierAgent = new FileWriter(nomFichierAgent, true);
		FileWriter fichierConnexion = new FileWriter(nomFichierConnexion, true);
		
		if (!estDejaEnregistreAgent(ag.getEmail()) && !estDejaEnregistreConnexion(ag.getEmail())) {
			try {
				fichierAgent.append(sauterLigne + identifiantsAgent);
				System.out.println("LOG: Utilisateur enregistré dans le fichier Agent!");
				fichierConnexion.append(sauterLigne + identifiantsConnexion);
				System.out.println("LOG: Utilisateur enregistré dans le fichier Connexion!");
			} finally {
				fichierAgent.close();
				fichierConnexion.close();
			} 
		} else {
			System.out.println("LOG: Utilisateur "+ ag.getEmail() + " déjà enregistré dans le fichier!");
		}
	}
	
	public Agent recupererInfosNouveauAgent(Scanner scan, String nomFichierAgent) throws IOException {
		int id = prochainId(nomFichierAgent);
		
		System.out.println("Entrez le code postal departemental de l'agent que vous souhaitez ajouter :");
		int deptAgent = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Entrez le prénom de l'agent que vous souhaitez ajouter :");
		String prenom = scan.nextLine();
		
		System.out.println("Entrez le nom de l'agent que vous souhaitez ajouter :");
		String nom = scan.nextLine();
		
		System.out.println("Entrez le numéro de téléphone de l'agent que vous souhaitez ajouter :");
		String numTel = scan.nextLine();
		
		System.out.println("Entrez la ville de l'agence où sera l'agent que vous souhaitez ajouter :");
		String agence = scan.nextLine();
		
		System.out.println("Entrez l'adresse mail de l'agent que vous souhaitez ajouter :");
		String email = scan.nextLine();
		
		Agent ag = new Agent(prenom, nom, email, numTel, agence, id, deptAgent);
		
		return ag;
	}
	
	public String recupererInfosNouveauAgentConnexion(Agent ag, Scanner scan, String nomFichierConnexion) throws IOException {
		System.out.println("Entrez le mot de passe de l'agent que vous souhaitez ajouter :");
		String motDePasse = scan.nextLine();
		
		String identifiantsConnexion = ag.getEmail()+","+motDePasse;
		return identifiantsConnexion;
	}
}
