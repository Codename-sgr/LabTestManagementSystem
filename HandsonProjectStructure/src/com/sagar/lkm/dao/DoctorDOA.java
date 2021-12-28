package com.sagar.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.lkm.entity.DoctorEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = DoctorEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface DoctorDOA {
	@Query(name = "TEST.query_findAll")
	List<DoctorEntity> findAll();
}
