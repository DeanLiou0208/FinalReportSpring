package tw.ispan.eeit168.member.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.member.domain.MemberBean;

@SpringBootTest
public class MemberDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MemberDAO memberDAO;
	
//	@Test
	public void testSelect() {
		MemberBean select = memberDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<MemberBean> selects = memberDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		MemberBean insert = new MemberBean();
		insert.setAccount("javaAccount");
		insert.setPassword("javaPassword");
		
		MemberBean result = memberDAO.insert(insert);
		System.out.println("insert="+result);
	}
	
//	@Test
	public void testUpdate() {

		MemberBean update = new MemberBean();
		update.setId(1);
		update.setFirstName("更");
		update.setLastName("新");
		update.setUserName("成");
//		update.setShopName("功")update;
		update.setGender(true);

		LocalDate localDate = LocalDate.of(2000,01,11);
		java.sql.Date d = Date.valueOf(localDate);
		update.setBirth(d);
		
		update.setPhone("0988-777-666");
		update.setAddress("新北市xxx");
		update.setEmail("1@gmail.com");
		update.setUpdateAt(new Timestamp(System.currentTimeMillis()));
		memberDAO.update(update);
		
	}
	
//	@Test
	public void testDelete() {
		boolean delete = memberDAO.delete(101);
		System.out.println("delete="+delete);
	}

	
}
