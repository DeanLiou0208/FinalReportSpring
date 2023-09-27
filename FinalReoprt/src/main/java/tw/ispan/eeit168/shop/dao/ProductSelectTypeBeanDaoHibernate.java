package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.ProductSelectTypeBean;

@Repository
public class ProductSelectTypeBeanDaoHibernate implements ProductSelectTypeBeanDao {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductSelectTypeBean> select() {
		return this.getSession().createQuery("from ProductSelectTypeBean", ProductSelectTypeBean.class).list();
	}

	@Override
	public ProductSelectTypeBean selectById(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductSelectTypeBean.class, id);
		}
		return null;
	}

	@Override
	public ProductSelectTypeBean insert(ProductSelectTypeBean bean) {
		String srt = bean.getType();
		
		if (bean != null) {
			String hql = "SELECT new List(id,type) from ProductSelectTypeBean where type = :srt";
			// Select 多個欄位從一個資料表 請用new List(colume1,colume2)
			List<ProductSelectTypeBean> list = this.getSession().createQuery(hql, ProductSelectTypeBean.class)
					.setParameter("srt", srt).list();
			//list.toString().equals(bean.getType()); list的toString 和java.land 的toString是不一樣的
			System.out.println(list);
			if (list.isEmpty()) {
				this.getSession().persist(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if (id != null) {
			ProductSelectTypeBean temp = this.getSession().get(ProductSelectTypeBean.class, id);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}

}
