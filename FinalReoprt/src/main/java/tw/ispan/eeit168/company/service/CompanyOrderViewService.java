package tw.ispan.eeit168.company.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.CompanyOrderViewDao;
import tw.ispan.eeit168.company.domain.CompanyOrderView;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;
import tw.ispan.eeit168.shop.repository.OrderDetailsBeanDaoRepository;

@Service
@Transactional(rollbackFor = { Exception.class })
public class CompanyOrderViewService {

	@Autowired
	private CompanyOrderViewDao companyOrderViewDao;
	@Autowired
	private OrderDetailsBeanDaoRepository odbdr;

	public List<CompanyOrderView> existsShopName(String ShopName) {
		return companyOrderViewDao.selectByShopName(ShopName);
	}

	public OrderDetailsBean modify(String body) {
		try {
			JSONObject obj = new JSONObject(body);

			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			String state = obj.isNull("state") ? null : obj.getString("state");
			Optional<OrderDetailsBean> optional = odbdr.findById(id);
			if (optional != null && optional.isPresent()) {

				OrderDetailsBean update = optional.get();

				update.setState(state);

				return odbdr.save(update);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
