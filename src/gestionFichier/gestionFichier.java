package gestionFichier;

import java.io.File;
import java.io.IOException;

public class gestionFichier {
	public String FichierConnexion = "identifiants.txt";
	public String FichierDirecteur = "directeurs.txt";
	public String FichierAgent = "agents.txt";

	public gestionFichier() {
	}

	public void creerFichier(String NomFichier) throws IOException {
		File fichier = new File(FichierConnexion);
		if (fichier.createNewFile()) {
			System.out.println("Fichier créé : " + fichier.getName());
		} else {
		}
	}
}