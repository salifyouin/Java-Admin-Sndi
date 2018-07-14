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
import com.sndi.admin.dao.TOperateurRepository;
import com.sndi.admin.entities.TAssignation;
import com.sndi.admin.entities.TOperateur;

@Controller
@RequestMapping(value="/Assignation")
public class AssignationController {
	@Autowired
	private TAssignationRepository tassignationRepository;
	@RequestMapping(value="/List")
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
            @RequestParam(name="motCle",defaultValue="") String mc) {
    Page<TAssignation> PageAssignations=tassignationRepository
                .chercherAssignations("%"+mc+"%", new PageRequest(p, 10));
    int pageCount=PageAssignations.getTotalPages();
    model.addAttribute("PageAssignations",PageAssignations);
    int[] pages=new int[pageCount];
    for(int i=0;i<pageCount;i++) pages[i]=i;
    model.addAttribute("pages",pages);
    model.addAttribute("PageAssignations",PageAssignations);
    model.addAttribute("pageCourante",p);
    model.addAttribute("motCle",mc);
    return"pages/AssignationList";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String AssignationForm(Model model) {	
		model.addAttribute("assignation",new TAssignation());
		return"pages/AssignationForm";
	}
	
	@RequestMapping(value="/SaveAssignation",method=RequestMethod.POST)
	public String save(@Valid TAssignation ass,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/AssignationForm";
		}
		tassignationRepository.save(ass);
		return"redirect:List";
	}
	
	@RequestMapping(value="/supprimer")
	 public String supprimer(Long id) {	
		tassignationRepository.delete(id);
		return"redirect:List";
    }
	
	@RequestMapping(value="/edit")
	 public String edit(Long id,Model model) {	
		TAssignation ass=tassignationRepository.getOne(id);
		model.addAttribute("assignation",ass);
		return"pages/AssignationEdit";
   }
	
	@RequestMapping(value="/UpdateAssignationr",method=RequestMethod.POST)
	public String update(@Valid TAssignation ope,BindingResult bindingResult) {	
		if (bindingResult.hasErrors()) {
			return"pages/AssignationEdit";
		}
		tassignationRepository.save(ope);
		return"redirect:List";
	}
} 
