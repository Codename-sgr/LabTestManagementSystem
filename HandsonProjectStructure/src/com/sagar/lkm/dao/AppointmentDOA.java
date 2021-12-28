package com.sagar.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.lkm.entity.AppointmentEntity;
import com.sagar.lkm.entity.DoctorEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = AppointmentEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface AppointmentDOA {
	AppointmentEntity save(AppointmentEntity appointmentEntity);
}
