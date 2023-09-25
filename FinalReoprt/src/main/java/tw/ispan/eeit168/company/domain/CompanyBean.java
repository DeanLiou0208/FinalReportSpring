package tw.ispan.eeit168.company.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "company")
public class CompanyBean {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "account",updatable = false)
	private String account;
	@Column(name = "password")
	private String password;
	@Column(name = "shop_name",updatable = false)
	private String shopName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "tax_id_number")
	private Integer taxIdNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "create_at" ,insertable = false, updatable = false)
	private Timestamp createAt;
	@Column(name = "update_at",insertable = false)
	private Timestamp updateAt;
	@Column(name = "img")
	private String img;
	
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getTaxIdNumber() {
		return taxIdNumber;
	}
	public void setTaxIdNumber(Integer taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
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
	@Override
	public String toString() {
		return "CompanyBean [id=" + id + ", account=" + account + ", password=" + password + ", shopName=" + shopName
				+ ", phone=" + phone + ", taxIdNumber=" + taxIdNumber + ", address=" + address + ", email=" + email
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + ", img=" + img + "]"+"\n";
	}


}
