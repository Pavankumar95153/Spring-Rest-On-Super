package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class Controller {
	
	List<SuperMarket> theSuper;
	@PostConstruct
	public void loadData() {
		theSuper = new ArrayList<>();
		theSuper.add(new SuperMarket("SOAP","Rexona"));
		theSuper.add(new SuperMarket("Oil", "GroundNut"));
		theSuper.add(new SuperMarket("Paste","Dabur red"));
	}

	@GetMapping("//super")
	public List<SuperMarket> getSuperMarketList(){
		
		return theSuper;
	}
	@GetMapping("//super/{superid}")
	public SuperMarket getsuper(@PathVariable int superid ) {
		
		if(superid >theSuper.size()||superid<0) {
			throw new SuperNotFound("Unable to get the product--"+superid);
		}
		return theSuper.get(superid);
	}
	

}
