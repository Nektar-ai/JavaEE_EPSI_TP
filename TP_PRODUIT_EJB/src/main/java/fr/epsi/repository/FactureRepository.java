package fr.epsi.repository;

import java.util.List;

import fr.epsi.entity.Facture;
import fr.epsi.entity.LigneFacture;

public interface FactureRepository 
{
	public List<Facture> getListeFacture();
	public Facture getFactureByNum(String n);
	public List<LigneFacture> getLigneFactureByFacId(Long id);
	public void create(Facture f);
}
