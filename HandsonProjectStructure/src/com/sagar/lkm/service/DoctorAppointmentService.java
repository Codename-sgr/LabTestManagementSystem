package com.sagar.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sagar.lkm.business.bean.AppointmentBean;

public interface DoctorAppointmentService {	
	public void addDoctorAppointment(AppointmentBean appointmentBean);
	public List<AppointmentBean> getAppointmentReport(Date fromDate,Date toDate) throws Exception;
	public Map<Integer, String> getDoctorDetails();
	
}