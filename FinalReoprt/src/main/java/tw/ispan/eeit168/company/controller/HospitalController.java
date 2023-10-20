package tw.ispan.eeit168.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.company.domain.HospitalBean;
import tw.ispan.eeit168.company.service.HospitalServices;

@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class HospitalController {

	@Autowired
	private HospitalServices hospitalservices;

	@GetMapping(path = "/hospital")
	public List<HospitalBean> hospotal() {

		List<HospitalBean> hospital = hospitalservices.hospotal();

		if (!hospital.isEmpty() && hospital.size() != 0) {
			return hospital;
		} else {
			return null;
		}

	}

}
