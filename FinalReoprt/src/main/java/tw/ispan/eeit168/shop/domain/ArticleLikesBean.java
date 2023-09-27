package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

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
@IdClass(DoublePrimaryKey.class)
public class ArticleLikesBean {
	
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
}
