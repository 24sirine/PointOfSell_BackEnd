package dynamix_services.entities;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Embeddable
public class AssocCommande_article_PK 	implements Serializable {
	
		private static final long serialVersionUID = 1L;
		private String code;
		private int id_commande;
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private int id_Ass;
		
	    private static int lastId = 0;
		public AssocCommande_article_PK(String code, int id_commande) {
		this.code=code;
		this.id_commande=id_commande;
		this.id_Ass= lastId++;
		}
		public AssocCommande_article_PK() {
			// TODO Auto-generated constructor stub
		}
		public int getId_commande() {
			return id_commande;
		}
		public void setId_commande(int id_commande) {
			this.id_commande = id_commande;
		}
		public int getId_Ass() {
			return id_Ass;
		}
		public void setId_Ass(int id_Ass) {
			this.id_Ass = id_Ass;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
}
