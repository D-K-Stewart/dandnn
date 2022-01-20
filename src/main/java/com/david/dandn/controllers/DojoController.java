package com.david.dandn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.dandn.models.Dojo;
import com.david.dandn.models.Ninja;
import com.david.dandn.services.DojoService;
import com.david.dandn.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	@RequestMapping("/dojos")
   public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
	   List<Dojo> dojos = dojoService.getAllDojos();
	   model.addAttribute("dojos", dojos);
	   		return "newd.jsp";
   }
	
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        
    	System.out.println(result);
    	
    	if (result.hasErrors()) {
            return "newd.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/ninjas";
        }
    }
   
	@RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        List<Ninja> ninjas = ninjaService.allNinjas();
        model.addAttribute("ninjas", ninjas);
        return "index.jsp";
    }
    
    
}
