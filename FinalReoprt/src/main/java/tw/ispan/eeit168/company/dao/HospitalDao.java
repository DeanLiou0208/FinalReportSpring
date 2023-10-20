package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.HospitalBean;

public interface HospitalDao {
	List<HospitalBean> select();
	HospitalBean select(Integer id);
}
