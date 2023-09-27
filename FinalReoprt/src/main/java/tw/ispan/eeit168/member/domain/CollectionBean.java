package tw.ispan.eeit168.member.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@IdClass(CollectionBean.ConfigId.class)
@Entity
@Table(name = "collection")
public class CollectionBean implements Serializable {
	@Id
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	
	@Id
	@Column(name = "fk_uid")
	private String fkUid;

	@Column(name = "create_at", columnDefinition = "datetime", insertable = false, updatable = false)
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "CollectionBean [fkMemberId=" + fkMemberId + ", fkUid=" + fkUid + ", createAt=" + createAt + "]";
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public String getFkUid() {
		return fkUid;
	}

	public void setFkUid(String fkUid) {
		this.fkUid = fkUid;
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
    	private String fkUid;
    	
		public Integer getFkMemberId() {
			return fkMemberId;
		}
		public void setFkMemberId(Integer fkMemberId) {
			this.fkMemberId = fkMemberId;
		}
		public String getFkUid() {
			return fkUid;
		}
		public void setFkUid(String fkUid) {
			this.fkUid = fkUid;
		}
    	
    }
}
