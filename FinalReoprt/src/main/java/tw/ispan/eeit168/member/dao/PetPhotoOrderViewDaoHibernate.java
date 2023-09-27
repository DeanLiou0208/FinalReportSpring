package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;

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
	@Override
	public PetPhotoOrderView selectById(Integer id) {
		if(id != null ) {
			return this.getSession().get(PetPhotoOrderView.class, id);	
		}
		return null;
	}
	
}
