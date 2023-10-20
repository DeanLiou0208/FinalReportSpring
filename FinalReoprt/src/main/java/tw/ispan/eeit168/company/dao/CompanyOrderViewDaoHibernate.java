package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.CompanyOrderView;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;


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
	public List<CompanyOrderView> selectByCompanyId(Integer companyId) {
		
        if (companyId != null) {
            // 使用HQL查询数据库
        
            String hql = "FROM CompanyOrderView WHERE companyId = :companyId";
            Query<CompanyOrderView> query = session.createQuery(hql, CompanyOrderView.class);
            query.setParameter("companyId", companyId);
           
            return query.list();
        }
        return null;
    }
}
