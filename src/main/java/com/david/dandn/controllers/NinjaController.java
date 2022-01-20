package com.david.dandn.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.dandn.models.Dojo;
import com.david.dandn.models.Ninja;
import com.david.dandn.services.DojoService;
import com.david.dandn.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
//	@GetMapping("/")
//	   public String index(Model model) {
//		List<Dojo> dojos = dojoService.getAllDojos();
//		model.addAttribute("dojos", dojos);
//		return "index.jsp";
//		
//	}
	
	@RequestMapping("/ninjas")
	   public String home(@ModelAttribute("ninja") Ninja ninja, Model model) {
	   List<Ninja> ninjas = ninjaService.allNinjas();
	  
	   List<Dojo> dojos = dojoService.getAllDojos();
	 
	   dojos.forEach(d->System.out.println(d));
       model.addAttribute("dojos", dojos);
	   		return "newn.jsp";
	   }
	
    @RequestMapping(value="/ninjas", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        
    	System.out.println(result);
    	
    	if (result.hasErrors()) {
    		return "index.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninjas";
        }
    }
    @RequestMapping("/ninjas/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Ninja ninja = ninjaService.findNinja(id);
        model.addAttribute("ninja", ninja);
        return "index.jsp";
    }
    
    

}


