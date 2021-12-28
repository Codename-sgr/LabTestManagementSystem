package com.sagar.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentBean {
	private int appointmentId;
	
	@NotEmpty(message = "Patient Name is Required")
	private String patientName;
	
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@NotNull(message = "Visit Date is Required")
	private Date visitDate;
	
	@NotNull(message = "Select the doctor name")
	private int doctorId;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
	
}
