package com.sagar.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.lkm.business.bean.AppointmentBean;
import com.sagar.lkm.service.DoctorAppointmentService;
import com.sagar.lkm.service.DoctorAppointmentServiceImpl;

@Controller
public class DoctorAppointmentController {

	@Autowired
	private DoctorAppointmentService doctorService;
	
	@RequestMapping(value="/bookAppointmentForm.html",method=RequestMethod.GET)
	public ModelAndView createAppointment() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("appointmentBean",new AppointmentBean());
		mv.setViewName("AppointmentForm");
		return mv;
		
	}
	
	@RequestMapping(value="/addAppointment.html", method = RequestMethod.POST)
	ModelAndView processAppointmentForm(@Valid @ModelAttribute("appointmentBean") AppointmentBean bean,BindingResult result) {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("AppointmentForm");
		}else {
			doctorService.addDoctorAppointment(bean);
			mv.setViewName("Success");
			mv.addObject("message","Hi "+bean.getPatientName()+" your appointment is scheduled on "+bean.getVisitDate());
		}
		return mv;
		
	}
	
	@ModelAttribute("doctorList")
	public Map<Integer, String> getDoctorDetails() {
		return doctorService.getDoctorDetails();		
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
