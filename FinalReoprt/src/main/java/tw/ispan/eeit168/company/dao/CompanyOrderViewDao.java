package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.CompanyOrderView;

public interface CompanyOrderViewDao {

	public abstract CompanyOrderView select(Integer id);
	
	public abstract List<CompanyOrderView> select();

	List<CompanyOrderView> selectByCompanyId(Integer companyId);


}
