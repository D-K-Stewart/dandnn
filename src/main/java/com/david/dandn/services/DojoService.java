package com.david.dandn.services;

	
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.david.dandn.models.Dojo;
import com.david.dandn.repositories.DojoRepository;

@Service
public class DojoService {
private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the books
    public List<Dojo> getAllDojos() {
		// TODO Auto-generated method stub
		return dojoRepository.findAll();
	}
    // creates a book
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    // retrieves a book
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
//    public Dojo updateDojo(Long id,
//						String name,
//						String vendor,
//						double amount,
//						String desc) {
//    	Dojo foundDojo = findDojo(id);
//    	foundDojo.setName(name);
//  
//    	return DojoRepository.save(foundDojo);
//
//    }
//    public void deleteDojo(Long id) {
//    	dojoRepository.deleteById(id);
//    }
//	public List<Dojo> allDojos() {
//		// TODO Auto-generated method stub
//		return dojoRepository.findAll();
//	}



}

