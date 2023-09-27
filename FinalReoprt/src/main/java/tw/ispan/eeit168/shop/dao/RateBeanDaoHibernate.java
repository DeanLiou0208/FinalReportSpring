package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.RateBean;

@Repository
public class RateBeanDaoHibernate implements RateBeanDao {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<RateBean> select() {
		return this.getSession().createQuery("from RateBean", RateBean.class).list();

	}

	@Override
	public RateBean selectById(Integer id) {
		if (id != null) {
			return this.getSession().get(RateBean.class, id);
		}
		return null;
	}

	@Override
	public RateBean insert(RateBean bean) {
		if (bean != null) {
			this.getSession().persist(bean);
			return bean;
		}
		return null;
	}

	@Override
	public RateBean update(RateBean bean) {
		if (bean != null && bean.getId() != null) {
			RateBean temp = this.getSession().get(RateBean.class, bean.getId());
			if (temp != null) {
				return (RateBean) this.getSession().merge(bean);
			}
		}
		return null;
	}

	public boolean delete(Integer id) {
		if (id != null) {
			RateBean temp = this.getSession().get(RateBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}

}
