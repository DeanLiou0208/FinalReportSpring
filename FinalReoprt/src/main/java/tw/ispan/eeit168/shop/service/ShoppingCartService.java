package tw.ispan.eeit168.shop.service;

import java.sql.Timestamp;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.ispan.eeit168.company.dao.ProductDao;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.shop.dao.ShoppingCartBeanDao;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class ShoppingCartService {

	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private MemberDAO memberDAO;

	// 判斷購物車是否存在
	public boolean exists(Integer id) {
		return shoppingCartBeanDao.selectById(id) != null;
	}

	// 判斷產品是否存在
	public boolean productExists(Integer id) {
		return productDao.select(id) != null;
	}

	// 判斷會員是否存在
	public boolean memberExists(Integer id) {
		return memberDAO.select(id) != null;
	}

	public ShoppingCartBean addShoppingCart(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkProductId = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
			Integer count = obj.isNull("count") ? null : obj.getInt("count");

			if (fkMemberId != null && fkProductId != null) {
				ShoppingCartBean insert = new ShoppingCartBean();
				insert.setFkMemberId(fkMemberId);
				insert.setFkProductId(fkProductId);
				insert.setCount(count);

				return shoppingCartBeanDao.insert(insert);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public ShoppingCartBean updateCart(String json) {

		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkProductId = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
			Integer count = obj.isNull("count") ? null : obj.getInt("count");

			ShoppingCartBean update = shoppingCartBeanDao.selectById(id);
			update.setFkMemberId(fkMemberId);
			update.setFkProductId(fkProductId);
			update.setCount(count);
			update.setUpdateAt(new Timestamp(System.currentTimeMillis()));

			return shoppingCartBeanDao.update(update);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}// updateCart end

	public boolean shoppingCartRemove(String json) {

		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		Integer id = null;
		if (jsonObject.has("id") && !jsonObject.get("id").isJsonNull()) {
			id = jsonObject.get("id").getAsInt();
		}
		Integer fkMemberId = null;
		if (jsonObject.has("fkMemberId") && !jsonObject.get("fkMemberId").isJsonNull()) {
			fkMemberId = jsonObject.get("fkMemberId").getAsInt();
		}

		if (id != null && fkMemberId != null) {
			try {
				return shoppingCartBeanDao.delect(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}
}
