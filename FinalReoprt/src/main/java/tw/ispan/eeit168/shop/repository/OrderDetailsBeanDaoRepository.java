package tw.ispan.eeit168.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.ispan.eeit168.shop.dao.OrderDetailsBeanDao;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

@Repository
public interface OrderDetailsBeanDaoRepository extends JpaRepository<OrderDetailsBean, Integer>, OrderDetailsBeanDao {

}
