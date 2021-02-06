package fr.epsi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneFacture {
	
/* 	Annotations d�clarant l'attribut id comme cl� primaire dans la database, 
 * 	& sa g�n�ration automatique par la base de donn�e
 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int qte;
	private double prix;

// Annotation d�clarant une cardinalit� n - 1 entre la table LigneFacture & la table Facture	
	
	@ManyToOne	
	private Facture facture;
	
// Annotation d�clarant une cardinalit� n - 1 entre la table LigneFacture & la table Produit	
	
	@ManyToOne
	private Produit produit;
	
	public LigneFacture() {}

	public LigneFacture(Produit p, int qte) 
	{
		this.produit = p;
		this.qte = qte;
		this.prix = p.getPrix() * qte;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Facture getFacture() {
		return facture;
	}

// M�thode permettant d'initialiser la cl� �trang�re facture_id dans la table LigneFacture	
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}
