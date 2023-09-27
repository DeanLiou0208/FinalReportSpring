package tw.ispan.eeit168.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tw.ispan.eeit168.company.dao.CompanyDao;
import tw.ispan.eeit168.company.domain.CompanyBean;

@SpringBootTest

public class CompanyDaoHibernateTests {

	@Autowired
	private CompanyDao companyDao;

	//@Test
	public void testSelectAll() {
		List<CompanyBean> selects = companyDao.select();
		System.out.println("selects=" + selects);
	}

	//@Test
	public void testInsert() {
		
//		 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		CompanyBean insert = new CompanyBean();
		insert.setAccount("tsaotsao");
		insert.setPassword("123dddd");
		insert.setShopName("商店1");
//		insert.setCreateAt(currentTimestamp);
//		insert.setUpdateAt(currentTimestamp);
		CompanyBean result = companyDao.insert(insert);
		System.out.println("insert="+result);
		List<CompanyBean> selects = companyDao.select();
		System.out.println("selects=" + selects);
	}
	
	
	//@Test
	public void testUpdate() {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		CompanyBean update = new CompanyBean();
		CompanyBean a =companyDao.select(10);
		update.setId(a.getId());
		update.setPassword(a.getPassword());
		update.setAddress("台中XeetwtwetX");
		update.setEmail("qqwwwtwtewtwq@test");
		update.setPhone("024353625");
		update.setTaxIdNumber(43133325);
		update.setUpdateAt(currentTimestamp);
		companyDao.update(update);
		
	}
	
	//@Test
	public void testSelect() {
		CompanyBean select = companyDao.select(10);
		System.out.println("select="+select);
	}
	

	@Test
	public void testSelectByAccount() {
		CompanyBean select = companyDao.selectByAccount("tku");
		System.out.println("select="+select);
	}
	
	//@Test
	public void testDelete() {
		boolean delete = companyDao.delete(10);
		System.out.println("delete="+delete);
	}
	
}
