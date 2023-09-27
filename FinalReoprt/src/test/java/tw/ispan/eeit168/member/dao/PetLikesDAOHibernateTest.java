package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.member.domain.PetLikesBean;

@SpringBootTest
public class PetLikesDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetLikesDAO petLikesDAO;
	
//	@Test
	public void testSelectAll() {
		List<PetLikesBean> selects = petLikesDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		PetLikesBean insert = new PetLikesBean();
		insert.setFkMemberId(2);
		insert.setFkPetId(9);	
		PetLikesBean result = petLikesDAO.insert(insert);
		System.out.println("insert="+result);
	}
	
//	@Test
	public void testDelete() {
		boolean delete = petLikesDAO.delete(2,9);
		System.out.println("delete="+delete);
	}
	
}
