package tw.ispan.eeit168.shop.domain;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_analysis")
public class ProductAnalysisView {
	
	@Id
	@Column(name="order_details_id")
	private Integer id;
	
	@Column(name="company_id")
	private Integer companyId;
	
	@Column(name="shop_name")
	private String shopName;

	@Column(name="order_list_id")
	private Integer orderListId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	
	
	@Column(name="state")
	private String state;
	
	@Column(name="state_change_time", insertable = false)
	private Timestamp stateChangeTime;
	
	@Column(name="gender")
	private Boolean gender;
	
	@Column(name="birth")
	private Date birth;
	
	@Column(name="member_id")
	private Integer member_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Integer  price;
	
	@Column(name="product_id")
	private Integer productId;
	
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	public Timestamp getStateChangeTime() {
		return stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
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

	@Override
	public String toString() {
		return "ProductAnalysisView [id=" + id + ", companyId=" + companyId + ", shopName=" + shopName
				+ ", orderListId=" + orderListId + ", quantity=" + quantity + ", state=" + state + ", stateChangeTime="
				+ stateChangeTime + ", gender=" + gender + ", birth=" + birth + ", member_id=" + member_id + ", name="
				+ name + ", price=" + price + ", productId=" + productId + "]";
	}

}
