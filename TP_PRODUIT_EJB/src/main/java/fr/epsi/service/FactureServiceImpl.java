package fr.epsi.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.epsi.dao.FactureDao;
import fr.epsi.dao.FactureDaoImpl;
import fr.epsi.dto.FactureDTO;
import fr.epsi.entity.Facture;

@Stateless
public class FactureServiceImpl implements FactureService {

	@EJB
	FactureDao dao = new FactureDaoImpl();
	
	public List<Facture> getListeFacture()
	{		
		return dao.getListeFacture();
	}
	
	public List<FactureDTO> getListeFactureDTO()
	{
		List<FactureDTO> fListDTO = new ArrayList<FactureDTO>();
		for (Facture f : dao.getListeFacture()) 
		{
			FactureDTO fDTO = new FactureDTO(f);
			fListDTO.add(fDTO);
		}
		return fListDTO;
	}
}
