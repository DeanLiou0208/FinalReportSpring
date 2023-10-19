package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.OrderListBean;

@Repository
public class OrderListBeanDaoImpl implements OrderListBeanDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<OrderListBean> select(){
		return this.getSession().createQuery("from OrderListBean", OrderListBean.class).list();
	}
	
	@Override
	public Integer findOrderId(Integer id) {
		String hql = "FROM OrderListBean WHERE fkMemberId = :id ORDER BY createAt DESC";
		Query<OrderListBean> query = this.session.createQuery(hql,OrderListBean.class).setParameter("id", id);
		
		OrderListBean result = query.setMaxResults(1).uniqueResult();
		
		return result.getId();
	}
}
