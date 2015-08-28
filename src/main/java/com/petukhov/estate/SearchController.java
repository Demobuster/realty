package com.petukhov.estate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Charsets;
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

	@RequestMapping(value = "/addProperty", method = RequestMethod.GET)
	public ModelAndView addPropertyPage() {
		ModelAndView mav = new ModelAndView("addProperty", "command",
				new PropModel());
		return mav;
	}

	@RequestMapping(value = "/addPropertyToDB", method = RequestMethod.POST)
	public ModelAndView addPropertyToDB(
			@ModelAttribute("PropModel") PropModel propInfo) throws Exception {

		propertyService.addProperty(propInfo.getPropAddress(),
				propInfo.getPropDescription(), propInfo.getPropFee());

		byte[] utf8AddressBytes = propInfo.getPropAddress().getBytes(Charsets.UTF_8);
		byte[] utf8DescriptionBytes = propInfo.getPropDescription().getBytes(Charsets.UTF_8);
		byte[] utf8FeeBytes = propInfo.getPropFee().getBytes(Charsets.UTF_8);

		String utf8ResultAddress = new String(utf8AddressBytes, Charsets.UTF_8);
		String utf8ResultDescription = new String(utf8DescriptionBytes, Charsets.UTF_8);
		String utf8ResultFee = new String(utf8FeeBytes, Charsets.UTF_8);

		ModelAndView mav = new ModelAndView("done");
		mav.addObject("address", utf8ResultAddress);
		mav.addObject("description", utf8ResultDescription);
		mav.addObject("fee", utf8ResultFee);

		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPage() {
		ModelAndView mav = new ModelAndView("search");
		return mav;
	}

	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchText") String searchText)
			throws Exception {
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
