package fr.epsi.dto;

public class ProduitDTO {

	private String nom;
	private String codeBarre;


	private String prix;
	
	public ProduitDTO () {}
	
	public ProduitDTO (String n, String c, String p) 
	{
		this.nom = n;
		this.codeBarre = c;
		this.prix = p;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public String getCodeBarre() 
	{
		return codeBarre;
	}
	
	public void setCodeBarre(String codeBarre) 
	{
		this.codeBarre = codeBarre;
	}
	
	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}
	
}
