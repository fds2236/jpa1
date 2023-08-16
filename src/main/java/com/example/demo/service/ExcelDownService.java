package com.example.demo.service;
//
//import org.springframework.stereotype.Service;
//import com.example.demo.repository.ApiRequestListRepository;
//
//import com.example.demo.entity.ApiRequestList;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ExcelDownService {
//	
//    private final ApiRequestListRepository apiRequestListRepository;
//    public ExcelDownService(ApiRequestListRepository apiRequestListRepository) {
//        this.apiRequestListRepository = apiRequestListRepository;
//    }
//
//    // 임시데이터 삽입
//    public void insertData(int numberOfInserts) {
//        List<ApiRequestList> apiRequestList = new ArrayList<>();
//        for (int i = 0; i < numberOfInserts; i++) {
//            ApiRequestList requestList = new ApiRequestList();
//            String apiName = "test" + (i + 1);
//            requestList.setOrgId(10001L + i);
//            requestList.setApiId(1L + i);
//            requestList.setApiName(apiName);
//            requestList.setCallCount(0L); // 초기화
//            requestList.setItemCount(0L); 
//            apiRequestList.add(requestList);
//        }
//        apiRequestListRepository.saveAll(apiRequestList);
//    }
//    
//    
//    // 데이터 조회
//   public List<ApiRequestList> selectData(){
//	  return apiRequestListRepository.findAllByOrderByApiIdDesc();
//   }
//   
//   public long countData(){
//	  return apiRequestListRepository.count();
//   }
//   
//    
//    
//   
//}


import org.springframework.stereotype.Service;

import com.example.demo.entity.ApiRequestList;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


import java.util.List;

@Service
public class ExcelDownService {

    @PersistenceContext
    private EntityManager entityManager;
    
    
    public List<ApiRequestList> selectData(Long orgId, String apiName) {
        String jpql = "SELECT arl FROM ApiRequestList arl WHERE 1 = 1";

        if (orgId != null) {
            jpql += " AND arl.orgId = :orgId";
        }

        if (apiName != null && !apiName.isEmpty()) {
            jpql += " AND arl.apiName LIKE :apiName";
        }

        TypedQuery<ApiRequestList> query = entityManager.createQuery(jpql, ApiRequestList.class);

        if (orgId != null) {
            query.setParameter("orgId", orgId);
        }

        if (apiName != null && !apiName.isEmpty()) {
            query.setParameter("apiName", "%" + apiName + "%");
        }

        return query.getResultList();
    }
//        
//    public List<ApiRequestList> selectData2(Long orgId, String apiName) {
//        JPAQueryFactory queryFactory;
//        QApiRequestList qApiRequestList = QApiRequestList.apiRequestList;
//
//        return queryFactory.selectFrom(qApiRequestList)
//                .where(qApiRequestList.orgId.eq(orgId)
//                        .and(qApiRequestList.apiName.likeIgnoreCase("%" + apiName + "%")))
//                .fetch();
//    }
    

    
    


}

