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

import com.sndi.admin.dao.TFonctionRepository;
import com.sndi.admin.entities.TFonction;

@Controller
@RequestMapping(value="/Fonction")
public class FonctionController {
	@Autowired
	private TFonctionRepository tfonctionRepository;
	@RequestMapping(value="/List")
	public String list(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
            @RequestParam(name="motCle",defaultValue="") String mc) {
    Page<TFonction> PageFonctions=tfonctionRepository
                .chercherFonction("%"+mc+"%", new PageRequest(p, 10));
    int pageCount= PageFonctions.getTotalPages();
    model.addAttribute(" PageFonctions", PageFonctions);
    int[] pages=new int[pageCount];
    for(int i=0;i<pageCount;i++) pages[i]=i;
    model.addAttribute("pages",pages);
    model.addAttribute("PageFonctions",PageFonctions);
    model.addAttribute("pageCourante",p);
    model.addAttribute("motCle",mc);
    return"pages/FonctionList";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String operateurForm(Model model) {	
		model.addAttribute("fonction",new TFonction());
		return"pages/FonctionForm";
	}
	
	@RequestMapping(value="/SaveFonction",method=RequestMethod.POST)
	public String save(@Valid TFonction fonc,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/FonctionForm";
		}
		tfonctionRepository.save(fonc);
		return"redirect:List";
	}
	
	@RequestMapping(value="/supprimer")
	 public String supprimer(Long id) {	
		tfonctionRepository.delete(id);
		return"redirect:List";
    }
	
	@RequestMapping(value="/edit")
	 public String edit(Long id,Model model) {	
		TFonction fonc=tfonctionRepository.getOne(id);
		model.addAttribute("fonction",fonc);
		return"pages/FonctionEdit";
   }
	
	@RequestMapping(value="/UpdateFonction",method=RequestMethod.POST)
	public String update(@Valid TFonction fonc,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/FonctionEdit";
		}
		tfonctionRepository.save(fonc);
		return"redirect:List";
	}
} 
