package Ejer7b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejer7 {

	private static Scanner teklatuScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fitxategi = new File("C:\\Users\\in1dm3-d\\Documents\\fitxategi.txt");

		boolean irten = false;

		System.out.println("Zenbat ikasle kargatu nahi duzu?");
		Ikasleak ikaslelist[] = new Ikasleak[Integer.parseInt(teklatuScanner.nextLine())];
		
		if (fitxategi.exists()) {
			fitxategizatitu(fitxategi, ikaslelist);
		} else {
			try {
				fitxategi.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Menu nagusia");

		do {
			System.out.println("1.- Ikasleen datuak kargatzea\n" + "2.- Datuak prozesatzea\n"
					+ "3.- Ikasleen datuak erakustea\n" + "4.- Ikasle baten datuak erakustea\n" + "0.- Amaiera");
			int aukera = Integer.parseInt(teklatuScanner.nextLine());

			switch (aukera) {
			case 0:

				fitxatiIdatzi(fitxategi, ikaslelist);
				irten = true;
				break;

			case 1:

				for (int i = 0; i < ikaslelist.length; i++) {
					ikaslelist[i] = DatuakKargatu();
				}

				break;

			case 2:

				System.out.println(batezBesteko(ikaslelist));
				System.out.println(pertsonenAltuera(ikaslelist));

				break;

			case 3:
				System.out.println("Ikasleen zerrenda\n" + "Izena Sexua Adina Altuera (m) Pisua "
						+ "(kg)\n--------------------------------");
				for (int i = 0; i < ikaslelist.length; i++) {
					System.out.println(ikaslelist[i].erakutsi());
				}

				break;

			case 4:

				IkasleDatuak(ikaslelist);

				break;

			default:
				break;
			}
		} while (irten == false);

	}

	private static Ikasleak DatuakKargatu() {

		Ikasleak ikas = new Ikasleak();

		System.out.println("Izena:");
		ikas.setIzena(teklatuScanner.nextLine());

		System.out.println("Sexua: (G gizona, E emakumea)");
		String katea = teklatuScanner.nextLine();

		if (katea.equalsIgnoreCase("G")) {
			ikas.setSexua("Gizona");

		} else {
			ikas.setSexua("Emakumea");
		}

		System.out.println("Adina:");
		ikas.setAdina(Integer.parseInt(teklatuScanner.nextLine()));

		System.out.println("Altuera:");
		ikas.setAltuera(Double.parseDouble(teklatuScanner.nextLine()));

		System.out.println("Pisua:");
		ikas.setPisua(Integer.parseInt(teklatuScanner.nextLine()));

		return ikas;
	}

	private static String batezBesteko(Ikasleak ikaslelist[]) {
		int totala = 0;
		int gizonak = 0;

		for (int i = 0; i < ikaslelist.length; i++) {
			if (ikaslelist[i].getSexua().equals("Gizona")) {
				totala = totala + ikaslelist[i].getAdina();
				gizonak++;
			}
		}

		if (gizonak == 0) {
			return "\nEz daude gizonak, ezin da bataz bestekoa kalkulatu";
		} else {
			totala = totala / gizonak;
			return "\nSexu maskulinoa duten pertsonen batez besteko adina: " + totala;
		}
	}

	private static String pertsonenAltuera(Ikasleak ikaslelist[]) {
		int kont = 0;

		for (int i = 0; i < ikaslelist.length; i++) {
			if (ikaslelist[i].getAltuera() > 1.65) {
				kont++;
			}
		}

		return "1.65 metro baino gehiago neurtzen duten pertsonak: " + kont + "\n";
	}

	private static void IkasleDatuak(Ikasleak ikaslelist[]) {

		int kont = 0;

		System.out.println("Sartu izen bat");
		String izena = teklatuScanner.nextLine();

		for (Ikasleak ikas : ikaslelist) {

			if (ikas.getIzena().equals(izena)) {
				System.out.println(ikas.getdatuak());
			} else {
				kont++;
			}
		}

		if (kont > 0) {
			System.out.println("Izen hori ez dago");
		}

	}

	private static void fitxatiIdatzi(File fitxategi, Ikasleak ikaslelist[]) {
		try {
			BufferedWriter lapiz = new BufferedWriter(new FileWriter(fitxategi));

			for (int i = 0; i < ikaslelist.length; i++) {
				lapiz.write(ikaslelist[i].toString());
				lapiz.newLine();
			}

			lapiz.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fitxategizatitu(File fitxategi, Ikasleak ikaslelist[]) {
		try {
			BufferedReader ojos = new BufferedReader(new FileReader(fitxategi));
			String lineaString;
			try {
					
				for (int i = 0; ((lineaString = ojos.readLine()) != null); i++ ) {
					
					String[] atributoStrings = lineaString.split(",");
					
					Ikasleak ikas = new Ikasleak();
					ikas.setIzena(atributoStrings[0]);
					ikas.setSexua(atributoStrings[1]);
					ikas.setAdina(Integer.parseInt(atributoStrings[2]));
					ikas.setAltuera(Double.parseDouble(atributoStrings[3]));
					ikas.setPisua(Integer.parseInt(atributoStrings[4]));
					
					ikaslelist[i] = ikas;

				}
				
				ojos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
