package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="order_details")
public class OrderDetailsBean {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fk_order_id")
	private int fkOrderId;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="quantity")
	private int  quantity;
	
	@Column(name="state")
	private String state;
	
	@Column(name="state_change_time")
	private Timestamp stateChangeTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(int fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getStateChangeTime() {
		return stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	@Override
	public String toString() {
		return "OrderListBean [id=" + id + ", fkOrderId=" + fkOrderId + ", shopName=" + shopName + ", productId="
				+ productId + ", quantity=" + quantity + ", state=" + state + ", stateChangeTime=" + stateChangeTime
				+ "]";
	} 

	
		
}
