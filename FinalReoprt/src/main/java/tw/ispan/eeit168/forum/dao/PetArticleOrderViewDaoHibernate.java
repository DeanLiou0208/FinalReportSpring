package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

@Repository
public class PetArticleOrderViewDaoHibernate implements PetArticleOrderViewDao {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<PetArticleOrderView> select (){
		return this.getSession().createQuery("from PetArticleOrderView", PetArticleOrderView.class).list();
	}
	@Override
	public List<PetArticleOrderView> selectShrech(String srt){
		String hql = "from PetArticleOrderView where title like :srt";
		// hql 內的表格  欄位 都需要使用bean裏面的變數 模糊搜尋的hql不需要加% %
		if(srt != null) {
			return
			this.getSession()
			.createQuery(hql, PetArticleOrderView.class)
			.setParameter("srt", "%"+srt+"%")
			//第一個""是hql裡面的代稱 第二個是傳入參數的名稱
			.list();
		}
		return null;
	}
}
