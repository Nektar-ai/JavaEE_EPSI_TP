package fr.epsi.service;

import java.util.List;

import fr.epsi.dto.FactureDTO;
import fr.epsi.entity.Facture;
import fr.epsi.entity.LigneFacture;

public interface FactureService 
{
	public List<Facture> getListeFacture();
	public List<FactureDTO> getListeFactureDTO();
	public Facture getFactureByNum(String n);
	public Facture getDummyFacture();
	public List<LigneFacture> getLigneFactureByFacId(Long id);
	public void setListeLigneFacture(Facture f, List<LigneFacture> lFList);
	public void create (FactureDTO f);
}
