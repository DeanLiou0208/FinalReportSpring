package tw.ispan.eeit168.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_categroy")
public class PetCategroyBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "species", columnDefinition = "nvarchar")
	private String species;
	
	@Column(name = "breed", columnDefinition = "nvarchar")
	private String breed;

	@Override
	public String toString() {
		return "PetCategroyBean [id=" + id + ", species=" + species + ", breed=" + breed + "]";
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
