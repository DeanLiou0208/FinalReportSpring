package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="rate")
public class RateBean {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fk_member_id")
	private int fkMemberId;
	
	@Column(name="fk_product_id")
	private int fkProductId;
	
	@Column(name="fk_order_id")
	private int fkOrderId;
	
	@Column(name="rate_score")
	private Double rateScore;
	
	@Column(name="rate_comment")
	private String rateComment;
	
	@Column(name="created_at")
	private Timestamp createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(int fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public int getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(int fkProductId) {
		this.fkProductId = fkProductId;
	}

	public int getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(int fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public Double getRateScore() {
		return rateScore;
	}

	public void setRateScore(Double rateScore) {
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
