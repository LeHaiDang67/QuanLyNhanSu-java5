package edu.poly.fpt.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.poly.fpt.models.Depart;

import edu.poly.fpt.models.Staff;
import edu.poly.fpt.services.StaffService;

@Controller
@RequestMapping("/staffs")
public class StaffController {
	@Autowired
	private StaffService staffService;

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("staffs", staffService.findAll());
		return "staffs/list";
	}
	
	@GetMapping("/add")
	public String add(ModelMap model)
	{
		Staff staff=new Staff();
		
		model.addAttribute("staff", staff);
		
		return "staffs/addOrEdit";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,  Staff staff )
	{
        staffService.save(staff);
		model.addAttribute("staff", staff);
		return "staffs/addOrEdit";
	}
	
	@ModelAttribute(name = "departs")
	public List<Depart> getListDepart()
	{
		
		return staffService.findAllDeparts();
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable (name = "id") Long id, ModelMap model)
	{
		  Optional<Staff> a = staffService.findById(id);
		    if(a.isPresent())
		    {
		    	model.addAttribute("staff", a.get());
		    	// model.addAttribute("message", "Update is successful");
		    }
		    else {
		    	return list(model);
		    }
		   
		    return "staffs/addOrEdit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable (name = "id") Long id)
	{
		staffService.deleteById(id);
		
		return list(model);
	}
	
	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam (defaultValue = "") String name)
	{
		List<Staff> list = staffService.findByNameLikeOrderByName(name);
		model.addAttribute("staffs", list);
		return "staffs/list";
	}
	
}
