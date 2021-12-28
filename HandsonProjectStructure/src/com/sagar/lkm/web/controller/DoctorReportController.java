package com.sagar.lkm.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.lkm.business.bean.AppointmentBean;
import com.sagar.lkm.business.bean.DateRangeBean;
import com.sagar.lkm.service.DoctorAppointmentService;
import com.sagar.lkm.service.DoctorAppointmentServiceImpl;

@Controller
public class DoctorReportController {

	@Autowired
	private DoctorAppointmentServiceImpl doctorService;
	
	@RequestMapping(value = "loadAppointmentReport")
	public ModelAndView loadAppointmentReport() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AppointmentReport");
		mv.addObject("dateRangeObj",new DateRangeBean());
		return mv;
		
	}
	
	@RequestMapping(value = "showAppointmentReport")
	ModelAndView showAppointmentReport(@ModelAttribute("dateRangeObj") DateRangeBean dateRange) throws Exception{
		List<AppointmentBean> listAppointment=doctorService.getAppointmentReport(dateRange.getFromDate(), dateRange.getToDate());
		ModelAndView mv=new ModelAndView();
		mv.addObject("appointmentReportList",listAppointment);
		mv.setViewName("ShowAppointmentDetails");
		return mv;
		
	}	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}
	
}
