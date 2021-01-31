package entites;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Mandat {
	private int mandatId;
	private int bienId;
	private int agenceId;
	private int agentId;
	private Date permisConstruireDebut;
	private Date permisConstruireFin;
	private int numPermis;
	private int statut;

	public Mandat(int mandatId, int bienId, int agenceId, int agentId, Date permisConstuireDebut,
			Date permisConstruireFin, int numPermis, int statut) {
		this.mandatId = mandatId;
		this.bienId = bienId;
		this.agenceId = agenceId;
		this.agentId = agentId;
		this.permisConstruireDebut = permisConstuireDebut;
		this.permisConstruireFin = permisConstruireFin;
		this.numPermis = numPermis;
		this.statut = statut;
	}

	public Mandat() {
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
		return this.permisConstruireDebut;
	}

	public void setPermisConstruireDebut(Date permisConstruireDebut) {
		this.permisConstruireDebut = permisConstruireDebut;
	}

	public Date getPermisConstruireFin() {
		return this.permisConstruireFin;
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

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Mandat from(String[] s) throws ParseException {
		String strMandatId = s[0].strip();
		String strBienId = s[1].strip();
		String strAgenceId = s[2].strip();
		String strAgentId = s[3].strip();
		String strPermisConstruireDebut = s[4].strip();
		String strPermisConstruireFin = s[5].strip();
		String strNumPermis = s[6].strip();
		String strStatut = s[7].strip();

		int mandatId = Integer.parseInt(strMandatId);
		int bienId = Integer.parseInt(strBienId);
		int agenceId = Integer.parseInt(strAgenceId);
		int agentId = Integer.parseInt(strAgentId);
		int numPermis = Integer.parseInt(strNumPermis);
		int statut = Integer.parseInt(strStatut);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date permisConstruireDebut = sdf.parse(strPermisConstruireDebut);
		Date permisConstruireFin = sdf.parse(strPermisConstruireFin);

		Mandat man = new Mandat(mandatId, bienId, agenceId, agentId, permisConstruireDebut, permisConstruireFin,
				numPermis, statut);

		return man;
	}

}
