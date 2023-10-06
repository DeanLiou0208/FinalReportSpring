package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleSpeciesDao;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PetArticleSpeciesAjaxService {
	@Autowired
	private PetArticleSpeciesDao petArticleSpeciesDao;
	
	public List<PetArticleSpeciesBean> findAll(){
		List<PetArticleSpeciesBean> findAll = petArticleSpeciesDao.selects();
		return findAll;
	}
	public PetArticleSpeciesBean findBySpciesId(Integer id) {
		PetArticleSpeciesBean findspeciesId= petArticleSpeciesDao.select(id);
		return findspeciesId;
	}
}
