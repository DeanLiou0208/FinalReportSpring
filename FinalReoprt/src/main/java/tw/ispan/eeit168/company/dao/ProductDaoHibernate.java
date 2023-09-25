package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.CompanyBean;
import tw.ispan.eeit168.company.domain.ProductBean;

@Repository
@Transactional
public class ProductDaoHibernate implements ProductDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductBean> select() {
		return this.getSession().createQuery("from ProductBean", ProductBean.class).list();
	}

	
	@Override
	public ProductBean insert(ProductBean bean) {

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
	public ProductBean update(ProductBean bean) {
		try {
			ProductBean temp = this.getSession().get(ProductBean.class, bean.getId());
			if (temp != null) {
				return (ProductBean) this.getSession().merge(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失敗");
			return null;
		}
		return null;
	}

	@Override
	public ProductBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductBean.class, id);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			ProductBean temp = this.getSession().get(ProductBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
}
