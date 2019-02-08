package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CD {
	
	public int cdnummer;
	public String artist;
	public String tittel;
	public int �r;
	public String plateselskap;
	public Sjanger sjanger;
	

		
	public CD() {
		cdnummer = -1;
		artist = "Ingen";
		tittel = "Ingen";
		�r = -1;
		plateselskap = "Ingen";
	}
	public CD(int cdnummer, String artist, String tittel, int �r, Sjanger sjanger, String plateselskap) {
		this.cdnummer = cdnummer;
		this.artist = artist;
		this.tittel = tittel;
		this.�r = �r;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}
	public int getCdnummer() {
		return cdnummer;
	}
	public void setCdnummer(int cdnummer) {
		this.cdnummer = cdnummer;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int get�r() {
		return �r;
	}
	public void set�r(int �r) {
		this.�r = �r;
	}
	public String getPlateselskap() {
		return plateselskap;
	}
	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
}	