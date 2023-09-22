package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_type_mid")
public class ProductTypeMidBean {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "fk_product_id")
	private Integer fkProductId;
	@Column(name = "fk_type_id")
	private Integer fkTypeId;
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
	public Integer getFkTypeId() {
		return fkTypeId;
	}
	public void setFkTypeId(Integer fkTypeId) {
		this.fkTypeId = fkTypeId;
	}
	@Override
	public String toString() {
		return "ProductTypeMidBean [id=" + id + ", fkProductId=" + fkProductId + ", fkTypeId=" + fkTypeId + "]"+"\n";
	}
	
	
}
