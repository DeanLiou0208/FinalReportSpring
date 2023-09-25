package tw.ispan.eeit168.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "index_products_photo")
public class IndexProductsPhotoView {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "avg_rate_score", columnDefinition = "decimal")
	private Double avgRateScore;
	
	@Column(name = "img")
	private String img;

	@Override
	public String toString() {
		return "IndexProductsPhotoView [id=" + id + ", name=" + name + ", price=" + price + ", avgRateScore="
				+ avgRateScore + ", img=" + img + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getAvgRateScore() {
		return avgRateScore;
	}

	public void setAvgRateScore(Double avgRateScore) {
		this.avgRateScore = avgRateScore;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
