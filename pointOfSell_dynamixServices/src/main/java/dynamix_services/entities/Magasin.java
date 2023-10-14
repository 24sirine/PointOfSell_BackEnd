package dynamix_services.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="T_Magasin")
public class Magasin implements Serializable{
	public Magasin() {}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CODE_MAGASIN")
    String code;
	@Column(name="NOM_MAGASIN")
    String name ;
	@Column(name="ADRESSE_MAGASIN")
    String adresse ;
	@Column(name="CODEPOSTALE_MAGASIN")
    int codePostal ;
	@Column(name="VILLE_MAGASIN")
    String ville ;
	@Column(name="CODEPAYS_MAGASIN")
    String codePays ;
	@Column(name="TEL_MAGASIN")
    String tel;
	
}
