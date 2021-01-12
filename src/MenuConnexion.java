import java.util.List;
import java.util.Scanner;

import utilisateurs.Agent;
import utilisateurs.Directeur;
import utilisateurs.Utilisateur;
import gestionFichier.gestionFichier;

public class MenuConnexion {
	
	public MenuConnexion() {
		Scanner scan = new Scanner(System.in);
		gestionFichier fichier = new gestionFichier();
		
		try {
			while (true) {
				System.out.println("## Se connecter");
				System.out.println("");
				System.out.println("Entrez votre adresse mail : ");
				String mail = scan.nextLine();
				System.out.println("Entrez votre mot de passe : ");
				String mdp = scan.nextLine();
				System.out.println("");
				
				Utilisateur util = new Utilisateur();
				boolean existe = util.comparerUtilisateur(mail, mdp, fichier.FichierConnexion);
				
				
				if (!existe) {
					System.out.println("");
					System.out.println("Votre mail ou votre mot de passe est incorrect !");
					System.out.println("1. Réessayer");
					System.out.println("2. Quitter");
					System.out.println("");
					
					int choix = scan.nextInt();
					
					switch (choix) {
					case 1: 
						new MenuConnexion();
						break;
					case 2: 
						System.out.println("Au revoir !");
						System.exit(0);
					default:
						System.out.println("");
						System.out.println("Vous avez choisi une option inexistante ! Réessayez !");
						System.out.println("");
						break;
					}
				} else {
					Directeur dir = new Directeur();
					Agent ag = new Agent();
										
					boolean isAgent = ag.comparerAgents(mail);

					if (isAgent) {
						//new MenuAgent();
					}
					
					boolean isDirecteur = dir.comparerDirecteurs(mail);

					if (isDirecteur) {
						List<Object> infos = dir.recupererInfos(mail);
						int directeurId = (Integer) infos.get(0);
						String prenom = (String) infos.get(1);
						String nom = (String) infos.get(2);
						String numTel = (String) infos.get(3);
						String agence = (String) infos.get(4);
						String email = (String) infos.get(5);
						new MenuDirecteur(directeurId, prenom, nom, numTel, agence, email);
					}
				}
			}
		} catch(Exception e) {
			System.out.println("Problème lors de la vérification de l'utilisateur dans le fichier txt / " + e);
		} finally {
			scan.close();
		}
	}
}
	
