package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

public interface CommentsPhotoDao {

	public abstract List<CommentsPhotoBean> select();
}
