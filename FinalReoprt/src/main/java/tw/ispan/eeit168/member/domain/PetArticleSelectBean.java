package tw.ispan.eeit168.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_article_select")
public class PetArticleSelectBean {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "type", columnDefinition = "nvarchar")
	private String type;

	@Override
	public String toString() {
		return "PetArticleSelectBean [id=" + id + ", type=" + type + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
