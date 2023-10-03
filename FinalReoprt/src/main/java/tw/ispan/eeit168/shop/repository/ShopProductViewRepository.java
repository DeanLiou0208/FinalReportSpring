package tw.ispan.eeit168.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.ispan.eeit168.shop.dao.ShopProductViewDao;
import tw.ispan.eeit168.shop.domain.ShopProductView;

@Repository
public interface ShopProductViewRepository extends JpaRepository<ShopProductView, Integer>, ShopProductViewDao{

}
