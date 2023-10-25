package tw.ispan.eeit168.company.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.Base64Utils;
import tw.ispan.eeit168.company.dao.ProductDao;
import tw.ispan.eeit168.company.dao.ProductDetailsRateViewDao;
import tw.ispan.eeit168.company.dao.ProductDetailsViewDao;

import tw.ispan.eeit168.company.dao.ProductPhotoBeanDao;
import tw.ispan.eeit168.company.domain.CompanyBean;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;
import tw.ispan.eeit168.company.domain.ProductDetailsView;

import tw.ispan.eeit168.company.domain.ProductPhotoBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class ProductService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductDetailsViewDao pdvd;

	@Autowired
	private ProductDetailsRateViewDao pdrvd;

	@Autowired
	private ProductPhotoBeanDao pp;

	public boolean exists(String productName) {
		return productDao.selectByProductName(productName) != null;
	}
	
	public boolean existsProductType(String productName,String productType) {
		return productDao.selectByProductNameAndType(productName,productType) != null;
	}

	public ProductBean existsProductNameAndType(Integer fkCompanyId, String productName, String productType) {

		List<ProductBean> productBean = productDao.selectByProductNameAndType(productName, productType);
		List<ProductBean> result = new ArrayList<ProductBean>();
		if (productBean != null) {

			for (ProductBean check : productBean) {			
				if (fkCompanyId == check.getFkCompanyId()) {
					result.add(check);
					return result.get(0);
				}
			}
		}
		return null;
	}
	public ProductBean existsForUpdate(Integer id,Integer fkCompanyId, String productName, String productType) {

		List<ProductBean> productBean = productDao.selectByProductNameAndType(productName, productType);
		List<ProductBean> result = new ArrayList<ProductBean>();
		if (productBean != null) {

			for (ProductBean check : productBean) {			
				if (fkCompanyId == check.getFkCompanyId() && id==check.getId() ) {
					return null;
				}else {
					if(check.getId()!=id) {
					result.add(check);
					return result.get(0);}
				}
			}
		}
		return null;
	}

	public ProductBean idExists(Integer id) {
		return productDao.select(id);
	}

	public ProductBean create(String json) {
		
		try {
			JSONObject obj = new JSONObject(json);
			System.out.println(json);
			
			Integer fkCompanyId = obj.isNull("fkCompanyId") ? null : obj.getInt("fkCompanyId");
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String name = obj.isNull("name") ? null : ""+obj.get("name");
			String type = obj.isNull("type") ? null : ""+obj.get("type");
			Integer inventory = obj.isNull("inventory") ? null : obj.getInt("inventory");
			Integer price = obj.isNull("price") ? null : obj.getInt("price");
			String description = obj.isNull("description") ? null :""+obj.get("description");
			String size = obj.isNull("size") ? null : ""+obj.get("size");
			Boolean status = obj.isNull("status") ? false : obj.getBoolean("status");

			ProductBean insert = new ProductBean();

			insert.setFkCompanyId(fkCompanyId);
			insert.setFkMemberId(fkMemberId);
			insert.setName(name);
			insert.setType(type);
			insert.setInventory(inventory);
			insert.setPrice(price);
			insert.setDescription(description);
			insert.setSize(size);
			insert.setStatus(status);
			
			return productDao.insert(insert);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProductBean modify(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			Integer fkCompanyId = obj.isNull("fkCompanyId") ? null : obj.getInt("fkCompanyId");
			String name = obj.isNull("name") ? null :""+obj.get("name");
			String type = obj.isNull("type") ? null : ""+obj.get("type");
			Integer inventory = obj.isNull("inventory") ? null : obj.getInt("inventory");
			Integer price = obj.isNull("price") ? null : obj.getInt("price");
			String description = obj.isNull("description") ? null : ""+obj.get("description");
			String size=obj.isNull("size") ? null : ""+obj.get("size");
			Boolean status = obj.isNull("status") ? null : obj.getBoolean("status");
			if (id == null) {
				return null;
			} else {
				ProductBean update = productDao.select(id);
				update.setFkCompanyId(fkCompanyId);
				update.setName(name);
				update.setType(type);
				update.setInventory(inventory);
				update.setPrice(price);
				update.setDescription(description);
				update.setSize(size);
				update.setStatus(status);

				return productDao.update(update);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProductDetailsView findProduct(Integer id) {
		if (id != null) {
			return pdvd.select(id);
		}
		return null;

	}

	public List<ProductDetailsRateView> findProductRate(String srt) {
		JSONObject obj = new JSONObject(srt);
		
		Integer id = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
		if (id != null) {

			return pdrvd.selectById(id);
		}
		return null;

	}

	public List<ProductPhotoBean> findProductPhoto(Integer id) {

		if (id != null) {

			return pp.selectById(id);
		}
		return null;

	}
	
	public ProductPhotoBean modifyPhoto(Integer fkProductId,Boolean main, MultipartFile file) {
		try {
			String photo = null;
			if (file != null && !file.isEmpty()) {
				photo = Base64Utils.convertToBase64(file);
			}
			ProductPhotoBean insert = new ProductPhotoBean();
			insert.setFkProductId(fkProductId);
			insert.setImg(photo);
			insert.setMain(main);
			return pp.insert(insert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ProductBean modifyStatus(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			Boolean status = obj.isNull("status") ? null : obj.getBoolean("status");
			if (id == null) {
				return null;
			} else {
				ProductBean update = productDao.select(id);
				
				update.setStatus(status);

				return productDao.update(update);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
