package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;
import tw.ispan.eeit168.forum.service.PetArticleSpeciesAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class PetArticleSpeciesAjaxController {
	@Autowired
	private PetArticleSpeciesAjaxService petArticleSpeciesAjaxService;
	@GetMapping(path = "/ArticleSpecies")
	public String findAll() {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleSpeciesBean> findAll = petArticleSpeciesAjaxService.findAll();
		for(PetArticleSpeciesBean petArticleSpecies :findAll ) {
			JSONObject item = new JSONObject()
					.put("id", petArticleSpecies.getId())
					.put("species", petArticleSpecies.getSpecies());
			array = array.put(item);
			}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@GetMapping(path = "/ArticleSpecies/{id}")
	public String finBySpecies(@PathVariable(name = "id") Integer id) {
		JSONObject responseJson = new JSONObject();
		PetArticleSpeciesBean bySpeciesId = petArticleSpeciesAjaxService.findBySpciesId(id);
		if(bySpeciesId!=null) {
			JSONObject item = new JSONObject()
					.put("id", bySpeciesId.getId())
					.put("species", bySpeciesId.getSpecies());
			responseJson.put("species",item);
		}
		return responseJson.toString();
	}
	}
