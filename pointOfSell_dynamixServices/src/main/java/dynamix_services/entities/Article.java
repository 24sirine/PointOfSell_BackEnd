package dynamix_services.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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
@Table(name="T_Article")
public class Article implements Serializable{
	public Article() {
		
	}
	private static final long serialVersionUID = 1L;
	@Column(name="ARTICLE_CODE")
	@Id
	String code ;
	@Column(name="ARTICLE_PRIX_UNITAIRE") 
	float prixUnitaire;
	@Column(name="ARTICLE_LIBELLE")
	String libelle;
	@Column(name="ARTICLE_URLIMG")
	String urlPhoto;
	@Column(name="ARTICLE_DESCRIPTION")
	String description;
	@Column(name="ARTICLE_REMISE")
	float Remise ; 
	@Column(name="ARTICLE_QTE_STOCK")
	int qteStock;
	//une association avec la classe ligneCommande : un article peut etre associé à une ou plusieurs lignes
		// one to many
	@JsonManagedReference(value="article-relation")
	@OneToMany(mappedBy = "etArticle")
	private List<LigCom> art;
}
