package utilisateurs;

public class Agent extends Utilisateur {
	private int agentId;
	private int deptAgent;
	
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
	
	
}
