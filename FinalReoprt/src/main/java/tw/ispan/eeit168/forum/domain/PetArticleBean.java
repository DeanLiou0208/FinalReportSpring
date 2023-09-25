package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article")
public class PetArticleBean {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "uid", columnDefinition = "varchar")
	private String uid;
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	@Column(name = "type",columnDefinition = "nvarchar")
	private String type;
	@Column(name = "title",columnDefinition = "nvarchar")
	private String title;
	@Column(name = "pet_article_text",columnDefinition = "nvarchar")
	private String petArticleText;
	@Column(name = "create_at",columnDefinition = "datetime")
	private Timestamp createAt;
	@Override
	public String toString() {
		return "PetArticleBean [id=" + id + ", uid=" + uid + ", fkMemberId=" + fkMemberId + ", type=" + type
				+ ", title=" + title + ", petArticleText=" + petArticleText + ", createAt=" + createAt + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getFkMemberId() {
		return fkMemberId;
	}
	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
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
	
	
	
}
