package utilisateurs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println("test1");
		FileReader lecteurFichier = new FileReader("directeurs.txt");
		System.out.println("test2");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		System.out.println("test3");
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[5];
				if (identifiantsA.equals(identifiantsB)) {
					System.out.println("idA: "+identifiantsA+ " / idB: "+identifiantsB);
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
	public List<Object> recupererInfos(String mailB) throws IOException {
		List<Object> infos = new ArrayList<Object>();
		FileReader lecteurFichier = new FileReader("directeurs.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		System.out.println("test1");
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String mailA = mots[5];
				if (mailA.equals(mailB)) {
					for (String mot: mots) {
						infos.add(mot);
					}
				}
			}
		} finally {
			lecteur.close();	
		}
		return infos;
	}
}
