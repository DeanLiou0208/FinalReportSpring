package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.CompanyOrderView;


@Repository
public class CompanyOrderViewDaoHibernate implements CompanyOrderViewDao {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public CompanyOrderView select(Integer id) {
		if(id != null) {
			return this.getSession().get(CompanyOrderView.class, id);
		}
		return null;
	}

	@Override
	public List<CompanyOrderView> select() {
		return this.getSession().createQuery(
				"from CompanyOrderView", CompanyOrderView.class).list();
	}
	
	
	@Override
	public List<CompanyOrderView> selectByShopName(String shopName) {
	    if (shopName != null) {
	        String queryString = "FROM CompanyOrderView WHERE shopName = :shopName";
	        Query<CompanyOrderView> query = this.getSession().createQuery(queryString, CompanyOrderView.class);
	        query.setParameter("shopName", shopName);
	        
	        // 使用 query.list() 或 query.uniqueResult() 來執行查詢
	        List<CompanyOrderView> results = query.list();
	        
	        if (!results.isEmpty()) {
	            // 如果查詢結果不為空，返回第一個匹配的結果
	            return results;
	        }
	    }
	    return null;
	}
}
