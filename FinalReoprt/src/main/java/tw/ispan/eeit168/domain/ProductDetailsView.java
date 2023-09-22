package tw.ispan.eeit168.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetailsView {
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "uid")
	private String uid;
	@Column(name = "company_shop_name")
	private String companyShopName;
	@Column(name = "member_shop_name")
	private String memberShopName;
	@Column(name = "price")
	private Integer price;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "inventory")
	private Integer inventory;
	@Column(name = "description")
	private String description;
	
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
	public String getCompanyShopName() {
		return companyShopName;
	}
	public void setCompanyShopName(String companyShopName) {
		this.companyShopName = companyShopName;
	}
	public String getMemberShopName() {
		return memberShopName;
	}
	public void setMemberShopName(String memberShopName) {
		this.memberShopName = memberShopName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ProductDetailsView [productId=" + productId + ", uid=" + uid + ", companyShopName=" + companyShopName
				+ ", memberShopName=" + memberShopName + ", price=" + price + ", name=" + name + ", type=" + type
				+ ", inventory=" + inventory + ", description=" + description + ", getProductId()=" + getProductId()
				+ ", getUid()=" + getUid() + ", getCompanyShopName()=" + getCompanyShopName() + ", getMemberShopName()="
				+ getMemberShopName() + ", getPrice()=" + getPrice() + ", getName()=" + getName() + ", getType()="
				+ getType() + ", getInventory()=" + getInventory() + ", getDescription()=" + getDescription()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]"+"\n";
	}

	
}
