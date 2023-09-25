package tw.ispan.eeit168.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_pet_photo")
public class MyPetView {
	@Id
	@Column(name = "pet_id")
	private Integer petId;
	
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	
	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "species", columnDefinition = "nvarchar")
	private String species;
	
	@Column(name = "breed", columnDefinition = "nvarchar")
	private String breed;

	@Override
	public String toString() {
		return "MyPetView [petId=" + petId + ", fkMemberId=" + fkMemberId + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", species=" + species + ", breed=" + breed + "]";
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
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
