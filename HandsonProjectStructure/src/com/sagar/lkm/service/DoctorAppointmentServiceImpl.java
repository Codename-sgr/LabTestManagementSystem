package com.sagar.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.lkm.business.bean.AppointmentBean;
import com.sagar.lkm.business.bean.DoctorBean;
import com.sagar.lkm.dao.AppointmentDoaWrapper;

@Service
public class DoctorAppointmentServiceImpl implements DoctorAppointmentService{
	
	@Autowired
	private AppointmentDoaWrapper daoWrapper;

	@Override
	public void addDoctorAppointment(AppointmentBean appointmentBean) {
		// TODO Auto-generated method stub
		daoWrapper.saveAppointment(appointmentBean);
		
		
	}

	@Override
	public List<AppointmentBean> getAppointmentReport(Date fromDate, Date toDate) throws Exception{
		// TODO Auto-generated method stub
		
		List<AppointmentBean> beanList=daoWrapper.getAppointmentDeatilsByDateRange(fromDate, toDate);
		if(beanList==null || beanList.size()==0) {
			throw new Exception("No record found in the given date range");
		}
		return beanList;
		
	}

	@Override
	public Map<Integer, String> getDoctorDetails() {
		
		// TODO Auto-generated method stub
		List<DoctorBean> doctorbeanList=daoWrapper.getDoctorList();
		Map<Integer, String> doctorMap=new HashMap<Integer,String>();
		for(DoctorBean bean:doctorbeanList){
			doctorMap.put(bean.getDoctorId(),bean.getDoctorName()+"-"+bean.getSpeciality());
		}
		return doctorMap;
	}
	
}
