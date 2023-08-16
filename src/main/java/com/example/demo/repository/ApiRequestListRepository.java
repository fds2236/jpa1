package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ApiRequestList;

@Repository
public interface ApiRequestListRepository extends JpaRepository<ApiRequestList, Long>{
	List<ApiRequestList> findAllByOrderByApiIdDesc();
//	Optional <ApiRequestList> findAllByOrderByApiIdDesc();

	

}
