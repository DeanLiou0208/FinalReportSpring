package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.CollectionBean;
import tw.ispan.eeit168.member.domain.PetLikesBean;

@SpringBootTest
public class CollectionDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CollectionDAO collectionDAO;
	
//	@Test
	public void testSelectAll() {
		List<CollectionBean> selects = collectionDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		CollectionBean insert = new CollectionBean();
		insert.setFkMemberId(1);
		insert.setFkUid("028E7B23-DBFA-4A64-BD78-93E973E1BCE2");	
		CollectionBean result = collectionDAO.insert(insert);
		System.out.println("insert="+result);
	}
	
//	@Test
	public void testDelete() {
		boolean delete = collectionDAO.delete(1,"028E7B23-DBFA-4A64-BD78-93E973E1BCE2");
		System.out.println("delete="+delete);
	}
	
}
