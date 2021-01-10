import java.io.DataInputStream;
import java.util.Scanner;
import java.lang.System;

public class MenuPrincipal {
	
	public MenuPrincipal() {
		
		Scanner scan = new Scanner(System.in);
		try {
		while (true) {
			System.out.println("## Bienvenue !");
			System.out.println("");
			System.out.println("Choissisez une option:");
			System.out.println("1. Se connecter");
			System.out.println("2. Quitter");
			System.out.println("");
			System.out.println("Entrez le nombre de votre option : ");
			
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
		} finally {
			scan.close();
		}
	}
}
