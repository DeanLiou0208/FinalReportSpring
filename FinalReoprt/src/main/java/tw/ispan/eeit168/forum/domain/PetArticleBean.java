package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article")
public class PetArticleBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "uid", columnDefinition = "varchar",insertable = false, updatable = false)
	private String uid;
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	@Column(name = "type",columnDefinition = "nvarchar")
	private String type;
	@Column(name = "title",columnDefinition = "nvarchar")
	private String title;
	@Column(name = "pet_article_text",columnDefinition = "nvarchar")
	private String petArticleText;
	@Column(name = "create_at",columnDefinition = "datetime",insertable = false, updatable = false)
	private Timestamp createAt;
	
//	@PrePersist
//    public void generateUid() {
//        // 在插入新记录之前，生成一个随机的唯一标识符并赋值给 uid 字段
//        if (this.uid == null) {
//            this.uid = UUID.randomUUID().toString();
//        }
//	}
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
