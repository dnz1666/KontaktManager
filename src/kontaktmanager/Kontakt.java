package kontaktmanager;

public class Kontakt {
	private String name;
	private String email;
	private String telefon;
	
	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getTelefon() {
	    return telefon;
	}

	public void setTelefon(String telefon) {
	    this.telefon = telefon;
	}
	
	public Kontakt(String name, String email, String telefon) {
	    this.name = name;
	    this.email = email;
	    this.telefon = telefon;
	}
	
	public void zeigeInfo() {
	    System.out.println("Name: " + name);
	    System.out.println("Email: " + email);
	    System.out.println("Telefon: " + telefon);
	    System.out.println("---");
	}
}
