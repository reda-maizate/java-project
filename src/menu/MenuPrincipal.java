package menu;

import java.util.Scanner;
import java.lang.System;

public class MenuPrincipal extends Menu {

	public MenuPrincipal() {
		super();
	}

	public void show() {

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
					MenuConnexion menuConnexion = new MenuConnexion();
					menuConnexion.show();
					break;
				case 2:
					quitter();
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
