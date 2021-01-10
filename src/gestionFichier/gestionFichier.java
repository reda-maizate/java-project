package gestionFichier;
import java.io.File;
import java.io.IOException;


public class gestionFichier {
	public String nomFichier = "identifiants.txt";
	
	public void creerFichier() throws IOException {
	    File fichier = new File(nomFichier);
		if (fichier.createNewFile()) {
			System.out.println("Fichier créé : " + fichier.getName());
		} else {
			/*System.out.println("Fichier déjà existant");*/
		}
	}
}