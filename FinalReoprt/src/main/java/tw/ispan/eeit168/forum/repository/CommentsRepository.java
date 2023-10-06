package tw.ispan.eeit168.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tw.ispan.eeit168.forum.domain.CommentsBean;
@Repository
public interface CommentsRepository extends JpaRepository<CommentsBean, Integer>, CommentsRepositoryDao {

}
