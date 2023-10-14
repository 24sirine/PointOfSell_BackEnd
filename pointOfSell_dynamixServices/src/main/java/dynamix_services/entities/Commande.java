package dynamix_services.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="T_COMMANDE")
public class Commande implements Serializable{
	public Commande() {

	}

	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name="COMMANDE_ID")
	@Id
	int id_commande ;
	@Column(name="COMMANDE_DATE")
	@Temporal(TemporalType.DATE)
	Date datecmd ; 
	@Column(name="COMMANDE_MOYEN_PAIEMENT")
	String moyenPaiement; 
	@Column(name="COMMANDE_STAUTS") 
	String statu = "ouverte" ;	
	@Column (name="COMMANDE_PAIEMENT")
	Float paiement ;
	
	//une association bidirectionelle avec la classe client : un client peut avoir plusieurs commandes 
		//et une commande peut etre associé à un seul client //Many to one
	@ManyToOne(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	private Client clt;
	
	//une association avec la classe ligneCommande : une commande peut avoir une ou plusieurs lignes
	// et une ligne peut etre associé à une seule commande : one to many
	@JsonManagedReference(value="cmd-relation")
	@OneToMany(mappedBy = "etCommande")
	private List<LigCom> cmd;

	public void setStatu(String newStatus) {
		statu=newStatus;
		
	}
	
}
