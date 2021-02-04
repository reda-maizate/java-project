package utilisateurs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entites.Mandat;

public class Agent extends Utilisateur {
	private int agentId;
	private int deptAgent;

	public Agent() {
	}

	public Agent(String prenom, String nom, String email, String numTel, String agence, int agentId, int deptAgent) {
		super(prenom, nom, email, numTel, agence);
		this.agentId = agentId;
		this.deptAgent = deptAgent;
	}

	public int getAgentId() {
		return agentId;
	}

	public int getDeptAgent() {
		return deptAgent;
	}

	public void setDeptAgent(int deptAgent) {
		this.deptAgent = deptAgent;
	}

	public boolean comparerAgents(String identifiant) throws IOException {
		String identifiantB = identifiant;
		
		return lireFichierComparer("agents.txt", identifiantB, 6);
	}
	
	/*	public boolean comparerAgents(String identifiant) throws IOException {
		String identifiantsB = identifiant;
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
	}*/

	public Agent from(String[] s) {
		String strAgentId = s[0].strip();
		String strDeptAgent = s[1].strip();
		String prenom = s[2].strip();
		String nom = s[3].strip();
		String numTel = s[4].strip();
		String agence = s[5].strip();
		String mail = s[6].strip();

		int agentId = Integer.parseInt(strAgentId);
		int deptAgent = Integer.parseInt(strDeptAgent);

		Agent ag = new Agent(prenom, nom, mail, numTel, agence, agentId, deptAgent);

		return ag;
	}

	public Agent recupererInfos(String mailB) throws IOException {
		Agent ag = new Agent();
		Agent agActuel;
		FileReader lecteurFichier = new FileReader("agents.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);

		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String mailA = mots[6];
				if (mailA.equals(mailB)) {
					agActuel = ag.from(mots);
					return agActuel;
				}
			}
		} finally {
			lecteur.close();
		}
		return ag;
	}

	public Mandat modifierStatutMandat(int idMandat, Scanner scan) throws IOException, ParseException {
		String identifiantB = String.valueOf(idMandat);
		FileReader lecteurFichier = new FileReader("mandats.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		Mandat man = new Mandat();
		Mandat manActuel;

		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantA = mots[0];
				if (identifiantA.equals(identifiantB)) {
					manActuel = man.from(mots);
					System.out.println("Le statut du mandat que vous avez selectionné est " + manActuel.getStatut()
							+ " (" + man.descriptionStatutMandat(manActuel.getStatut()) + ")");
					System.out.println();
					System.out.println("-- HELPER --");
					System.out.println("0: En attente de construction");
					System.out.println("1: En construction");
					System.out.println("2: Construction terminée");
					System.out.println("------------");
					System.out.println();
					System.out.println("Insérez le nouveau statut de ce mandat :");

					int nouvStatut = scan.nextInt();
					System.out.println("Le statut de ce mandat est désormais : " + nouvStatut + " ("
							+ man.descriptionStatutMandat(nouvStatut) + ")");
					manActuel.setStatut(nouvStatut);

					modifierStatutMandatFichier(manActuel);

					return manActuel;
				}
			}
		} finally {
			lecteur.close();
		}
		return man;
	}

	private void modifierStatutMandatFichier(Mandat man) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		int mandatIdA = man.getMandatId();

		File entree = new File("mandats.txt");
		File sortie = new File("temp.txt");

		FileReader lecteurFichier = new FileReader(entree);
		FileWriter ecritureFichier = new FileWriter(sortie);

		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		BufferedWriter ecriture = new BufferedWriter(ecritureFichier);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String permisConstruireDebut = sdf.format(man.getPermisConstruireDebut());
		String permisConstruireFin = sdf.format(man.getPermisConstruireFin());

		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				int mandatIdB = Integer.parseInt(mots[0]);
				if (mandatIdA == mandatIdB) {
					ecriture.write(man.getMandatId() + "," + man.getBienId() + "," + man.getAgenceId() + ","
							+ man.getAgentId() + "," + permisConstruireDebut + "," + permisConstruireFin + ","
							+ man.getNumPermis() + "," + man.getStatut() + sauterLigne);
					ecriture.flush();
				} else {
					ecriture.write(ligne + sauterLigne);
					ecriture.flush();
				}
			}
			
			lecteur.close();
			lecteurFichier.close();

			ecriture.close();
			ecritureFichier.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("En cours de construction !");
			entree.delete();
			sortie.renameTo(new File("mandats.txt"));
		}
	}

}
