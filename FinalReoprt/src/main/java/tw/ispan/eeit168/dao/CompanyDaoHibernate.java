package tw.ispan.eeit168.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.domain.CompanyBean;

@Repository
public class CompanyDaoHibernate implements CompanyDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<CompanyBean> select() {
		return this.getSession().createQuery("from CompanyBean", CompanyBean.class).list();
	}

}
