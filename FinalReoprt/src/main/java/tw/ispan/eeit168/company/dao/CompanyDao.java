package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.CompanyBean;

public interface CompanyDao {
	List<CompanyBean> select();
}
