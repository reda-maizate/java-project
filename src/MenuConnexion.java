import java.io.IOException;
import java.util.Scanner;
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
				boolean existe = util.comparerUtilisateur(mail, mdp, fichier.nomFichier);
				
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
				}
			}
		} catch(Exception e) {
			System.out.println("Problème lors de la vérification de l'utilisateur dans le fichier txt");
		} finally {
			scan.close();
		}
	}
}
	
