package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.IndexProductsPhotoView;

@Repository
public class IndexProductsPhotoDAOHibernate implements IndexProductsPhotoDAO{
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public IndexProductsPhotoView select(Integer id) {
		if(id != null) {
			return this.getSession().get(IndexProductsPhotoView.class, id);
		}
		return null;
	}
	
	@Override
	public List<IndexProductsPhotoView> select() {
		return this.getSession().createQuery(
				"from IndexProductsPhotoView", IndexProductsPhotoView.class).list();
	}
	@Override
	public List<IndexProductsPhotoView> selectTopFive(){
		String srt = "FROM IndexProductsPhotoView ORDER BY avgRateScore desc";
		return this.getSession()
					.createQuery(srt, IndexProductsPhotoView.class)
					.setMaxResults(5)
					.list();
	}
}
