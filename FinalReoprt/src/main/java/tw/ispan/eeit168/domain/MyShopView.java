package tw.ispan.eeit168.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="my_shop")
public class MyShopView {

	@Id
	@Column(name="p.id")
	private int pId;
	
	@Column(name="p.name")
	private String pName;
	
	@Column(name="p.price")
	private double pPrice;
	
	@Column(name="p.description")
	private String pDescription;
	
	@Column(name="c.shop_name")
	private String shopName;
	
	@Column(name="p.create_at")
	private Timestamp pCreateAt;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
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
		return "myShopView [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pDescription=" + pDescription
				+ ", shopName=" + shopName + ", pCreateAt=" + pCreateAt + "]";
	}	
}
