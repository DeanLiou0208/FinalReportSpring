package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.MemberBean;

@Repository
//@Transactional
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
	public Integer selectById(String account) {
		if(account != null) {		
			Integer memberId= this.getSession().createQuery("Select id FROM MemberBean WHERE account = :account", Integer.class)
			.setParameter("account", account)
			.uniqueResult();
			if(memberId != null) {
				return memberId;
			}
		}	
		return null;
	}
	
	@Override
	public MemberBean select(String account) {
		if(account != null) {		
			MemberBean member= this.getSession().createQuery("FROM MemberBean WHERE account = :account", MemberBean.class)
			.setParameter("account", account)
			.uniqueResult();
			if(member != null) {
				return member;
			}
		}	
		return null;
	}
	//可能棄用
	@Override
	public Integer select(String account, String password) {
		if(account != null && password != null) {		
			MemberBean member= this.getSession().createQuery("FROM MemberBean WHERE account = :account AND password = :password", MemberBean.class)
			.setParameter("account", account)
			.setParameter("password", password)
			.uniqueResult();
			if(member != null) {
				return member.getId();
			}
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
	public Boolean updatePassword(String account, String password) {
		if(account!=null && password!=null && account.length()!=0 && password.length()!=0) {	
			int result = this.getSession().createQuery("UPDATE MemberBean SET password = :password WHERE account = :account")
			.setParameter("account", account)
			.setParameter("password", password)
			.executeUpdate();
			System.out.println(result);
			if(result==1) {
				return true;
			}
		}
		return false;
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
