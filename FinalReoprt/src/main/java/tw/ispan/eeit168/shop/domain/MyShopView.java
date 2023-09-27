package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="my_shop")
public class MyShopView {

	@Id
	@Column(name="id")
	
	private Integer pId;
	
	@Column(name="name")
	private String pName;
	
	@Column(name="price")
	private Integer pPrice;
	
	@Column(name="description")
	private String pDescription;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="create_at", insertable = false, updatable = false)
	private Timestamp pCreateAt;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpPrice() {
		return pPrice;
	}

	public void setpPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Timestamp getpCreateAt() {
		return pCreateAt;
	}

	public void setpCreateAt(Timestamp pCreateAt) {
		this.pCreateAt = pCreateAt;
	}

	@Override
	public String toString() {
		return "MyShopView [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pDescription=" + pDescription
				+ ", shopName=" + shopName + ", pCreateAt=" + pCreateAt + "]";
	}

	
	
}
