package tw.ispan.eeit168.company.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_photo")
public class ProductPhotoBean {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "fk_product_id")
	private Integer fkProductId;
	@Column(name = "main")
	private Boolean main;
	@Column(name = "img")
	private String img;
	@Column(name = "create_at")
	private Timestamp createAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFkProductId() {
		return fkProductId;
	}
	public void setFkProductId(Integer fkProductId) {
		this.fkProductId = fkProductId;
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
	@Override
	public String toString() {
		return "ProductPhotoBean [id=" + id + ", fkProductId=" + fkProductId + ", main=" + main + ", img=" + img
				+ ", createAt=" + createAt + "]"+"\n";
	}

	
}
