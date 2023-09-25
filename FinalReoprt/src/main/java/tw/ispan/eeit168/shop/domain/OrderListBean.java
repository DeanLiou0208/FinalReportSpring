package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_list")
public class OrderListBean {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="fk_member_id")
	private Integer fkMemberId;
	
	@Column(name="total_price")
	private Integer totalPrice;
	
	@Column(name="bonus")
	private Integer bonus;
	
	@Column(name="create_at")
	private Timestamp createAt;

	public Integer getId() {
		return id;
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderListBean [id=" + id + ", fkMemberId=" + fkMemberId + ", totalPrice=" + totalPrice + ", bonus="
				+ bonus + ", createAt=" + createAt + "]";
	}
	
}
