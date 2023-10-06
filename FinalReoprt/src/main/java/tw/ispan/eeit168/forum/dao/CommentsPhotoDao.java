package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

public interface CommentsPhotoDao {

	public abstract List<CommentsPhotoBean> select();
	
	public abstract List<CommentsPhotoBean> select(Integer fkCommentsId);
	
	public abstract CommentsPhotoBean selectById(Integer id);
	
	public abstract CommentsPhotoBean insert(CommentsPhotoBean bean);
	
	public abstract CommentsPhotoBean update(CommentsPhotoBean bean);
	
	public abstract boolean delete(Integer id);
}
