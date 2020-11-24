package com.hashan.cat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashan.cat.model.CatModel;
import com.hashan.cat.repo.CatRepo;

@Service
public class CatService {
	
	@Autowired
	private CatRepo repo;
	
	public List<CatModel> allCats(){
		return repo.findAll();
	}
	
	public CatModel saveCatstoDb(CatModel cat) {
		return repo.save(cat);
	}
	
	public Optional<CatModel> searchCat(int id) {
		return repo.findById(id);
	}
	
	public String deleteCat(int id) {
		String msg;
		try {
			repo.deleteById(id);
			msg = "Cat Removed";
		} catch (Exception e) {
			msg = "Cat Error";
		}
		
		return msg;
		
	}
	
}
