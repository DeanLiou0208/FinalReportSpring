package tw.ispan.eeit168.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_order")
public class CompanyOrderView {
	@Id
	@Column(name = "order_details_id")
	private Integer orderDetailsId;
	
	@Column(name = "shop_name", columnDefinition = "nvarchar")
	private String shopName;

	@Column(name = "id")
	private Integer orderListId;
	
	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "state", columnDefinition = "nvarchar")
	private String state;

	@Column(name = "state_change_time", columnDefinition = "datetime")
	private String stateChangeTime;
	
	@Column(name = "phone", columnDefinition = "varchar")	
	private String phone;
	
	@Column(name = "account", columnDefinition = "varchar")
	private String account;
	
	@Column(name = "first_name", columnDefinition = "nvarchar")
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "nvarchar")
	private String lastName;
	
	@Column(name = "member_id")
	private Integer memberId;

	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
	
	@Column(name = "price")
	private Integer price;

	@Override
	public String toString() {
		return "CompanyOrderView [orderDetailsId=" + orderDetailsId + ", shopName=" + shopName + ", orderListId="
				+ orderListId + ", quantity=" + quantity + ", state=" + state + ", stateChangeTime=" + stateChangeTime
				+ ", phone=" + phone + ", account=" + account + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", memberId=" + memberId + ", productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}

	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getOrderListId() {
		return orderListId;
	}

	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
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

	public String getStateChangeTime() {
		return stateChangeTime;
	}

	public void setStateChangeTime(String stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
	
}
