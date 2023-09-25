package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeMidBean;

@Repository
@Transactional
public class ProductTypeMidBeanDaoHibernate implements ProductTypeMidBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductTypeMidBean> select() {
		return this.getSession().createQuery("from ProductTypeMidBean", ProductTypeMidBean.class).list();
	}
	@Override
	public ProductTypeMidBean insert(ProductTypeMidBean bean) {

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
	public ProductTypeMidBean update(ProductTypeMidBean bean) {
		try {
			ProductTypeMidBean temp = this.getSession().get(ProductTypeMidBean.class, bean.getId());
			if (temp != null) {
				return (ProductTypeMidBean) this.getSession().merge(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失敗");
			return null;
		}
		return null;
	}

	@Override
	public ProductTypeMidBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductTypeMidBean.class, id);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			ProductTypeMidBean temp = this.getSession().get(ProductTypeMidBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
}
