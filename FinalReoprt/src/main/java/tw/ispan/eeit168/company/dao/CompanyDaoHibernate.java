package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.CompanyBean;

@Repository
@Transactional
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

	@Override
	public CompanyBean insert(CompanyBean bean) {

		try {
			this.getSession().persist(bean);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("新增失敗");
			return null;
		}

	}

	@Override
	public CompanyBean update(CompanyBean bean) {
		if (bean != null && bean.getId() != null) {
			CompanyBean temp = this.getSession().get(CompanyBean.class, bean.getId());
			if (temp != null) {
				return (CompanyBean) this.getSession().merge(bean);
			}
		}
		return null;
	}

	@Override
	public CompanyBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(CompanyBean.class, id);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			CompanyBean temp = this.getSession().get(CompanyBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
}
