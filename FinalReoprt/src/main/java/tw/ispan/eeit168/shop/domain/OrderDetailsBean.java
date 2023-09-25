package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetailsBean {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="fk_order_id")
	private Integer fkOrderId;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="quantity")
	private Integer  quantity;
	
	@Column(name="state")
	private String state;
	
	@Column(name="state_change_time")
	private Timestamp stateChangeTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(Integer fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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
		return "OrderDetailsBean [id=" + id + ", fkOrderId=" + fkOrderId + ", shopName=" + shopName + ", productId="
				+ productId + ", quantity=" + quantity + ", state=" + state + ", stateChangeTime=" + stateChangeTime
				+ "]";
	}
	
}
