package dynamix_services.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="T_CLIENT")
public class Client implements Serializable{
	public Client() {}
	public Client (int id ,String name)
	{this.id=id;
		this.name=name;}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="CLIENT_ID")
int id;
	@Column(name="CLIENT_NOM")
String name ;
	@Column(name="CLIENT_CODEPOSTAL")
int codePostal;
	@Enumerated(EnumType.STRING)
	@Column(name="CLIENT_REGION")
RegionEnum region;
	@Column(name="CLIENT_VILLE")
String ville ;
	@Column(name="CLIENT_NUMTEL")
int tel;
	@Column(name="CLIENT_EMAIL")
String mail;
	@Column(name="CLIENT_ADRESSE")
String adresse ;
	@Column(name="CLIENT_IMG")
String imgClient; 
	//une association bidirectionelle avec la classe commande : un client peut avoir plusieurs commandes 
	//et une commande peut etre associé à un seul client //one to many
	@OneToMany(cascade =CascadeType.ALL , mappedBy="clt")
	private Set<Commande> cmmd;
}
