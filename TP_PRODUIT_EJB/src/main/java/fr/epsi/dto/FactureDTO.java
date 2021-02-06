package fr.epsi.dto;

import java.util.Date;
import java.util.List;
import fr.epsi.entity.Facture;
import fr.epsi.entity.LigneFacture;

public class FactureDTO {

	private Long id;
	private Date date;
	private String numero;
	private double prix;
	private ClientDTO client;
	private List<LigneFacture> lignefacture;

	public FactureDTO( ) {}
	
	public FactureDTO (Facture f) 
	{
		id = f.getId();
		date = f.getDate();
		numero = f.getNumero();
		prix = f.getPrix();		
		client = new ClientDTO(f.getClient());
		lignefacture = f.getLignesFacture();
	}
	
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public List<LigneFacture> getLignefacture() {
		return lignefacture;
	}

	public void setLignefacture(List<LigneFacture> lignefacture) {
		this.lignefacture = lignefacture;
	}	
}
