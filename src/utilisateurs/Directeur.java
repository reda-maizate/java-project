package utilisateurs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entites.Mandat;

public class Directeur extends Utilisateur {
	private int directeurId;

	public Directeur() {
	}

	public Directeur(String prenom, String nom, String email, String numTel, String agence, int directeurId) {
		super(prenom, nom, email, numTel, agence);
		this.directeurId = directeurId;
	}

	public int getDirecteurId() {
		return this.directeurId;
	}
	
	public boolean comparerDirecteurs(String identifiant) throws IOException {
		String identifiantB = identifiant;
		
		return EmailEstIlPresentDansFichier("directeurs.txt", identifiantB, 5);
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
		
		return dir;
	}

	public Directeur recupererInfos(String mailB) throws IOException {
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
					return dirActuel;
				}
			}
		} finally {
			lecteur.close();
		}
		return dir;
	}

	public void ajouterAgent(Agent ag, String identifiantsConnexion, Scanner scan) throws IOException {
		String sauterLigne = System.getProperty("line.separator");
		String identifiantsAgent = ag.getAgentId() + "," + ag.getDeptAgent() + "," + ag.getPrenom() + "," + ag.getNom()
				+ "," + ag.getNumTel() + "," + ag.getAgence() + "," + ag.getEmail();

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
			System.out.println("LOG: Utilisateur " + ag.getEmail() + " déjà enregistré dans le fichier!");
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

	public String recupererInfosNouveauAgentConnexion(Agent ag, Scanner scan, String nomFichierConnexion)
			throws IOException {
		System.out.println("Entrez le mot de passe de l'agent que vous souhaitez ajouter :");
		String motDePasse = scan.nextLine();

		String identifiantsConnexion = ag.getEmail() + "," + motDePasse;
		return identifiantsConnexion;
	}
	
	public Mandat recupererInfosNouveauMandat(Scanner scan, Mandat manActuel) throws ParseException {
		
		System.out.println("Entrez le nouvelle id du bien : ");
		int nouvBienId = scan.nextInt();
		manActuel.setBienId(nouvBienId);
		
		System.out.println("Entrez le nouvelle id de l'agence : ");
		int nouvAgenceId = scan.nextInt();
		manActuel.setAgenceId(nouvAgenceId);
		
		System.out.println("Entrez le nouvelle id de l'agent : ");
		int nouvAgentId = scan.nextInt();
		manActuel.setAgentId(nouvAgentId);
		
		scan.nextLine();
		
		System.out.println("Entrez la nouvelle date de début indiqué sur votre nouveau permis de construire (sous le format JJ/MM/YYYY) : ");
		String nouvPermisConstruireDebut = scan.nextLine();
							
		System.out.println("Entrez la nouvelle date de fin indiqué sur votre nouveau permis de construire (sous le format JJ/MM/YYYY) : ");
		String nouvPermisConstruireFin = scan.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date permisConstruireDebut = sdf.parse(nouvPermisConstruireDebut);
		Date permisConstruireFin = sdf.parse(nouvPermisConstruireFin);
		
		manActuel.setPermisConstruireDebut(permisConstruireDebut);
		manActuel.setPermisConstruireFin(permisConstruireFin);

		System.out.println("Entrez le nouveau numéro de permis du mandat : ");
		int nouvNumPermis = scan.nextInt();
		manActuel.setNumPermis(nouvNumPermis);
		
		System.out.println("-- HELPER (Statut) --");
		System.out.println("0: En attente de construction");
		System.out.println("1: En construction");
		System.out.println("2: Construction terminée");
		System.out.println("------------");
		
		System.out.println("Entrez le nouveau statut (entre 0 et 2) : ");
		int nouvStatut = scan.nextInt();
		manActuel.setStatut(nouvStatut);
		
		return manActuel;
	}
	
	public Mandat modifierMandat(int idMandat, Scanner scan) throws IOException, ParseException {
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
					
					System.out.println("Voici le mandat que vous souhaitez modifier : " + ligne);
					System.out.println();
					
					manActuel = recupererInfosNouveauMandat(scan, manActuel);
					modifierMandatFichier(manActuel);

					return manActuel;
				}
			}
		} finally {
			lecteur.close();
		}
		return man;
	}

	private void modifierMandatFichier(Mandat man) throws IOException {
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
