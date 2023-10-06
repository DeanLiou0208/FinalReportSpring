package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
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
	@Override
	public List<ProductBean> selectByProductName(String productName) {
	    if (productName != null) {
	        String queryString = "FROM ProductBean WHERE name = :name ";
	        Query<ProductBean> query = this.getSession().createQuery(queryString, ProductBean.class);
	        query.setParameter("name", productName);
	        
	        // 使用 query.list() 或 query.uniqueResult() 來執行查詢
	        List<ProductBean> results = query.list();
	        
	        if (!results.isEmpty()) {
	            // 如果查詢結果不為空，返回第一個匹配的結果
	            return results;
	        }
	    }
	    return null;
	}
	
	
	@Override
	public List<ProductBean> selectByProductNameAndType(String productName,String productType) {
	    if (productName != null &&productType!=null) {
	    	String queryString = "FROM ProductBean WHERE name = :name AND size = :size";
	    	Query<ProductBean> query = this.getSession().createQuery(queryString, ProductBean.class);
	    	query.setParameter("name", productName);
	    	query.setParameter("size", productType);

	        // 使用 query.list() 或 query.uniqueResult() 來執行查詢
	        List<ProductBean> results = query.list();
	        System.out.println(query.list());
	        System.out.println(results);
	        if (!results.isEmpty()) {
	            // 如果查詢結果不為空，返回第一個匹配的結果
	            return results;
	        }
	    }
	    return null;
	}
}
