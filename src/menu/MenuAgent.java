package menu;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import utilisateurs.Agent;

public class MenuAgent extends Menu {

	// Créer une méthode public int MenuAgent.show()

	public MenuAgent() {
		super();
	}

	public int show(Agent ag) throws IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Bienvenue " + ag.getPrenom() + " " + ag.getNom() + "!");
			while (true) {
				System.out.println("");
				System.out.println("Choissisez une option:");
				System.out.println("1. Voir la liste des mandats");
				System.out.println("2. Modifier le statut d'un mandat");
				System.out.println("3. Quitter");
				System.out.println("");
				System.out.println("Entrez le nombre correspondant à votre option : ");

				int choix = scan.nextInt();

				System.out.println("");

				switch (choix) {
				case 1:
					ag.afficherListeMandat(ag.getAgentId());
					break;
				case 2:
					System.out.println("Entrez l'id du mandat que vous souhaitez modifier :");
					int idMandat = scan.nextInt();
					ag.modifierStatutMandat(idMandat, scan);
					break;
				case 3:
					MenuPrincipal menuPrincipal = new MenuPrincipal();
					menuPrincipal.show();
				default:
					optionInexistante();
					break;
				}
			}
		} finally {
			scan.close();
		}
	}
}
