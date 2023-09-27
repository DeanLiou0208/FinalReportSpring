package tw.ispan.eeit168.forum.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "collection_product")
@IdClass(CollectionProductView.CollectionProductId.class)
public class CollectionProductView implements Serializable {
	
	@Id
	@Column(name = "fk_member_id")
	private Integer fkMemberId;
	@Id
	@Column(name = "product_id")
	private Integer productId;
	
	
	@Column(name = "fk_uid", columnDefinition = "varchar")
	private String fkUid;

	
	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;

	@Column(name = "price")
	private Integer price;
	
	@Column(name = "description", columnDefinition = "nvarchar")
	private String description;
	
	@Column(name = "status")
	private Boolean status;

	@Override
	public String toString() {
		return "CollectionProductView [productId=" + productId + ", fkMemberId=" + fkMemberId + ", fkUid=" + fkUid
				+ ", name=" + name + ", price=" + price + ", description=" + description + ", status=" + status + "]";
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getFkMemberId() {
		return fkMemberId;
	}

	public void setFkMemberId(Integer fkMemberId) {
		this.fkMemberId = fkMemberId;
	}

	public String getFkUid() {
		return fkUid;
	}

	public void setFkUid(String fkUid) {
		this.fkUid = fkUid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public static class CollectionProductId implements Serializable {
		private Integer fkMemberId;
		private Integer productId;
		public Integer getFkMemberId() {
			return fkMemberId;
		}
		public void setFkMemberId(Integer fkMemberId) {
			this.fkMemberId = fkMemberId;
		}
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		@Override
		public int hashCode() {
			return Objects.hash(fkMemberId, productId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CollectionProductId other = (CollectionProductId) obj;
			return Objects.equals(fkMemberId, other.fkMemberId) && Objects.equals(productId, other.productId);
		}
		
		
	}
	


	
}
