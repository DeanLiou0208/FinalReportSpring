package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentsBean {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Integer id;
@Column(name = "fk_member_id")
private Integer fkMemberId;
@Column(name = "fk_pet_article_id")
private Integer fkPetArticleId;
@Column(name = "comments_text", columnDefinition = "nvarchar" )
private String commentsText;
@Column(name = "create_at", columnDefinition = "datetime",insertable = false )
private Timestamp createAt;



@Override
public String toString() {
	return "CommentsBean [id=" + id + ", fkMemberId=" + fkMemberId + ", fkPetArticleId=" + fkPetArticleId
			+ ", commentsText=" + commentsText + ", createAt=" + createAt + "]";
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


}