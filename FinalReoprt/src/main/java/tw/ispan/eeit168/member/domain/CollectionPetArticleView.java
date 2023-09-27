package tw.ispan.eeit168.member.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "collection_pet_article ")
@IdClass(CollectionPetArticleView.CollectionPetArticleId.class)
public class CollectionPetArticleView implements Serializable{
	
//	@Id
//	@Column(name = "id")
//	private Integer id;
	@Id
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	@Id
	@Column(name = "id")
	private Integer articleId;
	
	@Column(name = "uid", columnDefinition = "varchar")
	private String uid;
	
	@Column(name = "title",columnDefinition = "nvarchar")
	private String title;
	
	@Column(name = "pet_article_text",columnDefinition = "nvarchar")
	private String petArticleText;
	
	@Column(name = "type",columnDefinition = "nvarchar")
	private String type;
	
	@Column(name = "lasttime",columnDefinition = "datetime")
	private Timestamp lastTime;
	
	@Column(name = "like_count")
	private Integer likeCount;
	
	@Column(name = "unlike_count")
	private Integer unlikeCount;
	
	@Column(name = "create_at",columnDefinition = "datetime")
	private Timestamp createAt;

	
	
	public Integer getFkMemberId() {
		return fkMemberId;
	}



	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}



	public Integer getArticleId() {
		return articleId;
	}



	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPetArticleText() {
		return petArticleText;
	}



	public void setPetArticleText(String petArticleText) {
		this.petArticleText = petArticleText;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Timestamp getLastTime() {
		return lastTime;
	}



	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}



	public Integer getLikeCount() {
		return likeCount;
	}



	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}



	public Integer getUnlikeCount() {
		return unlikeCount;
	}



	public void setUnlikeCount(Integer unlikeCount) {
		this.unlikeCount = unlikeCount;
	}



	public Timestamp getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}



	@Override
	public String toString() {
		return "CollectionPetArticleView [fkMemberId=" + fkMemberId + ", articleId=" + articleId + ", uid=" + uid
				+ ", title=" + title + ", petArticleText=" + petArticleText + ", type=" + type + ", lastTime="
				+ lastTime + ", likeCount=" + likeCount + ", unlikeCount=" + unlikeCount + ", createAt=" + createAt
				+ "]";
	}



	public static class CollectionPetArticleId implements Serializable {
		private Integer fkMemberId;
		private Integer articleId;
		public Integer getFkMemberId() {
			return fkMemberId;
		}
		public void setFkMemberId(Integer fkMemberId) {
			this.fkMemberId = fkMemberId;
		}
		public Integer getArticleId() {
			return articleId;
		}
		public void setArticleId(Integer articleId) {
			this.articleId = articleId;
		}
		@Override
		public int hashCode() {
			return Objects.hash(articleId, fkMemberId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CollectionPetArticleId other = (CollectionPetArticleId) obj;
			return Objects.equals(articleId, other.articleId) && Objects.equals(fkMemberId, other.fkMemberId);
		}
		
		
	}
	
	

	
}
