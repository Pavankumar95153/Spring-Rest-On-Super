package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class Controller {

	List<SuperMarket> theSuper;

	@PostConstruct
	public void loadData() {
		theSuper = new ArrayList<>();
		theSuper.add(new SuperMarket("SOAP", "Rexona"));
		theSuper.add(new SuperMarket("Oil", "GroundNut"));
		theSuper.add(new SuperMarket("Paste", "Dabur red"));
	}

	

	@GetMapping("/super")
	public List<SuperMarket> getSuperMarketList() {

		return theSuper;
	}
	@PostMapping("/super")
	public SuperMarket addSuperMarket(@RequestBody SuperMarket supermarket) {
		theSuper.add(supermarket);
		return supermarket;
	}

	@GetMapping("/super/{superid}")
	public SuperMarket getsuper(@PathVariable int superid) {

		if (superid > theSuper.size() || superid < 0) {
			throw new SuperNotFound("Unable to get the product--" + superid);
		}
		return theSuper.get(superid);
	}
	@DeleteMapping("/super/{superid}")
	public String deleteSuperproduct(@PathVariable int superid) {
		SuperMarket supermarket = theSuper.get(superid);
		theSuper.remove(supermarket);
		
		return "Deleted successfully";
	}
	@PutMapping("/super")
	public SuperMarket UpdateSuperMarket(@RequestBody SuperMarket supermarket) {
		theSuper.add(supermarket);
		return supermarket;
	}
	

}
