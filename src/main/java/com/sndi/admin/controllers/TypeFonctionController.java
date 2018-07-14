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
import com.sndi.admin.dao.TTypeFonctionRepository;
import com.sndi.admin.entities.TTypeFonction;

@Controller
@RequestMapping(value="/typeFonction")
public class TypeFonctionController {
	@Autowired
	private TTypeFonctionRepository ttypeFonctionRepository;
	@RequestMapping(value="/List")
	public String list(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
            @RequestParam(name="motCle",defaultValue="") String mc) {
    Page<TTypeFonction> PageTypeFonctions=ttypeFonctionRepository
                .chercherTypeFonction("%"+mc+"%", new PageRequest(p, 10));
    int pageCount=PageTypeFonctions.getTotalPages();
    model.addAttribute("PageTypeFonctions",PageTypeFonctions);
    int[] pages=new int[pageCount];
    for(int i=0;i<pageCount;i++) pages[i]=i;
    model.addAttribute("pages",pages);
    model.addAttribute("PageTypeFonctions",PageTypeFonctions);
    model.addAttribute("pageCourante",p);
    model.addAttribute("motCle",mc);
    return"pages/TypeFonctionList";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String TypeFonctionForm(Model model) {	
		model.addAttribute("typeFonction",new TTypeFonction());
		return"pages/TypeFonctionForm";
	}
	
	@RequestMapping(value="/SaveTypeFonction",method=RequestMethod.POST)
	public String save(@Valid TTypeFonction tfonct,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/TypeFonctionForm";
		}
		ttypeFonctionRepository.save(tfonct);
		return"redirect:List";
	}
	
	@RequestMapping(value="/supprimer")
	 public String supprimer(Long id) {	
		ttypeFonctionRepository.delete(id);
		return"redirect:List";
    }
	
	@RequestMapping(value="/edit")
	 public String edit(Long id,Model model) {	
		TTypeFonction tfonct=ttypeFonctionRepository.getOne(id);
		model.addAttribute("operateur",tfonct);
		return"pages/TypeFonctionEdit";
   }
	
	@RequestMapping(value="/UpdateTypeFonction",method=RequestMethod.POST)
	public String update(@Valid TTypeFonction tfonct,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/TypeFonctionEdit";
		}
		ttypeFonctionRepository.save(tfonct);
		return"redirect:List";
	}
} 
