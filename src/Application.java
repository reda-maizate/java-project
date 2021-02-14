import menu.MenuPrincipal;

public class Application {
	public static void main(String[] args) throws Exception {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.show();
		
		//File agentFile = new File("agents.txt");
		
		//UtilisateurListe users = new UtilisateurListe();
		//users.readFrom(agentFile);
		//users.get(0).setEmail("toto@gmail.com");
		//users.save(agentFile);
	}
}