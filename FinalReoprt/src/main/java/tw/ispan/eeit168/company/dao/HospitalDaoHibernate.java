package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.HospitalBean;

@Repository
public class HospitalDaoHibernate implements HospitalDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<HospitalBean> select() {
		return this.getSession().createQuery("from HospitalBean", HospitalBean.class).list();
	}
	@Override
	public HospitalBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(HospitalBean.class, id);
		}
		return null;
	}
}
