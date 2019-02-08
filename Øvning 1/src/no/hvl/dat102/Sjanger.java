package no.hvl.dat102;

public enum Sjanger {
	ROCK(1), POP(2), OPERA(3), JAZZ(4), KLASSISK(5);
	private int nr;

	private Sjanger(int n) { 
		this.nr = n; //        
	}

	public int getNr() {
		return nr;
	}

	public static Sjanger finnSjanger(int n) {
		Sjanger sjangr = null;
		for (Sjanger sjng : Sjanger.values()) {
			if (sjng.nr == n) {
				sjangr = sjng;
				break;
			}
		}
		return sjangr;
	}

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjangr = null;
		for (Sjanger sjng : Sjanger.values()) {
			if (sjng.toString().equals(navn.toUpperCase())) {
				sjangr = sjng;
				break;
			}
		}
		return sjangr;
	}
}
