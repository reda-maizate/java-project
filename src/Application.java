import gestionFichier.gestionFichier;

public class Application {
	public static void main(String[] args) throws Exception
    {
        gestionFichier f = new gestionFichier();
        f.creerFichier();
        f.ajouterUtilisateur("reda", "maizate", f.nomFichier);
        f.ajouterUtilisateur("john", "doe", f.nomFichier);
        f.ajouterUtilisateur("vincent", "cassel", f.nomFichier);
        f.comparerUtilisateur("reda", "maizate", f.nomFichier);
    }
}
