package tw.ispan.eeit168.forum.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article_species")
public class PetArticleSpeciesBean {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "species", columnDefinition = "nvarchar")
	private String species;
	
	@Override
	public String toString() {
		return "PetArticleSpeciesBean [id=" + id + ", species=" + species + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	

}
