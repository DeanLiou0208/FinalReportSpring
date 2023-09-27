package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetCategroyBean;
import tw.ispan.eeit168.member.domain.PetPhotoBean;

@SpringBootTest
public class PetPhotoDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetPhotoDAO petPhotoDAO;
	
//	@Test
	public void testSelect() {
		PetPhotoBean select = petPhotoDAO.select(1);
		System.out.println("select first =" + select);
	}
	
//	@Test
	public void testSelectAll() {
		List<PetPhotoBean> selects = petPhotoDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		PetPhotoBean insert = new PetPhotoBean();
		insert.setFkPetId(5);
		insert.setMain(null);
		insert.setImg("64544684846866.jpg");
		

		PetPhotoBean result = petPhotoDAO.insert(insert);
		System.out.println("insert="+result);
	}

	@Test
	public void testUpdate() {

		PetPhotoBean update = new PetPhotoBean();
		update.setId(16);
		update.setFkPetId(5);
		update.setMain(true);
		update.setImg("846866.jpg");
		petPhotoDAO.update(update);
		
	}
	
//	@Test
	public void testDelete() {
		boolean delete = petPhotoDAO.delete(1002);
		System.out.println("delete="+delete);
	}
	
	
}
