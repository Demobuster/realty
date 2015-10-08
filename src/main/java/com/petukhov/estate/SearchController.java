package com.petukhov.estate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;
import com.petukhov.estate.service.HireService;
import com.petukhov.estate.domain.Prop;
import com.petukhov.estate.domain.PropModel;
import com.petukhov.estate.service.PropertyService;

@Controller
public class SearchController {

	@Autowired
	private HireService hireService;

	@Autowired
	private PropertyService propertyService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPage() {
		ModelAndView mav = new ModelAndView("search");
		return mav;
	}

	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchText") String searchText) throws Exception {
		
		try { 
			Preconditions.checkArgument(!"".equals(searchText));
		} catch (IllegalArgumentException iae) {
			return new ModelAndView("property");
		}
		
		List<Prop> allFound = propertyService.searchForProperty(searchText);
		List<PropModel> propModels = new ArrayList<PropModel>();

		for (Prop p : allFound) {

			PropModel pm = new PropModel();

			pm.setPropAddress(p.getAddress());
			pm.setPropDescription(p.getDescription());
			pm.setPropFee(p.getFee());
			pm.setId(p.getId());

			propModels.add(pm);
		}

		ModelAndView mav = new ModelAndView("foundProp");
		mav.addObject("foundProp", propModels);
		
		return mav;
	}

}
