package tw.ispan.eeit168.member.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class MemberBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "account", columnDefinition = "varchar", updatable = false)
	private String account;
	
	@Column(name = "password", columnDefinition = "varchar", updatable = false)
	private String password;
	
	@Column(name = "first_name", columnDefinition = "nvarchar", insertable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "nvarchar", insertable = false)
	private String lastName;
	
	@Column(name = "user_name", columnDefinition = "nvarchar", insertable = false)
	private String userName;
	
	@Column(name = "shop_name", columnDefinition = "nvarchar", insertable = false)
	private String shopName;
	
	@Column(name = "gender", insertable = false)
	private Boolean gender;
	
	@Column(name = "birth", columnDefinition = "date", insertable = false)
	private java.sql.Date birth;
	
	@Column(name = "phone", columnDefinition = "varchar", insertable = false)	
	private String phone;
	
	@Column(name = "address", columnDefinition = "nvarchar", insertable = false)
	private String address;
	
	@Column(name = "email", columnDefinition = "varchar", insertable = false)
	private String email;
	
	@Column(name = "cash", insertable = false, updatable = false)
	private Integer cash;
	
	@Column(name = "bonus", insertable = false, updatable = false)
	private Integer bonus;
	
	@Column(name = "create_at", columnDefinition = "datetime", insertable = false, updatable = false)
	private Timestamp createAt;
	
	@Column(name = "update_at", columnDefinition = "datetime", insertable = false)
	private Timestamp updateAt;
	
	@Column(name = "img")
	private String img;

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", account=" + account + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", shopName=" + shopName + ", gender=" + gender
				+ ", birth=" + birth + ", phone=" + phone + ", address=" + address + ", email=" + email + ", cash="
				+ cash + ", bonus=" + bonus + ", createAt=" + createAt + ", updateAt=" + updateAt + ", img=" + img
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public java.sql.Date getBirth() {
		return birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	
	
}
