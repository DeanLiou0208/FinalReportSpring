package tw.ispan.eeit168.shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_select_type")
public class ProductSelectTypeBean {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="type")
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductSelectTypeBean [id=" + id + ", type=" + type + "]";
	}
}
