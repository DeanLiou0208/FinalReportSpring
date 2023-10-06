package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.CompanyBean;

public interface CompanyDao {
	List<CompanyBean> select();
	CompanyBean select(Integer id);
	CompanyBean insert(CompanyBean bean);
	CompanyBean update(CompanyBean bean);
	boolean delete(Integer id);
	CompanyBean selectByAccount(String Account);
	boolean islock(CompanyBean bean);
	boolean selectByShopName(String shopName);
	
}
