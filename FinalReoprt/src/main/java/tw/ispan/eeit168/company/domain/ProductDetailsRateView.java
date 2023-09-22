package tw.ispan.eeit168.company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details_rate")
public class ProductDetailsRateView {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "fk_product_id")
	private Integer fkProductId;
	@Column(name = "rate_score")
	private Integer rateScore;
	@Column(name = "rate_comment")
	private String rateComment;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getFkProductId() {
		return fkProductId;
	}
	public void setFkProductId(Integer fkProductId) {
		this.fkProductId = fkProductId;
	}
	public Integer getRateScore() {
		return rateScore;
	}
	public void setRateScore(Integer rateScore) {
		this.rateScore = rateScore;
	}
	public String getRateComment() {
		return rateComment;
	}
	public void setRateComment(String rateComment) {
		this.rateComment = rateComment;
	}
	@Override
	public String toString() {
		return "ProductDetailsRateView [id=" + id + ", userName=" + userName + ", fkProductId=" + fkProductId
				+ ", rateScore=" + rateScore + ", rateComment=" + rateComment + ", getId()=" + getId()
				+ ", getUserName()=" + getUserName() + ", getFkProductId()=" + getFkProductId() + ", getRateScore()="
				+ getRateScore() + ", getRateComment()=" + getRateComment() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]"+"\n";
	}
	
	
}
