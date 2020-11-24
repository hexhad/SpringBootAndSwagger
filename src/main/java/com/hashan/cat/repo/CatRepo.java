package com.hashan.cat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashan.cat.model.CatModel;

public interface CatRepo extends JpaRepository<CatModel, Integer> {

}
