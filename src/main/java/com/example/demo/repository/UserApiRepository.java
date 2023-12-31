package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserApi;

public interface UserApiRepository extends JpaRepository<UserApi, Long>{
	List<UserApi> findAllByOrderByUserId();

}
