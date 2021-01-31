package menu;

public class Menu {

	public Menu() {
	}

	public void optionInexistante() {
		System.out.println("");
		System.out.println("Vous avez choisi une option inexistante ! Réessayez !");
		System.out.println("");
	}

	public void quitter() {
		System.out.println("Au revoir !");
		System.exit(0);
	}
}
