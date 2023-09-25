package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.CompanyOrderView;
import tw.ispan.eeit168.member.domain.MemberBean;

@Repository
public class CompanyOrderDAOHibernate implements CompanyOrderDAO {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public CompanyOrderView select(Integer id) {
		if(id != null) {
			return this.getSession().get(CompanyOrderView.class, id);
		}
		return null;
	}

	@Override
	public List<CompanyOrderView> select() {
		return this.getSession().createQuery(
				"from CompanyOrderView", CompanyOrderView.class).list();
	}

}
