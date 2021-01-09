package entites;

public class CaracteristiquesExt {
	private int surfaceExt;
	private int asJardin;
	private int asGarage;
	
	public CaracteristiquesExt(int surfaceExt, int asJardin, int asGarage) {
		this.surfaceExt = surfaceExt;
		this.asJardin = asJardin;
		this.asGarage = asGarage;
	}

	public int getSurfaceExt() {
		return surfaceExt;
	}

	public void setSurfaceExt(int surfaceExt) {
		this.surfaceExt = surfaceExt;
	}

	public int getAsGarage() {
		return asGarage;
	}

	public void setAsGarage(int asGarage) {
		this.asGarage = asGarage;
	}

	public int getAsJardin() {
		return asJardin;
	}

	public void setAsJardin(int asJardin) {
		this.asJardin = asJardin;
	}
	
}
