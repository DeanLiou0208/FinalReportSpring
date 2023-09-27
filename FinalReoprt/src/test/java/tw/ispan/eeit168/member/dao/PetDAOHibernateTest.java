package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetBean;

@SpringBootTest
public class PetDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetDAO petDAO;
	
//	@Test
	public void testSelect() {
		PetBean select = petDAO.select(1);
		System.out.println("select first =" + select);
	}
	
//	@Test
	public void testSelectAll() {
		List<PetBean> selects = petDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		PetBean insert = new PetBean();
		insert.setFkMemberId(1);
		insert.setName("測試狗");
		insert.setCategroyId(1);
		insert.setAge(5);
		insert.setGender(null);
		
		PetBean result = petDAO.insert(insert);
		System.out.println("insert="+result);
	}

//	@Test
	public void testUpdate() {

		PetBean update = new PetBean();
		update.setId(1004);
		update.setFkMemberId(2);
		update.setName("測試貓");
		update.setCategroyId(2);
		update.setAge(6);
		update.setGender(true);
		petDAO.update(update);
		
	}
	
//	@Test
	public void testDelete() {
		boolean delete = petDAO.delete(1004);
		System.out.println("delete="+delete);
	}
}
