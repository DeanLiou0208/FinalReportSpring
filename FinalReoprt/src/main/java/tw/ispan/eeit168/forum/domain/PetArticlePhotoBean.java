package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article_photo")
public class PetArticlePhotoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_pet_article_id")
	private Integer fkPetArticleId;
	
	@Column(name = "main")
	private Boolean main;
	
	@Column(name = "img",columnDefinition = "varchar")
	private String img;
	
	@Column(name = "create_at",columnDefinition = "datetime")
	private Timestamp createAt;

	@Override
	public String toString() {
		return "PetArticlePhotoBean [id=" + id + ", fkPetArticleId=" + fkPetArticleId + ", main=" + main + ", img="
				+ img + ", createAt=" + createAt + "]";
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
