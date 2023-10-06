package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;

import tw.ispan.eeit168.company.domain.ProductPhotoBean;

@Repository
@Transactional
public class ProductPhotoBeanDaoHibernate implements ProductPhotoBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductPhotoBean> select() {
		return this.getSession().createQuery("from ProductPhotoBean", ProductPhotoBean.class).list();
	}

	@Override
	public ProductPhotoBean insert(ProductPhotoBean bean) {

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
	public ProductPhotoBean update(ProductPhotoBean bean) {
		try {
			ProductPhotoBean temp = this.getSession().get(ProductPhotoBean.class, bean.getId());
			if (temp != null) {
				return (ProductPhotoBean) this.getSession().merge(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失敗");
			return null;
		}
		return null;
	}

	@Override
	public ProductPhotoBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductPhotoBean.class, id);
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			ProductPhotoBean temp = this.getSession().get(ProductPhotoBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<ProductPhotoBean> selectById(Integer id) {

		if (id != null) {
			// 使用HQL查询数据库

			String hql = "FROM ProductPhotoBean WHERE fkProductId = :id";
			Query<ProductPhotoBean> query = session.createQuery(hql, ProductPhotoBean.class);
			query.setParameter("id", id);

			return query.list();
		}
		return null;
	}

}
