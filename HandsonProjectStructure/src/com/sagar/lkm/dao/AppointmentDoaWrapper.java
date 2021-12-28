package com.sagar.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.lkm.business.bean.AppointmentBean;
import com.sagar.lkm.business.bean.DoctorBean;
import com.sagar.lkm.entity.AppointmentEntity;
import com.sagar.lkm.entity.DoctorEntity;

@Repository
@Transactional(value = "txManager")
public class AppointmentDoaWrapper {

	@Autowired
	private DoctorDOA doctorDOA;

	@Autowired
	private AppointmentDOA appointmentDOA;

	@PersistenceContext
	private EntityManager entityManager;

	public void saveAppointment(AppointmentBean appointmentBean) {
		AppointmentEntity entity = convertAppointmentBeanToEntity(appointmentBean);
		AppointmentEntity retEntity = appointmentDOA.save(entity);

	}

	public List<AppointmentBean> getAppointmentDeatilsByDateRange(Date fromDate, Date toDate) {
		Query query = entityManager
				.createQuery("select t from AppointmentEntity t where t.visitDate between ?1 and ?2");
		query.setParameter(1, fromDate);
		query.setParameter(2, toDate);
		List<AppointmentEntity> entityList = query.getResultList();
		List<AppointmentBean> beanList = new ArrayList<AppointmentBean>();
		for (AppointmentEntity entity : entityList) {
			AppointmentBean bean = convertAppointmentEntityToBean(entity);
			beanList.add(bean);
		}
		return beanList;
	}

	public List<DoctorBean> getDoctorList() {
		List<DoctorEntity> entityList = doctorDOA.findAll();
		List<DoctorBean> beanList = new ArrayList<DoctorBean>();
		for (DoctorEntity entity : entityList) {
			DoctorBean bean = convertDoctorEntityToBean(entity);
			beanList.add(bean);
		}
		return beanList;
	}

	// Utility Methods.......
	public static AppointmentBean convertAppointmentEntityToBean(AppointmentEntity entity) {
		AppointmentBean customerBean = new AppointmentBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}

	public static DoctorBean convertDoctorEntityToBean(DoctorEntity entity) {
		DoctorBean customerBean = new DoctorBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}

	public static AppointmentEntity convertAppointmentBeanToEntity(AppointmentBean bean) {
		AppointmentEntity entity = new AppointmentEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

	public static DoctorEntity convertDoctorBeanToEntity(DoctorBean bean) {
		DoctorEntity entity = new DoctorEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

}
