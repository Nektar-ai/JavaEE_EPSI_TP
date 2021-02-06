package fr.epsi.repository;

import java.util.List;

import fr.epsi.entity.Produit;

public interface ProduitRepository 
{
	void create(Produit v);
	public List<Produit> getListeProduit();
}
