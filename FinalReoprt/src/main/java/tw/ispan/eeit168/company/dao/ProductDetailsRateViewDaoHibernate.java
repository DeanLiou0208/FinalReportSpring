package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;

@Repository
public class ProductDetailsRateViewDaoHibernate implements ProductDetailsRateViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductDetailsRateView> select() {
		return this.getSession().createQuery("from ProductDetailsRateView", ProductDetailsRateView.class).list();
	}

	@Override
	public ProductDetailsRateView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductDetailsRateView.class, id);
		}
		return null;
	}
	
	@Override
	public List<ProductDetailsRateView> selectById(Integer id) {
		
        if (id != null) {
            // 使用HQL查询数据库
        
            String hql = "FROM ProductDetailsRateView WHERE fkProductId = :id";
            Query<ProductDetailsRateView> query = session.createQuery(hql, ProductDetailsRateView.class);
            query.setParameter("id", id);
           
            return query.list();
        }
        return null;
    }
}
