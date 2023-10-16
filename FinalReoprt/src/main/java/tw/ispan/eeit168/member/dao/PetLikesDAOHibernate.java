package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetLikesBean;

@Repository
@Transactional
public class PetLikesDAOHibernate implements PetLikesDAO {
	@PersistenceContext
	private Session session;

	private Session getSession() {
		return session;
	}

	@Override
	public List<PetLikesBean> select() {
		return this.getSession().createQuery("from PetLikesBean", PetLikesBean.class).list();
	}
	
	@Override
	public List<Integer> select(Integer fkMemberId) {
		return this.getSession().createQuery("Select fkPetId FROM PetLikesBean WHERE fkMemberId = :fkMemberId", Integer.class)
				.setParameter("fkMemberId", fkMemberId)
				.list();
	}

//	@Override
//	public PetLikesBean insert(PetLikesBean bean) {
//		System.out.println("4");
//		if (bean != null && bean.getFkMemberId() != null && bean.getFkPetId() != null) {
//			System.out.println("5");
//			PetLikesBean memberId = this.getSession().get(PetLikesBean.class, bean.getFkMemberId());
//			System.out.println("6");
//			if (memberId == null) {
//				System.out.println("7");
//				this.getSession().persist(bean);
//				System.out.println("3");
//				return bean;
//			} else {
//				PetLikesBean petId = this.getSession().get(PetLikesBean.class, bean.getFkPetId());
//				if (petId == null) {
//					this.getSession().persist(bean);
//					System.out.println("2");
//					return bean;
//				}
//			}
//		}
//		System.out.println("1");
//		return null;
//	}
	
	@Override
	public PetLikesBean insert(PetLikesBean bean) {
		if(bean!=null) {
			Integer fkMemberId = bean.getFkMemberId();
			Integer fkPetId = bean.getFkPetId();
			List<PetLikesBean> list = this.getSession().createQuery("FROM PetLikesBean WHERE fkMemberId = :fkMemberId AND fkPetId = :fkPetId", PetLikesBean.class)
					.setParameter("fkMemberId", fkMemberId)
					.setParameter("fkPetId", fkPetId)
					.list();
			if(list.isEmpty()) {
				this.getSession().persist(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
    public boolean delete(Integer MemberId, Integer PetId) {
        if(MemberId !=null && PetId!= null) {     	
            final String collectionsql = "FROM PetLikesBean WHERE fkMemberId = :fkMemberId AND fkPetId = :fkPetId";
            Integer fkMemberId = MemberId;
            Integer fkPetId = PetId;
            List<PetLikesBean> list = this.getSession()
                    .createQuery(collectionsql, PetLikesBean.class)
                    .setParameter("fkMemberId", fkMemberId)
                    .setParameter("fkPetId", fkPetId)
                    .list();
            if(!list.isEmpty()) {
                this.getSession().remove(list.get(0));
                return true;
            }
        }
        return false;
    }
	
}
