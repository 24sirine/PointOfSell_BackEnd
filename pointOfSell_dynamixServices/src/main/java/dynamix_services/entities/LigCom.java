package dynamix_services.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="T_LIG_COMMANDE")
public class LigCom implements Serializable{
	private static final long serialVersionUID = 1L;
	public LigCom(){}
	
	@EmbeddedId
	 AssocCommande_article_PK assoc_PK;
	
	
	@Column(name="QUANTITE_COMMANDE")
	int qteCom ;  
	
	
	 @JsonBackReference(value="cmd-relation")
	@ManyToOne
	@JoinColumn(name = "id_commande", referencedColumnName ="COMMANDE_ID", insertable = false , updatable = false)
	private Commande etCommande;
	 @JsonBackReference(value="article-relation")
	@ManyToOne
	@JoinColumn(name = "code", referencedColumnName ="ARTICLE_CODE", insertable = false , updatable = false)
	private Article etArticle;
	
	
	
}
