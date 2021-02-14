package utilisateurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.FichierNonAutoriseException;
import exceptions.UtilisateurNonTrouveException;

public class UtilisateurListe extends ArrayList<Utilisateur> {
	private ArrayList<Utilisateur> toutUtilisateur = new ArrayList<Utilisateur>();
	
	public UtilisateurListe() {
		// TODO Auto-generated constructor stub
	}
	
	public void readFrom(File file) throws FileNotFoundException, FichierNonAutoriseException {
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			String[] ligne = scanner.nextLine().split(",");
			if (file.getName().equals("agents.txt")) {
				Agent ag = new Agent();
				ag.from(ligne);
				this.addToToutUtilisateur(ag);
			} else if (file.getName().equals("directeurs.txt")) {
				Directeur dir = new Directeur();
				dir.from(ligne);
				this.addToToutUtilisateur(dir);
			} else {
				throw new FichierNonAutoriseException();
			}
		}
		scanner.close();
	}

	public void save(File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		for (Utilisateur user : this) {
			fileWriter.write(user.toString());
		}
		fileWriter.close();
	}

	public Utilisateur getByEmail(String email) throws UtilisateurNonTrouveException {
		for (Utilisateur user : this) {
			if (user.getEmail().equalsIgnoreCase(email))
				return user;
		}

		throw new UtilisateurNonTrouveException();
	}

	public ArrayList<Utilisateur> getToutUtilisateur() {
		return toutUtilisateur;
	}

	public void addToToutUtilisateur(Utilisateur utilisateur) {
		this.toutUtilisateur.add(utilisateur);
	}
}
