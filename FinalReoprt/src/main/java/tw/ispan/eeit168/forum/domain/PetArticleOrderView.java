package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pet_article_order")
public class PetArticleOrderView {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="fk_member_id")
	private Integer fkMemberId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="type")
	private String type;
	
	@Column(name="pet_article_text")
	private String petArticleText;
	
	@Column(name="like_count")
	private Integer likeCount;
	
	@Column(name="unlike_count")
	private Integer unLikeCount;
	
	@Column(name="create_at", insertable = false)
	private Timestamp createAt;
	
	@Column(name="img")
	private String img;
	
	@Column(name="main")
	private Boolean main;

	@Override
	public String toString() {
		return "PetArticleOrderView [id=" + id + ", fkMemberId=" + fkMemberId + ", title=" + title + ", type=" + type
				+ ", petArticleText=" + petArticleText + ", likeCount=" + likeCount + ", unLikeCount=" + unLikeCount
				+ ", createAt=" + createAt + ", img=" + img + ", main=" + main + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPetArticleText() {
		return petArticleText;
	}

	public void setPetArticleText(String petArticleText) {
		this.petArticleText = petArticleText;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getUnLikeCount() {
		return unLikeCount;
	}

	public void setUnLikeCount(Integer unLikeCount) {
		this.unLikeCount = unLikeCount;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}
	
	
	
	}