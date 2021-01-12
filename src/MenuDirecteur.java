import java.util.Scanner;

public class MenuDirecteur {
	public MenuDirecteur(int directeurId, String prenom, String nom, String numTel, String agence, String email) {
		Scanner scan = new Scanner(System.in);
		try {
		while (true) {
			System.out.println("Bienvenue " + prenom + " " + nom +" !");
			System.out.println("");
			System.out.println("Choissisez une option:");
			System.out.println("1. Voir la liste des mandats");
			System.out.println("2. Modifier le statut d'un mandat");
			System.out.println("3. Ajouter un agent");
			System.out.println("4. Attribuer un filtre d'attribution de département à un mandat");
			System.out.println("5. Quitter");
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
					//new ajouterAgent();
					break;
				case 4:
					//new attribuerFiltreDeptMandat();
					break;
				case 5:
					new MenuConnexion();
				default:
					System.out.println("");
					System.out.println("Vous avez choisi une option inexistante ! Réessayez !");
					System.out.println("");
					break;
				}
			}
		} finally {
			scan.close();
		}
	}
}
