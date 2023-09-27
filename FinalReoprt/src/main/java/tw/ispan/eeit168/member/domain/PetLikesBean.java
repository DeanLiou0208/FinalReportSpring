package tw.ispan.eeit168.member.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@IdClass(PetLikesBean.ConfigId.class)
@Entity
@Table(name = "pet_likes")
public class PetLikesBean implements Serializable {
	@Id
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	
	@Id
	@Column(name = "fk_pet_id")
	private Integer fkPetId;
	
	@Column(name = "create_at", columnDefinition = "datetime", insertable = false, updatable = false)
	private Timestamp createAt;

	@Override
	public String toString() {
		return "PetLikesBean [fkMemberId=" + fkMemberId + ", fkPetId=" + fkPetId + ", createAt=" + createAt + "]";
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public Integer getFkPetId() {
		return fkPetId;
	}

	public void setFkPetId(Integer fkPetId) {
		this.fkPetId = fkPetId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}


	public static class ConfigId implements Serializable {
	        private static final long serialVersionUID = 1L;

	        private Integer fkMemberId;
	        private Integer fkPetId;
			public Integer getFkMemberId() {
				return fkMemberId;
			}
			public void setFkMemberId(Integer fkMemberId) {
				this.fkMemberId = fkMemberId;
			}
			public Integer getFkPetId() {
				return fkPetId;
			}
			public void setFkPetId(Integer fkPetId) {
				this.fkPetId = fkPetId;
			}

	}
	
}
