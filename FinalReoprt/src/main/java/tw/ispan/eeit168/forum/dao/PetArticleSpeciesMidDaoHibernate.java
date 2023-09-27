package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;

@Repository
@Transactional
public class PetArticleSpeciesMidDaoHibernate implements PetArticleSpeciesMidDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<PetArticleSpeciesMidBean> select() {
		return this.getSession().createQuery
				("From PetArticleSpeciesMidBean", PetArticleSpeciesMidBean.class).list();
	}
	@Override
	public List<PetArticleSpeciesMidBean> select(Integer fkPetArticleId) {
		if(fkPetArticleId != null ) {
			String hql = "FROM PetArticleSpeciesMidBean p WHERE p.fkPetArticleId = :fkPetArticleId";
            Query<PetArticleSpeciesMidBean> query = session.createQuery(hql, PetArticleSpeciesMidBean.class);
            query.setParameter("fkPetArticleId", fkPetArticleId);
            return query.list();
		}
		return null;
	}
	@Override
	public PetArticleSpeciesMidBean insert(PetArticleSpeciesMidBean bean) {
		if(bean!= null) {
			this.getSession().persist(bean);
			return bean;
		}
		return null;
	}
	@Override
	public PetArticleSpeciesMidBean update(PetArticleSpeciesMidBean bean) {
		if(bean!= null && bean.getId()!= null) {
			PetArticleSpeciesMidBean temp = this.getSession().get(PetArticleSpeciesMidBean.class, bean.getId());
			if(temp!=null) {
				return this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			PetArticleSpeciesMidBean temp = this.getSession().get(PetArticleSpeciesMidBean.class, id);
		if(temp!=null) {
			this.getSession().remove(temp);
			return true;
		}
		}
		return false;
	}
}
