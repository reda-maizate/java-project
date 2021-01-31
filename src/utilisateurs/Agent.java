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
	}

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
		// TODO : Retourner un agent
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
					// System.out.println("1:
					// ["+agActuel.getAgentId()+","+agActuel.getDeptAgent()+","+agActuel.getPrenom()+","+agActuel.getNom()+","+agActuel.getNumTel()+","+agActuel.getAgence()+","+agActuel.getEmail()+"]");
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
							+ " (" + descriptionStatutMandat(manActuel.getStatut()) + ")");
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
							+ descriptionStatutMandat(nouvStatut) + ")");
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

	private void modifierStatutMandatFichier(Mandat man) {
		String sauterLigne = System.getProperty("line.separator");
		int mandatIdA = man.getMandatId();

		File entree = new File("mandats.txt");
		File sortie = new File("temp.txt");

		FileReader lecteurFichier = null;
		try {
			lecteurFichier = new FileReader(entree);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileWriter ecritureFichier = null;
		try {
			ecritureFichier = new FileWriter(sortie);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// A corriger en dessous !
			try {
				lecteur.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ecriture.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Path sourceEntree = Paths.get(entree.getAbsolutePath());
			try {
				Files.move(sourceEntree, sourceEntree.resolveSibling("poubelle.txt"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Path sourceSortie = Paths.get(sortie.getAbsolutePath());
			try {
				Files.move(sourceSortie, sourceSortie.resolveSibling("mandats.txt"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (entree.delete())
				System.out.println("Deleted!");
			else
				System.out.println("Not deleted bro!");

			/*
			 * boolean entreeChanged = entree.renameTo(new File("poubelle")); boolean
			 * sortieChanged = sortie.renameTo(new File("mandats.txt")); boolean entreeDel =
			 * entree.delete();
			 * 
			 * if (entreeChanged) System.out.println("Success creation poubelle"); else
			 * System.out.println("Failure creation poubelle");
			 * 
			 * if (sortieChanged) System.out.println("Success modification mandats"); else
			 * System.out.println("Failure modififcation mandatd");
			 * 
			 * if (entreeDel) System.out.println("success poubelle deleted"); else
			 * System.out.println("Failure poubelle deleted");
			 */
		}
	}

	public String descriptionStatutMandat(int statut) {

		String sortie;

		switch (statut) {
		case 0:
			sortie = "En attente de construction";
			break;
		case 1:
			sortie = "En construction";
			break;
		case 2:
			sortie = "Construction terminée";
			break;
		default:
			sortie = "Statut incorrecte";
			break;
		}

		return sortie;
	}
}
