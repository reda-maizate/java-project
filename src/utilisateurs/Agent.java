package utilisateurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Agent extends Utilisateur {
	private int agentId;
	private int deptAgent;
	
	public Agent() {}
	
	public Agent(String prenom, String nom, String email, String numTel, String agence, int agentId, int deptAgent) {
		super(prenom, nom, email, numTel, agence);
		this.agentId = agentId;
		this.deptAgent = deptAgent;
	}

	public int getAgentId() {
		return agentId;
	}

	public int getDeptAgent() {
		return deptAgent;
	}

	public void setDeptAgent(int deptAgent) {
		this.deptAgent = deptAgent;
	}
	
	public boolean comparerAgents(String identifiant) throws IOException {
		String identifiantsB = identifiant;
		FileReader lecteurFichier = new FileReader("agents.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);

		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantsA = mots[6];
				if (identifiantsA.equals(identifiantsB)) {
					return true;
				}
			} 
		} finally {
			lecteur.close();	
		}
		return false;
	}
	
}
