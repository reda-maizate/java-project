import java.util.Date;

public class Mandat {
	private int mandatId;
	private int bienId;
	private int agenceId;
	private int agentId;
	private Date permisConstruireDebut;
	private Date permisConstruireFin;
	private int numPermis;
	
	public Mandat(int mandatId, int bienId, int agenceId, int agentId, Date permisConstuireDebut, Date permisConstruireFin, int numPermis) {
		this.mandatId = mandatId;
		this.bienId = bienId;
		this.agenceId = agenceId;
		this.agentId = agentId;
		this.permisConstruireDebut = permisConstuireDebut;
		this.permisConstruireFin = permisConstruireFin;
		this.numPermis = numPermis;
	}

	public int getMandatId() {
		return mandatId;
	}

	public int getBienId() {
		return bienId;
	}

	public void setBienId(int bienId) {
		this.bienId = bienId;
	}

	public int getAgenceId() {
		return agenceId;
	}

	public void setAgenceId(int agenceId) {
		this.agenceId = agenceId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Date getPermisConstruireDebut() {
		return permisConstruireDebut;
	}

	public void setPermisConstruireDebut(Date permisConstruireDebut) {
		this.permisConstruireDebut = permisConstruireDebut;
	}

	public Date getPermisConstruireFin() {
		return permisConstruireFin;
	}

	public void setPermisConstruireFin(Date permisConstruireFin) {
		this.permisConstruireFin = permisConstruireFin;
	}

	public int getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(int numPermis) {
		this.numPermis = numPermis;
	}
	
	
}
