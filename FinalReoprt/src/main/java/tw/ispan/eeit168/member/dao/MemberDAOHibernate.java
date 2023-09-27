package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.member.domain.PetLikesBean;

@Repository
@Transactional
public class MemberDAOHibernate implements MemberDAO {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public MemberBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(MemberBean.class, id);
		}
		return null;
	}
	
	@Override
	public List<MemberBean> select() {
		return this.getSession().createQuery(
				"from MemberBean", MemberBean.class).list();
	}
	
	@Override
	public MemberBean insert(MemberBean bean) {
		if(bean!=null) {		
				this.getSession().persist(bean);
				return bean;		
		}
		return null;
	}
	
	@Override
	public MemberBean update(MemberBean bean) {
		if(bean!=null && bean.getId()!=null) {
			MemberBean temp = this.getSession().get(MemberBean.class, bean.getId());
			if(temp!=null) {
				return (MemberBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			MemberBean temp = this.getSession().get(MemberBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
	
}
