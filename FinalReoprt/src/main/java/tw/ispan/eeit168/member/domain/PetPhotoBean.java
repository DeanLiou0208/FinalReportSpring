package tw.ispan.eeit168.member.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_photo")
public class PetPhotoBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_pet_id")
	private Integer fkPetId;
	
	@Column(name = "main")
	private Boolean main;
	
	@Column(name = "img", columnDefinition = "nvarchar")
	private String img;
	
	@Column(name = "create_at", columnDefinition = "datetime")
	private Timestamp createAt;

	@Override
	public String toString() {
		return "PetPhotoBean [id=" + id + ", fkPetId=" + fkPetId + ", main=" + main + ", img=" + img + ", createAt="
				+ createAt + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkPetId() {
		return fkPetId;
	}

	public void setFkPetId(Integer fkPetId) {
		this.fkPetId = fkPetId;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
}
