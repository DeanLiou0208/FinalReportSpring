package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rate")
public class RateBean {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="fk_member_id")
	private Integer fkMemberId;
	
	@Column(name="fk_product_id")
	private Integer fkProductId;
	
	@Column(name="fk_order_id")
	private Integer fkOrderId;
	
	@Column(name="rate_score")
	private Integer rateScore;
	
	@Column(name="rate_comment")
	private String rateComment;
	
	@Column(name="created_at")
	private Timestamp createdAt;

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

	public Integer getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(Integer fkProductId) {
		this.fkProductId = fkProductId;
	}

	public Integer getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(Integer fkOrderId) {
		this.fkOrderId = fkOrderId;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "RateBean [id=" + id + ", fkMemberId=" + fkMemberId + ", fkProductId=" + fkProductId + ", fkOrderId="
				+ fkOrderId + ", rateScore=" + rateScore + ", rateComment=" + rateComment + ", createdAt=" + createdAt
				+ "]";
	}
}
