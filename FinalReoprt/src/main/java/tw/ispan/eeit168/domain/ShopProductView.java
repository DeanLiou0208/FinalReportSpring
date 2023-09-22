package tw.ispan.eeit168.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_product")
public class ShopProductView {
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "id")
	private Integer id;
	@Column(name = "img")
	private String img;
	@Column(name = "company_shop_name")
	private String companyShopName;
	@Column(name = "member_shop_name")
	private String memberShopName;
	@Column(name = "price")
	private Integer price;
	@Column(name = "name")
	private String name;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	@Override
	public String toString() {
		return "ShopProductView [productId=" + productId + ", id=" + id + ", img=" + img + ", companyShopName="
				+ companyShopName + ", memberShopName=" + memberShopName + ", price=" + price + ", name=" + name + "]"+"\n";
	}
	
	
}
