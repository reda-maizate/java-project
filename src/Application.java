import gestionFichier.gestionFichier;
import utilisateurs.Agent;

public class Application {
	public static void main(String[] args) throws Exception
    {
        gestionFichier f = new gestionFichier();
        f.creerFichier();
        Agent user = new Agent("reda", "maizate", "redamzt@gmail.com", "0781648585", f.nomFichier);
        //f.ajouterUtilisateur("reda", "mdp1", "agent", f.nomFichier);
        //f.ajouterUtilisateur("john", "mdp2", "directeur", f.nomFichier);
        f.ajouterUtilisateur("vincent", "mdp2", "agent", f.nomFichier);
        f.comparerUtilisateur("reda", "maizate", f.nomFichier);
    }
}
