package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.MyPetView;

@Repository
public class MyPetDAOHibernate implements MyPetDAO{
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public MyPetView select(Integer id) {
		if(id != null) {
			return this.getSession().get(MyPetView.class, id);
		}
		return null;
	}
	
	@Override
	public List<MyPetView> select() {
		return this.getSession().createQuery(
				"from MyPetView", MyPetView.class).list();
	}
}
