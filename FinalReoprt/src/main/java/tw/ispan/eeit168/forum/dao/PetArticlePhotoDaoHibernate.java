package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@Repository
@Transactional
public class PetArticlePhotoDaoHibernate implements PetArticlePhotoDao {
	
	 @PersistenceContext
		private Session session;

		public Session getSession() {
			return session;
		}

	@Override
	public List<PetArticlePhotoBean> select() {
		
		return this.getSession().createQuery("From PetArticlePhotoBean", PetArticlePhotoBean.class).list();
	}
	@Override
	public PetArticlePhotoBean select(Integer id) {
		if(id != null) {
			 return this.getSession().get(PetArticlePhotoBean.class, id);
		}
		return null;
	}
	@Override
	public List<PetArticlePhotoBean> selectByPetArticleId(Integer fkPetArticleId) {
		if(fkPetArticleId!= null) {
			List<PetArticleBean> list = this.getSession().createQuery("FROM PetArticleBean WHERE id = :fkPetArticleId", PetArticleBean.class)
					.setParameter("fkPetArticleId", fkPetArticleId)
					.list();
//			System.out.println(list);
			if(!list.isEmpty()) {
				List<PetArticlePhotoBean> resultList = this.getSession().createQuery("FROM PetArticlePhotoBean WHERE fkPetArticleId = :fkPetArticleId", PetArticlePhotoBean.class)
				.setParameter("fkPetArticleId", fkPetArticleId)
				.getResultList();
				return resultList;
			}
			
		}
		return null;
	}
	@Override
	public PetArticlePhotoBean insert(PetArticlePhotoBean bean) {
		if(bean != null && bean.getFkPetArticleId()!=null) {
			Integer fkPetArticleId = bean.getFkPetArticleId();
			List<PetArticleBean> list = this.getSession().createQuery("FROM PetArticleBean WHERE id = :fkPetArticleId",PetArticleBean.class )
			.setParameter("fkPetArticleId", fkPetArticleId)
			.list();
			if(!list.isEmpty()) {
				this.getSession().persist(bean);
				return bean;
			}
		}
		return null;
	}
	
	@Override
	public PetArticlePhotoBean update(PetArticlePhotoBean bean) {
		if(bean != null && bean.getId()!= null) {
			Integer fkPetArticleId = bean.getFkPetArticleId();
			List<PetArticleBean> list = this.getSession().createQuery("FROM PetArticleBean WHERE id = :fkPetArticleId",PetArticleBean.class )
			.setParameter("fkPetArticleId", fkPetArticleId)
			.list();
			
			if(!list.isEmpty()) {
				return this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			PetArticlePhotoBean temp = this.getSession().get(PetArticlePhotoBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}


}
