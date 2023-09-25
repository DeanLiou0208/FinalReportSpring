package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetPhotoBean;

@SpringBootTest
@Transactional
public class PetPhotoDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetPhotoDAO petPhotoDAO;
	
	@Test
	public void testSelect() {
		PetPhotoBean select = petPhotoDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<PetPhotoBean> selects = petPhotoDAO.select();
		System.out.println("selects="+selects);
	}
}
