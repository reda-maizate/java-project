
public class Agent {
	private int agentId;
	private int agenceId;
	private String prenomAgent;
	private String nomAgent;
	private String emailAgent;
	private int numTelAgent;
	private int deptAgent;
	
	public Agent(int agentId, int agenceId, String prenomAgent, String nomAgent, String emailAgent, int numTelAgent, int deptAgent) {
		this.agentId = agentId;
		this.agenceId = agenceId;
		this.prenomAgent = prenomAgent;
		this.nomAgent = nomAgent;
		this.emailAgent = emailAgent;
		this.numTelAgent = numTelAgent;
		this.deptAgent = deptAgent;
	}

	public int getAgentId() {
		return agentId;
	}

	public int getAgenceId() {
		return agenceId;
	}

	public void setAgenceId(int agenceId) {
		this.agenceId = agenceId;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}

	public String getEmailAgent() {
		return emailAgent;
	}

	public void setEmailAgent(String emailAgent) {
		this.emailAgent = emailAgent;
	}

	public int getNumTelAgent() {
		return numTelAgent;
	}

	public void setNumTelAgent(int numTelAgent) {
		this.numTelAgent = numTelAgent;
	}

	public int getDeptAgent() {
		return deptAgent;
	}

	public void setDeptAgent(int deptAgent) {
		this.deptAgent = deptAgent;
	}
	
	
}
