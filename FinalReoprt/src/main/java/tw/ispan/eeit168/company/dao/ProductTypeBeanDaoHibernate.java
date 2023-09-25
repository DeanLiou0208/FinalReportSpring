package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeBean;

@Repository
@Transactional
public class ProductTypeBeanDaoHibernate implements ProductTypeBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductTypeBean> select() {
		return this.getSession().createQuery("from ProductTypeBean", ProductTypeBean.class).list();
	}
	@Override
	public ProductTypeBean insert(ProductTypeBean bean) {

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
	public ProductTypeBean update(ProductTypeBean bean) {
		try {
			ProductTypeBean temp = this.getSession().get(ProductTypeBean.class, bean.getId());
			if (temp != null) {
				return (ProductTypeBean) this.getSession().merge(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失敗");
			return null;
		}
		return null;
	}

	@Override
	public ProductTypeBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductTypeBean.class, id);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			ProductTypeBean temp = this.getSession().get(ProductTypeBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
}
