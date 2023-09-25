package tw.ispan.eeit168.forum.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article_species_mid")
public class PetArticleSpeciesMidBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_pet_article_id")
	private Integer fkPetArticleId;
	
	@Column(name = "fk_pet_article_species_id")
	private Integer fkPetArticleSpeciesId;

	@Override
	public String toString() {
		return "PetArticleSpeciesMidBean [id=" + id + ", fkPetArticleId=" + fkPetArticleId + ", fkPetArticleSpeciesId="
				+ fkPetArticleSpeciesId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkPetArticleId() {
		return fkPetArticleId;
	}

	public void setFkPetArticleId(Integer fkPetArticleId) {
		this.fkPetArticleId = fkPetArticleId;
	}

	public Integer getFkPetArticleSpeciesId() {
		return fkPetArticleSpeciesId;
	}

	public void setFkPetArticleSpeciesId(Integer fkPetArticleSpeciesId) {
		this.fkPetArticleSpeciesId = fkPetArticleSpeciesId;
	}
	
	

}
