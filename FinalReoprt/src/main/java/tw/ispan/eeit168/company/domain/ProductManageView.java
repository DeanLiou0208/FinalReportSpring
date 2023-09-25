package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_manage")
public class ProductManageView {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "typename")
	private String typename;
	@Column(name = "value")
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ProductManage [id=" + id + ", typename=" + typename + ", value=" + value + ", getId()=" + getId()
				+ ", getTypename()=" + getTypename() + ", getValue()=" + getValue() +  "]"+"\n";
	}

}
