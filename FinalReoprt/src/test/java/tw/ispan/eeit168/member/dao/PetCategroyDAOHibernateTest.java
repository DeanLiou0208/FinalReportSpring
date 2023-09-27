package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetBean;
import tw.ispan.eeit168.member.domain.PetCategroyBean;

@SpringBootTest
public class PetCategroyDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetCategroyDAO petCategroyDAO;
	
//	@Test
	public void testSelect() {
		PetCategroyBean select = petCategroyDAO.select(1);
		System.out.println("select first =" + select);
	}
	
//	@Test
	public void testSelectAll() {
		List<PetCategroyBean> selects = petCategroyDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		PetCategroyBean insert = new PetCategroyBean();
		insert.setBreed("狗測試");
		insert.setSpecies("狗狗");

		PetCategroyBean result = petCategroyDAO.insert(insert);
		System.out.println("insert="+result);
	}

//	@Test
	public void testUpdate() {

		PetCategroyBean update = new PetCategroyBean();
		update.setId(1002);
		update.setBreed("貓測試");
		update.setSpecies("貓貓");
		petCategroyDAO.update(update);
		
	}
	
//	@Test
	public void testDelete() {
		boolean delete = petCategroyDAO.delete(1002);
		System.out.println("delete="+delete);
	}
	
}
