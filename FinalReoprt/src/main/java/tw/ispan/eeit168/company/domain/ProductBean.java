package tw.ispan.eeit168.company.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBean {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "fk_company_id")
	private Integer fkCompanyId;
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	@Column(name = "uid")
	private String uid;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "inventory")
	private Integer inventory;
	@Column(name = "price")
	private Integer price;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "create_at")
	private Timestamp createAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFkCompanyId() {
		return fkCompanyId;
	}
	public void setFkCompanyId(Integer fkCompanyId) {
		this.fkCompanyId = fkCompanyId;
	}
	public Integer getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", fkCompanyId=" + fkCompanyId + ", fkMemberId=" + fkMemberId + ", uid=" + uid
				+ ", name=" + name + ", type=" + type + ", inventory=" + inventory + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", createAt=" + createAt + "]"+"\n";
	}


}
