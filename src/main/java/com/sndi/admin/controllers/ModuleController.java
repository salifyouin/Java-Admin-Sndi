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

import com.sndi.admin.dao.SysModuleRepository;

import com.sndi.admin.entities.SysModule;
import com.sndi.admin.entities.TOperateur;



@Controller
@RequestMapping(value="/module")
public class ModuleController {
	@Autowired
	private SysModuleRepository sysModuleRepository;
	
	@RequestMapping("/List")
	public String module(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
            @RequestParam(name="motCle",defaultValue="") String mc) {	
		 Page<SysModule> PageModules=sysModuleRepository
	                .chercherModule("%"+mc+"%", new PageRequest(p, 10));
	    int pageCount=PageModules.getTotalPages();
	    model.addAttribute("PageModules",PageModules);
	    int[] pages=new int[pageCount];
	    for(int i=0;i<pageCount;i++) pages[i]=i;
	    model.addAttribute("pages",pages);
	    model.addAttribute("PageModules",PageModules);
	    model.addAttribute("pageCourante",p);
	    model.addAttribute("motCle",mc);
				return"pages/ModuleList";		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String ModuleForm(Model model) {	
		model.addAttribute("module",new SysModule());
		return"pages/ModuleForm";
	}
	
	@RequestMapping(value="/SaveModule",method=RequestMethod.POST)
	public String save(@Valid SysModule mod,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/ModuleForm";
		}
		sysModuleRepository.save(mod);
		return"redirect:List";
	}
	
	@RequestMapping(value="/supprimer")
	 public String supprimer(Long id) {	
		sysModuleRepository.delete(id);
		return"redirect:List";
   }
	
	@RequestMapping(value="/edit")
	 public String edit(Long id,Model model) {	
		SysModule mod=sysModuleRepository.getOne(id);
		model.addAttribute("module",mod);
		return"pages/ModuleEdit";
  }
	
	@RequestMapping(value="/UpdateModule",method=RequestMethod.POST)
	public String update(@Valid SysModule mod,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/ModuleEdit";
		}
		sysModuleRepository.save(mod);
		return"redirect:List";
	}



}
