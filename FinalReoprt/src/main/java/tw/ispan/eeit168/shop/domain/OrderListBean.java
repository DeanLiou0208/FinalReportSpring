package tw.ispan.eeit168.shop.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="order_list")
public class OrderListBean {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fk_member_id")
	private int fkMemberId;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="bonus")
	private double bonus;
	
	@Column(name="create_at")
	private Timestamp createAt;

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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "OrderListBean [id=" + id + ", fkMemberId=" + fkMemberId + ", totalPrice=" + totalPrice + ", bonus="
				+ bonus + ", createAt=" + createAt + "]";
	}
	
	
	
}
