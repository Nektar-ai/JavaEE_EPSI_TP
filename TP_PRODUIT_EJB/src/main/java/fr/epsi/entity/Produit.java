package fr.epsi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.epsi.dto.ProduitDTO;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private double prix;
	private String codeBarre;
	@ManyToOne
	@JoinColumn(name = "facture_id")
	private Facture facture;
	
	public Produit() {}
	
	public Produit (String n, String c) 
	{
		this.nom = n;
		this.codeBarre = c;
	}
	
	public Produit (ProduitDTO p) 
	{
		this.nom = p.getNom();
		this.codeBarre = p.getCodeBarre();
		this.prix = Double.valueOf(p.getPrix());
	}
	
	public Long getId() {
		return id;
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
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
