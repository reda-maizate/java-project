package menu;
import java.io.IOException;
import java.util.Scanner;

import utilisateurs.Directeur;

public class MenuDirecteur extends Menu {
	
	public MenuDirecteur() {
		super();
	}
	
	public int show(Directeur dir) throws IOException {//int directeurId, String prenom, String nom, String numTel, String agence, String email) {
		Scanner scan = new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println("Bienvenue " + dir.getPrenom() + " " + dir.getNom() +"!");
				System.out.println("");
				System.out.println("Choissisez une option:");
				System.out.println("1. Voir la liste des mandats");
				System.out.println("2. Modifier un mandat");
				System.out.println("3. Ajouter un agent");
				System.out.println("4. Attribuer un filtre d'attribution de département à un mandat");
				System.out.println("5. Quitter");
				System.out.println("");
				System.out.println("Entrez le nombre de votre option : ");
				
				int choix = scan.nextInt();
				
				System.out.println("");

				switch (choix) {
					case 1: 
						dir.afficherListeMandat(dir.getDirecteurId());
						break;
					case 2:
						System.out.println("Entrez l'id du mandat que vous souhaitez modifier :");
						int idMandat = scan.nextInt();
						//dir.modifierMandat(idMandat);
						break;
					case 3: 
						//dir.ajouterAgent(scan);
						break;
					case 4:
						//new attribuerFiltreDeptMandat();
						break;
					case 5:
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
