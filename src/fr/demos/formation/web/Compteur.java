package fr.demos.formation.web;

public class Compteur {

	private int valeur;
		
	public Compteur() {
			
	}

	public int getValeur() {
		return this.valeur;
		
	}
	
	public void incremente() {
		valeur++;
	}
	
	public void decremente() {
		valeur--;
	}
	
}
