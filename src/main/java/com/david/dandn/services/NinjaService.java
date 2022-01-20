package com.david.dandn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.dandn.models.Ninja;
import com.david.dandn.repositories.NinjaRepository;

@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository NinjaRepository) {
        this.ninjaRepository = NinjaRepository;
    }
    // returns all the books
    public List<Ninja> allNinjas() {
		// TODO Auto-generated method stub
		return ninjaRepository.findAll();
	}
    // creates a book
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    // retrieves a book
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
   
	
    
//    public Ninja updateDojo(Long id,
//						String firstName,
//						String lastName,
//						Number age) {
//    	Ninja foundNinja = findNinja(id);
//    	foundNinja.setFirstName(firstName);
//    	foundNinja.setLastName(lastName);
//    	foundNinja.setAge(age);
//  
//    	return NinjaRepository.save(foundNinja);
//
//    }
//    public void deleteNinja(Long id) {
//    	ninjaRepository.deleteById(id);
//    }



}


