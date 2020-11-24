package com.hashan.cat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hashan.cat.model.CatModel;
import com.hashan.cat.repo.CatRepo;
import com.hashan.cat.service.CatService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "/rest/v2", tags = "Cat profile Controller")
@RequestMapping("/rest/v2")
@RestController
public class CatController {
	
	@Autowired
	private CatService service;
	
	@ApiOperation(value = "Fetch All Cats", response = CatModel.class)
	@ApiResponses(value = {
			@ApiResponse(code =200, message = "SUCCESS", response = CatModel.class),
			@ApiResponse(code =401, message = "UNAUTHORIZED"),
			@ApiResponse(code =403, message = "FORBIDDEN"),
			@ApiResponse(code =404, message = "NOT FOUND"),
	})
	@GetMapping("/cats")
	public List<CatModel> allCats(){
		List<CatModel> cats = new ArrayList<>();
		cats = service.allCats();
		return cats;
	}
	
	@ApiOperation(value = "Search Cats", response = CatModel.class)
	@GetMapping("/cats/{id}")
	public CatModel searchCat(@PathVariable int id){
		return service.searchCat(id).get();
	}
	
	@ApiOperation(value = "Add Cats", response = CatModel.class)
	@PostMapping("/addcats")
	public CatModel saveCats(@RequestBody CatModel cat){
		return service.saveCatstoDb(cat);
	}
	
	@ApiOperation(value = "Delete specific Cats", response = CatModel.class)
	@DeleteMapping("/deletecat/{id}")
	public String deleteCats(@PathVariable int id){
		return service.deleteCat(id);
	}
	
}
