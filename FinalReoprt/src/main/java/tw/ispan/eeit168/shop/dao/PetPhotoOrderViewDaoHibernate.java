package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.PetPhotoOrderView;

@Repository
public class PetPhotoOrderViewDaoHibernate implements PetPhotoOrderViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<PetPhotoOrderView> select(){
		return this.getSession().createQuery("from PetPhotoOrderView", PetPhotoOrderView.class).list();
	}
	
}
