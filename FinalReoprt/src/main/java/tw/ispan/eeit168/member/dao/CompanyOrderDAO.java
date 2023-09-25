package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.CompanyOrderView;

public interface CompanyOrderDAO {

	public abstract CompanyOrderView select(Integer id);
	
	public abstract List<CompanyOrderView> select();
}
