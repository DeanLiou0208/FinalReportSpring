package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "species_views")
public class SpeciesViewsView {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "fk_pet_article_id")
	private Integer fkPetArticleId;
	@Column(name = "fk_pet_article_species_id")
	private Integer fkPetArticleSpeciesId;
	@Column(name = "species")
	private String species;
	public Integer getId() {
		return id;
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
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SpeciesViewsView [id=" + id + ", fkPetArticleId=" + fkPetArticleId + ", fkPetArticleSpeciesId="
				+ fkPetArticleSpeciesId + ", species=" + species + "]"+"\n";
	}
	
	
}
