package dynamix_services.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="T_CAISSIERS")
public class caissier implements Serializable {
	public caissier()  {
	
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="CAISSIERS_ID")
private int id ;
	@Column(name="CAISSIERS_EMAIL")
private String email ;
	@Column(name="CAISSIERS_PASSWORD")
private String mdp ;
	
	
}
