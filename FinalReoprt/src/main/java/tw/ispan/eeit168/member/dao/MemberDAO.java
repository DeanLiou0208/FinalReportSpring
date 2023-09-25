package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.MemberBean;

public interface MemberDAO {
	
	public abstract MemberBean select(Integer id);
	
	public abstract List<MemberBean> select();
}
