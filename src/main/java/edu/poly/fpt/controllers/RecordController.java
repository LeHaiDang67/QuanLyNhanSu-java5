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


import edu.poly.fpt.models.Record;
import edu.poly.fpt.models.Staff;
import edu.poly.fpt.services.RecordService;

@Controller
@RequestMapping("/records")
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/list")
    public String list(ModelMap model)
    {
		model.addAttribute("records", recordService.findAll());
		return "records/list";
    }
	
	@GetMapping("/add")
	public String add(ModelMap model)
	{
		Record record=new Record();
		
		model.addAttribute("record", record);
		
		return "records/addOrEdit";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,  Record record )
	{
        recordService.save(record);
		model.addAttribute("record", record);
		return list(model);
	}
	
	@ModelAttribute(name = "staffs")
	public List<Staff> getListRecord()
	{
		
		return recordService.findAllStaffs();
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable (name = "id") Integer id, ModelMap model)
	{
	    Optional<Record> optRecord = recordService.findById(id);
	    if(optRecord.isPresent())
	    {
	    	model.addAttribute("record", optRecord.get());
	    }
	    else {
	    	return list(model);
	    }
	    return "records/addOrEdit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable (name = "id") Integer id)
	{
		recordService.deleteById(id);
		
		return list(model);
	}
	
	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam (defaultValue = "") String reason)
	{
		List<Record> list = recordService.findByReasonLikeOrderByReason(reason);
		model.addAttribute("records", list);
		return "records/list";
	}
	
}
