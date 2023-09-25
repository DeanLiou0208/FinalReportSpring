package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.MemberBean;

@Repository
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
	
	
}
