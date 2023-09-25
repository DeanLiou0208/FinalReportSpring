package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="comments_like_post")
public class CommentsLikePostView {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_pet_article_id")
	private Integer fkPetArticleId;
	
	@Column(name = "comments_text", columnDefinition = "nvarchar")
	private String commentsText;
	
	@Column(name = "create_at",columnDefinition = "datetime")
	private Timestamp createAt;
	
	@Column(name = "user_name", columnDefinition = "nvarchar")
	private String userName;
	
	@Column(name = "like_count")
	private Integer likeCount;
	
	@Column(name = "unlike_count")
	private Integer unlikeCount;

	@Override
	public String toString() {
		return "CommentsLikePostView [id=" + id + ", fkPetArticleId=" + fkPetArticleId + ", commentsText="
				+ commentsText + ", createAt=" + createAt + ", userName=" + userName + ", likeCount=" + likeCount
				+ ", unlikeCount=" + unlikeCount + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkPetArticleId() {
		return fkPetArticleId;
	}

	public void setFkPetArticleId(Integer fkPetArticleId) {
		this.fkPetArticleId = fkPetArticleId;
	}

	public String getCommentsText() {
		return commentsText;
	}

	public void setCommentsText(String commentsText) {
		this.commentsText = commentsText;
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

	public Integer getUnlikeCount() {
		return unlikeCount;
	}

	public void setUnlikeCount(Integer unlikeCount) {
		this.unlikeCount = unlikeCount;
	}
	
	
	
	


}
