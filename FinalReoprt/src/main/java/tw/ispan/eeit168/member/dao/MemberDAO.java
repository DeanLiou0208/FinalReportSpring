package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.MemberBean;

public interface MemberDAO {
	
	public abstract MemberBean select(Integer id);
	
	public abstract MemberBean select(String account);
	
	public abstract Integer select(String account, String password);

	public abstract List<MemberBean> select();

	public abstract MemberBean insert(MemberBean bean);
	
	public abstract MemberBean update(MemberBean bean);

	public abstract boolean delete(Integer id);
}
