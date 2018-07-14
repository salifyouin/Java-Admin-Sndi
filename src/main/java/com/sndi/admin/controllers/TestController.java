package com.sndi.admin.controllers;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sndi.admin.dao.TAssignationRepository;
import com.sndi.admin.dao.TFonctionRepository;
import com.sndi.admin.dao.TOperateurRepository;
import com.sndi.admin.entities.TAssignation;
import com.sndi.admin.entities.TFonction;
import com.sndi.admin.entities.TMotdepass;
import com.sndi.admin.entities.TOperateur;

@Controller
@RequestMapping(value="/Test")
public class TestController {
	@Autowired
	private TOperateurRepository toperateurRepository;
   @Autowired
	private TFonctionRepository tfonctionRepository;

	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String index(Model model) {
	model.addAttribute("operateur",new TOperateur());
	model.addAttribute("fonction",new TFonction());
    return"pages/Test";
	}
	
	@RequestMapping(value="/SaveOperateur",method=RequestMethod.POST)
	public String save(TOperateur ope,TFonction fonc) {	
		toperateurRepository.save(ope);		
		tfonctionRepository.save(fonc);
		return"redirect:form";
} 
	}
