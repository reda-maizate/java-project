package menu;
import java.util.Scanner;

public class MenuAgent extends Menu {
	
	// Créer une méthode public int MenuAgent.show()
	
	public MenuAgent() {
		super();
	}
	
	public int show(int agentId, int deptAgent, String prenom, String nom, String numTel, String agence, String email) {
		Scanner scan = new Scanner(System.in);
		try {
		while (true) {
			System.out.println("Bienvenue "+ prenom + " " + nom +"!");
			System.out.println("");
			System.out.println("Choissisez une option:");
			System.out.println("1. Voir la liste des mandats");
			System.out.println("2. Modifier le statut d'un mandat");
			System.out.println("3. Quitter");
			System.out.println("");
			System.out.println("Entrez le nombre de votre option : ");
			
			int choix = scan.nextInt();
			
			switch (choix) {
				case 1: 
					//new afficherListeMandat(int id);
					break;
				case 2:
					//new modifierStatutMandat(int id);
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
