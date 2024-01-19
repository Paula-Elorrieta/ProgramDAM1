package Ejer7b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ikasleak {

	private String izena;
	private String sexua;
	private int adina;
	private double altuera;
	private int pisua;

	public Ikasleak() {
		izena = "";
		adina = 1;
		sexua = "H";
		pisua = 30;
		altuera = 1;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getSexua() {
		return sexua;
	}

	public void setSexua(String sexua) {
		this.sexua = sexua;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public double getAltuera() {
		return altuera;
	}

	public void setAltuera(double altuera) {
		this.altuera = altuera;
	}

	public int getPisua() {
		return pisua;
	}

	public void setPisua(int pisua) {
		this.pisua = pisua;
	}

	@Override
	public String toString() {
		return izena + "," + sexua + "," + adina + "," + altuera + "," + pisua;
	}
	
	public String erakutsi() {
		return izena + " " + sexua + " " + adina + " " + altuera + " " + pisua + "\n";
	}
	
	public String getdatuak() {
		return "\nIkaslearen datuak:\nIzena: " + izena + "\nSexua: " + sexua + "\nAdina: " + adina
				+ " urte\nAltuera: " + altuera + " m\nPisua: " + pisua + " kg.\n"; 
				
	}
	


}
