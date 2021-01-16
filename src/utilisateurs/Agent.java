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
	
	public Agent from(String[] s) {
		String strAgentId = s[0].strip();
		String strDeptAgent = s[1].strip();
		String prenom = s[2].strip();
		String nom = s[3].strip();
		String numTel = s[4].strip();
		String agence = s[5].strip();
		String mail = s[6].strip();
			
		int agentId = Integer.parseInt(strAgentId);
		int deptAgent = Integer.parseInt(strDeptAgent);
		
		Agent ag = new Agent(prenom, nom, mail, numTel, agence, agentId, deptAgent);
		
		//System.out.println("0: ["+ag.getAgentId()+","+ag.getDeptAgent()+","+ag.getPrenom()+","+ag.getNom()+","+ag.getNumTel()+","+ag.getAgence()+","+ag.getEmail()+"]");
		
		return ag;
	}
		
	public Agent recupererInfos(String mailB) throws IOException {
		// TODO : Retourner un agent
		Agent ag = new Agent();
		Agent agActuel;
		FileReader lecteurFichier = new FileReader("agents.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
				
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String mailA = mots[6];
				if (mailA.equals(mailB)) {
					agActuel = ag.from(mots);
					//System.out.println("1: ["+agActuel.getAgentId()+","+agActuel.getDeptAgent()+","+agActuel.getPrenom()+","+agActuel.getNom()+","+agActuel.getNumTel()+","+agActuel.getAgence()+","+agActuel.getEmail()+"]");
					return agActuel;
				}
			}
		} finally {
			lecteur.close();	
		}
		return ag;
	}
	
	public void modifierStatutMandat(int idMandat) throws IOException {
		String identifiantB = String.valueOf(idMandat);
		FileReader lecteurFichier = new FileReader("mandats.txt");
		BufferedReader lecteur = new BufferedReader(lecteurFichier);
		
		try {
			String ligne;
			while ((ligne = lecteur.readLine()) != null) {
				String[] mots = ligne.split(",");
				String identifiantA = mots[3];
				if (identifiantA.equals(identifiantB)) {
					System.out.println(ligne);
				}
			} 
		} finally {
			lecteur.close();	
		}
	}
}
