package com.temmytechie.coursems.storage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temmytechie.coursems.storage.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long>{
	
	Optional<ImageData> findByName(String fileName);
	
	

}
