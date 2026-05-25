package kontaktmanager;
import java.util.ArrayList;
import java.util.Scanner;


public class KontaktManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Kontakt> kontakte = new ArrayList<>();
		laden(kontakte);
		int wahl = 0;

		while (wahl != 6) {
		    System.out.println("\n--- Kontakt Manager ---");
		    System.out.println("1. Kontakt hinzufügen");
		    System.out.println("2. Alle Kontakte anzeigen");
		    System.out.println("3. Kontakt löschen");
		    System.out.println("4. Kontakt suchen");
		    System.out.println("5. Kontakte speichern");
		    System.out.println("6. Beenden");
		    System.out.print("Deine Wahl: ");

		    wahl = Integer.parseInt(scanner.nextLine());

		    if (wahl == 1) {
		        System.out.print("Name: ");
		        String name = scanner.nextLine();
		        System.out.print("Email: ");
		        String email = scanner.nextLine();
		        System.out.print("Telefon: ");
		        String telefon = scanner.nextLine();
		        kontakte.add(new Kontakt(name, email, telefon));
		        System.out.println("Kontakt gespeichert!");

		    } else if (wahl == 2) {
		        if (kontakte.isEmpty()) {
		            System.out.println("Keine Kontakte vorhanden.");
		        } else {
		            for (Kontakt k : kontakte) {
		                k.zeigeInfo();
		            }
		        }

		    } else if(wahl == 3) {
		    	if (kontakte.isEmpty()) {
		            System.out.println("Keine Kontakte vorhanden.");
		            continue;
		       }
		    	System.out.print("Welchen Kontakt möchten Sie löschen? (Name):");
		    	String del = scanner.nextLine();
		    	
		    	Kontakt zuLoeschen = null;
		    	
		    	for(Kontakt k : kontakte) {
		    		if(k.getName().equals(del)) {
		    			zuLoeschen = k;
		    		}
		    	}
		    	if (zuLoeschen != null) {
		    		kontakte.remove(zuLoeschen);
		    		System.out.println("Kontakt gelöscht!");
		    	}
		    	else {
		    		System.out.println("Kontakt nicht gefunden.");
		    	}
		    	
		    }
		    else if (wahl == 4) {
		    	if (kontakte.isEmpty()) {
		            System.out.println("Keine Kontakte vorhanden.");
		            continue;
		       }
		    	System.out.print("Welchen Namen möchten Sie suchen?");
		    	String search = scanner.nextLine();
		    	
		    	Kontakt zuSuchen = null;
		    	
		    	for(Kontakt k : kontakte) {
		    		if(k.getName().equals(search)) {
		    			zuSuchen = k;
		    		}
		    }
		    	if(zuSuchen != null) {
		    		System.out.println();
		    		zuSuchen.zeigeInfo();
		    	}
		    	else {
		    		System.out.println("Kontakt nicht gefunden.");
		    	}
		    }
		    else if (wahl == 5) {
		        speichern(kontakte);
		    }
		    else if (wahl != 6) {
		        System.out.println("Ungültige Eingabe!");
		    }
		}

		System.out.println("Programm beendet.");
	}
	
	
	
	public static void laden(ArrayList<Kontakt> kontakte) {
	    try {
	        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("kontakte.txt"));
	        String zeile;
	        while ((zeile = br.readLine()) != null) {
	            String[] teile = zeile.split(";");
	            kontakte.add(new Kontakt(teile[0], teile[1], teile[2]));
	        }
	        br.close();
	        System.out.println("Kontakte geladen!");
	    } catch (Exception e) {
	        System.out.println("Keine gespeicherten Kontakte gefunden.");
	    }
	}
	
	
	
	public static void speichern(ArrayList<Kontakt> kontakte) {
	    try {
	        java.io.FileWriter fw = new java.io.FileWriter("kontakte.txt");
	        for (Kontakt k : kontakte) {
	            fw.write(k.getName() + ";" + k.getEmail() + ";" + k.getTelefon() + "\n");
	        }
	        fw.close();
	        System.out.println("Kontakte gespeichert!");
	    } catch (Exception e) {
	        System.out.println("Fehler beim Speichern: " + e.getMessage());
	    }
	}
	
}
