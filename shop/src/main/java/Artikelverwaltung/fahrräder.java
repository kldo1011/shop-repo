package Artikelverwaltung;

public abstract class fahrr�der {
	
	private String artkikelbezeichnung;
	private double gr��eInZoll;
	private String Kategorie;
	private double rahmenh�he;
	private String farbe;
	private String hersteller;
	private double preis;
	public String getArtkikelbezeichnung() {
		return artkikelbezeichnung;
	}
	public void setArtkikelbezeichnung(String artkikelbezeichnung) {
		this.artkikelbezeichnung = artkikelbezeichnung;
	}
	public double getGr��eInZoll() {
		return gr��eInZoll;
	}
	public void setGr��eInZoll(double gr��eInZoll) {
		this.gr��eInZoll = gr��eInZoll;
	}
	public String getKategorie() {
		return Kategorie;
	}
	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}
	public double getRahmenh�he() {
		return rahmenh�he;
	}
	public void setRahmenh�he(double rahmenh�he) {
		this.rahmenh�he = rahmenh�he;
	}
	public String getFarbe() {
		return farbe;
	}
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	

}
