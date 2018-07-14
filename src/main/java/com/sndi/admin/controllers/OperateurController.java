package com.sndi.admin.controllers;


import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sndi.admin.dao.TMotdepassRepository;
import com.sndi.admin.dao.TOperateurRepository;
import com.sndi.admin.entities.TMotdepass;
import com.sndi.admin.entities.TOperateur;

import groovyjarjarasm.asm.commons.Method;

@Controller
@RequestMapping(value="/operateur")
public class OperateurController {
	@Autowired
	private TOperateurRepository toperateurRepository;
	@Autowired
	private TMotdepassRepository tmotdepassRepository;
	@RequestMapping(value="/List")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
            @RequestParam(name="motCle",defaultValue="") String mc) {
    Page<TOperateur> PageOperateurs=toperateurRepository
                .chercherOperateurs("%"+mc+"%", new PageRequest(p, 9));
    int pageCount=PageOperateurs.getTotalPages();
    model.addAttribute("PageOperateurs",PageOperateurs);
    int[] pages=new int[pageCount];
    for(int i=0;i<pageCount;i++) pages[i]=i;
    model.addAttribute("pages",pages);
    model.addAttribute("PageOperateurs",PageOperateurs);
    model.addAttribute("pageCourante",p);
    model.addAttribute("motCle",mc);
    List<TOperateur> oper=toperateurRepository.findAll();
    model.addAttribute("operateur",oper);
    return"pages/operateurList";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String operateurForm(Model model) {	
		model.addAttribute("operateur",new TOperateur());
		model.addAttribute("password",new TMotdepass());
		return"pages/operateurForm";
	}
	
	@RequestMapping(value="/SaveOperateur",method=RequestMethod.POST)
	public String save(TOperateur ope,TMotdepass mpass) {	
		toperateurRepository.save(ope);
		tmotdepassRepository.save(mpass);
		return"redirect:List";
	}
	
	@RequestMapping(value="/supprimer")
	 public String supprimer(Long id) {	
		toperateurRepository.delete(id);
		return"redirect:List";
    }
	
	@RequestMapping(value="/edit")
	 public String edit(Long id,Model model) {	
		TOperateur ope=toperateurRepository.getOne(id);
		model.addAttribute("operateur",ope);
		return"pages/operateurEdit";
   }
	
	@RequestMapping(value="/UpdateOperateur",method=RequestMethod.POST)
	public String update(@Valid TOperateur ope,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/operateurEdit";
		}
		toperateurRepository.save(ope);
		return"redirect:List";
	}
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public String menu(ModelMap modelMap) {
		modelMap.put("operateurs", toperateurRepository.findAll());
		return"pages/menu";
	}
} 
