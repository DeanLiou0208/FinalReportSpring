package tw.ispan.eeit168.dao;

import java.util.List;

import tw.ispan.eeit168.domain.CompanyBean;

public interface CompanyDao {
	List<CompanyBean> select();
}
