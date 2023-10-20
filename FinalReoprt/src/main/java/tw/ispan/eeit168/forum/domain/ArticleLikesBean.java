package tw.ispan.eeit168.forum.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

@Entity
@Table(name="article_likes")
@IdClass(ArticleLikesBean.DoublePrimaryKey.class)
public class ArticleLikesBean implements Serializable {
	
	@Id
	@Column(name="fk_member_id")
	private Integer fkMemberId;
	
	@Id
	@Column(name="fk_pet_article_id")
	private Integer fkPetArticleId;	
	
	@Column(name="create_at", insertable = false, updatable = false)
	private Timestamp createAt;
	
	@Column(name="like_or_unlike")
	private Boolean likeOrUnlike;

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public Integer getFkPetArticleId() {
		return fkPetArticleId;
	}

	public void setFkPetArticleId(Integer fkPetArticleId) {
		this.fkPetArticleId = fkPetArticleId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Boolean getLikeOrUnlike() {
		return likeOrUnlike;
	}

	public void setLikeOrUnlike(Boolean likeOrUnlike) {
		this.likeOrUnlike = likeOrUnlike;
	}

	@Override
	public String toString() {
		return "ArticleLikesBean [fkMemberId=" + fkMemberId + ", fkPetArticleId=" + fkPetArticleId + ", createAt="
				+ createAt + ", likeOrUnlike=" + likeOrUnlike + "]";
	}
	public static class DoublePrimaryKey implements Serializable {
		private Integer fkMemberId;
		public Integer getFkMemberId() {
			return fkMemberId;
		}
		public void setFkMemberId(Integer fkMemberId) {
			this.fkMemberId = fkMemberId;
		}
		public Integer getFkPetArticleId() {
			return fkPetArticleId;
		}
		public void setFkPetArticleId(Integer fkPetArticleId) {
			this.fkPetArticleId = fkPetArticleId;
		}
		private Integer fkPetArticleId;
		@Override
		public int hashCode() {
			return Objects.hash(fkMemberId, fkPetArticleId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DoublePrimaryKey other = (DoublePrimaryKey) obj;
			return Objects.equals(fkMemberId, other.fkMemberId) && Objects.equals(fkPetArticleId, other.fkPetArticleId);
		}	
	}
	
}
