package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_hospital")
public class HospitalBean {
	
	@Column(name = "city",columnDefinition = "nvarchar")
	private String city;
	@Column(name = "name",columnDefinition = "nvarchar")
	private String name;
	@Column(name = "address",columnDefinition = "nvarchar")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "supervisor",columnDefinition = "nvarchar")
	private String supervisor;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	@Override
	public String toString() {
		return "HospitalBean [id=" + id + ", city=" + city + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", supervisor=" + supervisor + "]";
	}

	
	
}
