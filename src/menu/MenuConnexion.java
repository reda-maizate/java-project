package menu;
import java.util.Scanner;

import utilisateurs.Agent;
import utilisateurs.Directeur;
import utilisateurs.Utilisateur;
import gestionFichier.gestionFichier;

public class MenuConnexion extends Menu {
	
	public MenuConnexion() {
		super();
	}
	
	public boolean show() {
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
						MenuConnexion menuConnexion = new MenuConnexion();
						menuConnexion.show();
						break;
					case 2: 
						quitter();
					default:
						optionInexistante();
						break;
					}
				} else {
					Directeur dir = new Directeur();
					Agent ag = new Agent();
										
					boolean isAgent = ag.comparerAgents(mail);

					if (isAgent) {
						Agent agA;
						agA = ag.recupererInfos(mail);
						//int agentId = agA.getAgentId();
						//int deptAgent = agA.getDeptAgent();
						//String prenom = agA.getPrenom();
						//String nom = agA.getNom();
						//String numTel = agA.getNumTel();
						//String agence = agA.getAgence();
						//String email = agA.getEmail();
						
						//System.out.println("2: ["+agA.getAgentId()+","+agA.getDeptAgent()+","+agA.getPrenom()+","+agA.getNom()+","+agA.getNumTel()+","+agA.getAgence()+","+agA.getEmail()+"]");
						
						MenuAgent menuAgent = new MenuAgent();
						menuAgent.show(agA);
						return true;
					}
					
					boolean isDirecteur = dir.comparerDirecteurs(mail);

					if (isDirecteur) {
						Directeur dirA;
						dirA = dir.recupererInfos(mail);
						//System.out.println("2: ["+directeurId+","+prenom+","+nom+","+numTel+","+agence+","+email+"]");
						
						MenuDirecteur menuDirecteur = new MenuDirecteur();
						menuDirecteur.show(dirA);
						return true;
					}
				}
			}
		} catch(Exception e) {
			System.out.println("Problème lors de la vérification de l'utilisateur dans le fichier txt / " + e);
		} finally {
			scan.close();
		}
		return false;
	}
}
	
