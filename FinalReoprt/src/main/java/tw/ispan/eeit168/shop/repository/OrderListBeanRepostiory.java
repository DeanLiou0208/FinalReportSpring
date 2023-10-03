package tw.ispan.eeit168.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.ispan.eeit168.shop.dao.OrderListBeanDao;
import tw.ispan.eeit168.shop.domain.OrderListBean;

@Repository
public interface OrderListBeanRepostiory extends JpaRepository<OrderListBean, Integer>, OrderListBeanDao{

}
