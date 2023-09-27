package tw.ispan.eeit168.member.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class PetBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	
	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
	
	@Column(name = "categroy_id")
	private Integer categroyId;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "create_at", columnDefinition = "datetime", insertable = false, updatable = false)
	private Timestamp createAt;

	@Override
	public String toString() {
		return "PetBean [id=" + id + ", fkMemberId=" + fkMemberId + ", name=" + name + ", categroyId=" + categroyId
				+ ", age=" + age + ", gender=" + gender + ", createAt=" + createAt + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategroyId() {
		return categroyId;
	}

	public void setCategroyId(Integer categroyId) {
		this.categroyId = categroyId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

}
