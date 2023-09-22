package tw.ispan.eeit168.member.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class MemberBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "account", columnDefinition = "varchar")
	private String account;
	
	@Column(name = "password", columnDefinition = "varchar")
	private String password;
	
	@Column(name = "first_name", columnDefinition = "nvarchar")
	private String first_name;
	
	@Column(name = "last_name", columnDefinition = "nvarchar")
	private String last_name;
	
	@Column(name = "user_name", columnDefinition = "nvarchar")
	private String user_name;
	
	@Column(name = "shop_name", columnDefinition = "nvarchar")
	private String shop_name;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "birth", columnDefinition = "date")
	private Timestamp birth;
	
	@Column(name = "phone", columnDefinition = "varchar")	
	private String phone;
	
	@Column(name = "address", columnDefinition = "nvarchar")
	private String address;
	
	@Column(name = "email", columnDefinition = "varchar")
	private String email;
	
	@Column(name = "cash")
	private Integer cash;
	
	@Column(name = "bonus")
	private Integer bonus;
	
	@Column(name = "create_at", columnDefinition = "datetime")
	private Timestamp create_at;
	
	@Column(name = "update_at", columnDefinition = "datetime")
	private Timestamp update_at;
	
	@Column(name = "img")
	private String img;

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", account=" + account + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", user_name=" + user_name + ", shop_name=" + shop_name + ", gender="
				+ gender + ", birth=" + birth + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", cash=" + cash + ", bonus=" + bonus + ", create_at=" + create_at + ", update_at=" + update_at
				+ ", img=" + img + "]";
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
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

	public Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}
