package menu;

import java.util.Scanner;

import utilisateurs.Agent;
import utilisateurs.Directeur;
import utilisateurs.Utilisateur;

public class MenuConnexion extends Menu {

	public MenuConnexion() {
		super();
	}

	public boolean show() {
		Scanner scan = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("## Se connecter");
				System.out.println("");
				System.out.println("Entrez votre adresse mail : ");
				String email = scan.nextLine();
				System.out.println("Entrez votre mot de passe : ");
				String mdp = scan.nextLine();
				System.out.println("");

				Utilisateur util = new Utilisateur();
				boolean existe = util.verificationConnexion(email, mdp);

				if (!existe) {
					System.out.println("");
					System.out.println("Votre mail ou votre mot de passe est incorrect !");
					System.out.println("1. Réessayer");
					System.out.println("2. Quitter");
					System.out.println("");

					int choix;
					
					try {
						choix = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Erreur : Vous n'avez pas inséré un nombre !");
						choix = 4;
					}

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

					boolean isAgent = ag.comparerAgents(email);

					if (isAgent) {
						Agent agA;
						agA = ag.recupererInfos(email);
					
						MenuAgent menuAgent = new MenuAgent();
						menuAgent.show(agA);
						
						return true;
					}

					boolean isDirecteur = dir.comparerDirecteurs(email);

					if (isDirecteur) {
						Directeur dirA;
						dirA = dir.recupererInfos(email);

						MenuDirecteur menuDirecteur = new MenuDirecteur();
						menuDirecteur.show(dirA);
						
						return true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Problème lors de la vérification de l'utilisateur dans le fichier txt / " + e);
		} finally {
			scan.close();
		}
		return false;
	}
}
