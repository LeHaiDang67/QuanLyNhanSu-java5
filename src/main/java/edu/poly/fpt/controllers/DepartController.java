package edu.poly.fpt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.fpt.models.Depart;
import edu.poly.fpt.services.DepartService;

@Controller
@RequestMapping("/departs")
public class DepartController {
	@Autowired
	private DepartService departService;
	
	@GetMapping("/add")
	public String add(ModelMap model)
	{
		model.addAttribute("depart", new Depart());
		return "departs/addOrEdit";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,Depart depart)
	{
		departService.save(depart);
		model.addAttribute("depart", depart);
		
		return list(model);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable (name = "id") Integer id, ModelMap model)
	{
	    Optional<Depart> optDepart = departService.findById(id);
	    if(optDepart.isPresent())
	    {
	    	model.addAttribute("depart", optDepart.get());
	    }
	    else {
	    	return list(model);
	    }
		return "departs/addOrEdit";
	}
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable (name = "id") Integer id)
	{
		departService.deleteById(id);
		
		return list(model);
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model)
	{
		List<Depart> list = (List<Depart>) departService.findAll();
		model.addAttribute("departs", list);
		return "departs/list";
	}
	
	@RequestMapping("/find")
	public String find(ModelMap model,@RequestParam(defaultValue = "") String name)
	{   
		List<Depart> list=departService.findByNameLikeOrderByName(name);
	    model.addAttribute("departs", list);
		return "departs/find";
		
	}
	
}
