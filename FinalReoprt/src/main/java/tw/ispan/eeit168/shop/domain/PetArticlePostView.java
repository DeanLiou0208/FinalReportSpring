package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pet_article_post")
public class PetArticlePostView {

	@Id
	@Column(name="id")
	private Integer petArticleId;
	
	@Column(name="uid")
	private String uid;
	
	@Column(name="type")
	private String type;
	
	@Column(name="title")
	private String title;
	
	@Column(name="pet_article_text")
	private String petArticleText;
	
	@Column(name="create_at", insertable = false, updatable = false)
	private Timestamp createAt;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="like_count")
	private Integer likeCount;
	
	@Column(name="unlike_count")
	private Integer unlike_count;
	
	@Column(name="total_comments")
	private Integer totalComments;

	
	public Integer getPetArticleId() {
		return petArticleId;
	}


	public void setPetArticleId(Integer petArticleId) {
		this.petArticleId = petArticleId;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public Timestamp getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Integer getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}


	public Integer getUnlike_count() {
		return unlike_count;
	}


	public void setUnlike_count(Integer unlike_count) {
		this.unlike_count = unlike_count;
	}


	public Integer getTotalComments() {
		return totalComments;
	}


	public void setTotalComments(Integer totalComments) {
		this.totalComments = totalComments;
	}


	@Override
	public String toString() {
		return "PetArticlePostView [petArticleId=" + petArticleId + ", uid=" + uid + ", type=" + type + ", title="
				+ title + ", petArticleText=" + petArticleText + ", createAt=" + createAt + ", userName=" + userName
				+ ", likeCount=" + likeCount + ", unlike_count=" + unlike_count + ", totalComments=" + totalComments
				+ "]";
	}	
}
