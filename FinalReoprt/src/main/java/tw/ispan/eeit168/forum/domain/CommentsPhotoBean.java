package tw.ispan.eeit168.forum.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments_photo")
public class CommentsPhotoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "fk_comments_id")
	private Integer fkCommentsId;
	@Column(name = "img",columnDefinition = "varchar")
	private String img;
	@Column(name = "create_at",columnDefinition = "datetime",insertable = false)
	private Timestamp createAt;
	
	@Override
	public String toString() {
		return "CommentsPhotoBean [id=" + id + ", fkCommentsId=" + fkCommentsId + ", img=" + img + ", createAt="
				+ createAt + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkCommentsId() {
		return fkCommentsId;
	}

	public void setFkCommentsId(Integer fkCommentsId) {
		this.fkCommentsId = fkCommentsId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
	
	
	
	
	
	
	
}
