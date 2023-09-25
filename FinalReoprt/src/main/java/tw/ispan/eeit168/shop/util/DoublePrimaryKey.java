package tw.ispan.eeit168.shop.util;

import java.io.Serializable;
import java.util.Objects;

public class DoublePrimaryKey implements Serializable{
		
	private Integer fkMemberId;
	private Integer fkPetArticleId;
	@Override
	public int hashCode() {
		return Objects.hash(fkMemberId, fkPetArticleId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoublePrimaryKey other = (DoublePrimaryKey) obj;
		return Objects.equals(fkMemberId, other.fkMemberId) && Objects.equals(fkPetArticleId, other.fkPetArticleId);
	}

	
}
