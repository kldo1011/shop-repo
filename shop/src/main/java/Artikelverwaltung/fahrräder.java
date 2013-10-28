package Artikelverwaltung;

public abstract class fahrräder {
	
	private String artkikelbezeichnung;
	private double größeInZoll;
	private String Kategorie;
	private double rahmenhöhe;
	private String farbe;
	private String hersteller;
	private double preis;
	public String getArtkikelbezeichnung() {
		return artkikelbezeichnung;
	}
	public void setArtkikelbezeichnung(String artkikelbezeichnung) {
		this.artkikelbezeichnung = artkikelbezeichnung;
	}
	public double getGrößeInZoll() {
		return größeInZoll;
	}
	public void setGrößeInZoll(double größeInZoll) {
		this.größeInZoll = größeInZoll;
	}
	public String getKategorie() {
		return Kategorie;
	}
	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}
	public double getRahmenhöhe() {
		return rahmenhöhe;
	}
	public void setRahmenhöhe(double rahmenhöhe) {
		this.rahmenhöhe = rahmenhöhe;
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
