package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;
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
	public PetArticleSpeciesMidBean selectById(Integer id) {
		if(id!=null) {
			return this.getSession().get(PetArticleSpeciesMidBean.class, id);	
		}return null;
	}
	
	@Override
	public List<PetArticleSpeciesMidBean> select(Integer fkPetArticleId) {
		if(fkPetArticleId != null ) {
			List<PetArticleBean> list = this.getSession().createQuery("FROM PetArticleBean WHERE id= :fkPetArticleId", PetArticleBean.class)
			.setParameter("fkPetArticleId", fkPetArticleId)
			.list();
			if(!list.isEmpty()) {
				String hql = "FROM PetArticleSpeciesMidBean p WHERE p.fkPetArticleId = :fkPetArticleId";
				Query<PetArticleSpeciesMidBean> query = session.createQuery(hql, PetArticleSpeciesMidBean.class);
				query.setParameter("fkPetArticleId", fkPetArticleId);
				return query.list();	
			}
		}
		return null;
	}
	@Override
	public List<PetArticleSpeciesMidBean> selectBySpeciesId(Integer fkPetArticleSpeciesId){
		if(fkPetArticleSpeciesId!=null) {
			List<PetArticleSpeciesBean> list = this.getSession().createQuery("FROM PetArticleSpeciesBean WHERE id = :fkPetArticleSpeciesId", PetArticleSpeciesBean.class)
			.setParameter("fkPetArticleSpeciesId", fkPetArticleSpeciesId)
			.list();
			if(!list.isEmpty()) {
				String hql = "FROM PetArticleSpeciesMidBean p WHERE p.fkPetArticleSpeciesId = :fkPetArticleSpeciesId";
				List<PetArticleSpeciesMidBean> result= this.getSession().createQuery(hql, PetArticleSpeciesMidBean.class)
				.setParameter("fkPetArticleSpeciesId", fkPetArticleSpeciesId)
				.list();
				return result;
			}
		}
		return null;
	}
	@Override
	public PetArticleSpeciesMidBean insert(PetArticleSpeciesMidBean bean) {
		if(bean!= null && bean.getFkPetArticleId()!=null && bean.getFkPetArticleSpeciesId()!=null) {
			Integer fkPetArticleId = bean.getFkPetArticleId();
			Integer fkPetArticleSpeciesId = bean.getFkPetArticleSpeciesId();
			PetArticleBean petArticleId = this.getSession().createQuery("FROM PetArticleBean WHERE id= :fkPetArticleId",PetArticleBean.class)
			.setParameter("fkPetArticleId", fkPetArticleId)
			.getSingleResult();
			PetArticleSpeciesBean articleSpeciesId = this.getSession().createQuery("FROM PetArticleSpeciesBean WHERE id= :fkPetArticleSpeciesId", PetArticleSpeciesBean.class)
			.setParameter("fkPetArticleSpeciesId", fkPetArticleSpeciesId)
			.getSingleResult();
			if(petArticleId!= null && articleSpeciesId!=null) {
				this.getSession().persist(bean);
				return bean;				
			}
		}
		return null;
	}
//	@Override
	public PetArticleSpeciesMidBean update(PetArticleSpeciesMidBean bean) {
		if(bean!= null ) {
//			String sql = FROM PetArticleSpeciesMidBean WHERE fkPetArticleId= :fkPetArticleId AND fkPetArticleSpeciesId= :fkPetArticleSpeciesId;
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
		
	@Override
	public boolean deleteByArticleId(Integer fkPetArticleId) {
		if(fkPetArticleId!=null) {
			String sql = "FROM PetArticleSpeciesMidBean WHERE fkPetArticleId= :fkPetArticleId";
			List<PetArticleSpeciesMidBean> list = this.getSession().createQuery(sql, PetArticleSpeciesMidBean.class)
				.setParameter("fkPetArticleId", fkPetArticleId).getResultList();
//			System.out.println(list);
			if(!list.isEmpty()) {
				for(PetArticleSpeciesMidBean bean :list) {
					
					this.getSession().remove(bean);
				}
			
				return true;
			}
			}
	return false;
	}
	
	
	
}
