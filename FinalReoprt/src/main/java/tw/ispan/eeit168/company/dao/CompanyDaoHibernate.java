package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.CompanyBean;

@Repository
//@Transactional
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
				return  this.getSession().merge(bean);
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
	public CompanyBean selectByAccount(String account) {
	    if (account != null) {
	        String queryString = "FROM CompanyBean WHERE account = :account";
	        Query<CompanyBean> query = this.getSession().createQuery(queryString, CompanyBean.class);
	        query.setParameter("account", account);
	        
	        // 使用 query.list() 或 query.uniqueResult() 來執行查詢
	        List<CompanyBean> results = query.list();
	        
	        if (!results.isEmpty()) {
	            // 如果查詢結果不為空，返回第一個匹配的結果
	            return results.get(0);
	        }
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

	@Override
	public boolean islock(CompanyBean bean) {
		if(bean!=null && bean.getIsLock()!=null) {
			if(bean.getIsLock()) {
				return true; 
			}
		}
		return false;
	}
	@Override
	public boolean selectByShopName(String shopName) {
	    if (shopName != null) {
	        String queryString = "FROM CompanyBean WHERE shopName = :shopName";
	        Query<CompanyBean> query = this.getSession().createQuery(queryString, CompanyBean.class);
	        query.setParameter("shopName", shopName);
	        
	        // 使用 query.list() 或 query.uniqueResult() 來執行查詢
	        List<CompanyBean> results = query.list();
	        
	        if (!results.isEmpty()) {
	            // 如果查詢結果不為空，返回第一個匹配的結果
	            return true;
	        }
	    }
	    return false;
	}
	
}
