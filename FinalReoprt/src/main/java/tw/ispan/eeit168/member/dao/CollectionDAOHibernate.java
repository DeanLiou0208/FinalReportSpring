package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.CollectionBean;

@Repository
@Transactional
public class CollectionDAOHibernate implements CollectionDAO{
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public CollectionBean select(Integer fkMemberId,String fkUid) {
		if(fkMemberId != null && fkUid != null) {
			return this.getSession().createQuery(
					"FROM CollectionBean WHERE fkMemberId = :fkMemberId AND fkUid = :fkUid", CollectionBean.class)
					.setParameter("fkMemberId", fkMemberId)
					.setParameter("fkUid", fkUid)
					.uniqueResult();
		}
		return null;
	}
	
	@Override
	public List<CollectionBean> select() {
		return this.getSession().createQuery(
				"from CollectionBean", CollectionBean.class).list();
	}
	
	@Override
	public CollectionBean insert(CollectionBean bean) {
		if(bean!=null) {
			final String collectionsql = "FROM CollectionBean WHERE fkMemberId = :fkMemberId AND fkUid = :fkUid";
			Integer fkMemberId = bean.getFkMemberId();
			String fkUid = bean.getFkUid();
			List<CollectionBean> list = this.getSession()
					.createQuery(collectionsql, CollectionBean.class)
					.setParameter("fkMemberId", fkMemberId)
					.setParameter("fkUid", fkUid)
					.list();
			if(list.isEmpty()) {
				this.getSession().persist(bean);
				return bean;
			}
		}
		return null;
	}
	
	@Override
	public boolean delete(Integer fkMemberId, String fkUid) {
		if(fkMemberId != null && fkUid != null && fkUid.length() != 0) {
			final String collectionsql = "FROM CollectionBean WHERE fkMemberId = :fkMemberId AND fkUid = :fkUid";
			List<CollectionBean> list = this.getSession()
					.createQuery(collectionsql, CollectionBean.class)
					.setParameter("fkMemberId", fkMemberId)
					.setParameter("fkUid", fkUid)
					.list();
			if(!list.isEmpty()) {
				this.getSession().remove(list.get(0));
				return true;
			}
		}
		return false;
	}
	
}
