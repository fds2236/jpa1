package com.example.demo.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserApi;
//import com.example.demo.entity.QUserApi;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@Repository
public class QueryUserApiRepository {
//    QUserApi userApi;
    private final JPAQueryFactory factory;
    private final EntityManager entityManager; 

    public QueryUserApiRepository(JPAQueryFactory factory, EntityManager entityManager) {
        this.factory = factory;
        this.entityManager = entityManager; 
//        this.userApi = QUserApi.userApi;

    }
//
//    public List<UserApi> findSearchUserApiList(
//            String userId, ZonedDateTime appCreatedDate, ZonedDateTime apiChangedDate,
//            ZonedDateTime contractRegisteredDate, String organizationName, String userName) {
//
//        BooleanBuilder builder = new BooleanBuilder();
//        if (userId != null) {
//            builder.and(userApi.userId.eq(userId)); 
//        }
//
//        if (appCreatedDate != null) {
//            builder.and(userApi.appCreatedDate.eq(appCreatedDate)); 
//        }
//
//        if (apiChangedDate != null) {
//            builder.and(userApi.apiChangedDate.eq(apiChangedDate)); 
//        }
//
//        if (contractRegisteredDate != null) {
//            builder.and(userApi.contractRegisteredDate.eq(contractRegisteredDate));
//        }
//
//        return factory.selectFrom(userApi) 
//                .where(builder)
//                .fetch();
//    }
    
    
}
