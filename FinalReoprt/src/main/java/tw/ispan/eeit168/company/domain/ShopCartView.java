package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_cart")
public class ShopCartView {
	@Id
	@Column(name = "id")
	 private Integer id;
	@Column(name = "product_id")
	 private Integer productId;
	@Column(name = "uid")
	 private String uid;
	@Column(name = "fk_member_id")
	 private Integer fkMemberId;
	@Column(name = "count")
	 private Integer count;
	@Column(name = "name")
	 private String name;
	@Column(name = "price")
	 private Integer price;
	@Column(name = "type")
	 private String type;
	@Column(name = "description")
	 private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ShopCartView [id=" + id + ", productId=" + productId + ", uid=" + uid + ", fkMemberId=" + fkMemberId
				+ ", count=" + count + ", name=" + name + ", price=" + price + ", type=" + type + ", description="
				+ description + "]"+"\n";
	}
	
	 
}
