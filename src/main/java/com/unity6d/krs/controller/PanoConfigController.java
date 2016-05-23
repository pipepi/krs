package com.unity6d.krs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unity6d.krs.model.PanoConfig;
import com.unity6d.krs.service.PanoConfigService;
import com.unity6d.krs.util.ajax.AjaxResponseUtil;

@Controller
@RequestMapping("/panoconfig")
public class PanoConfigController {
	@Autowired
	PanoConfigService panoConfigService;
	@RequestMapping(value="/query")
	public String query(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String config = request.getParameter("edit");
		boolean isEdit = config!=null&&config.equals("true")?true:false;
		int id = 1;
		PanoConfig panoConfig = panoConfigService.query(id);
		//AjaxResponseUtil.returnData(response, panoConfig.config);
		model.addAttribute("panoconfig", panoConfig.config);
		model.addAttribute("edit", isEdit);
		return "/config/edit";
	}
	@RequestMapping(value="/update")
	public void update(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		int id = 1;
		PanoConfig panoConfig = panoConfigService.query(id);
		String config = request.getParameter("config");
		panoConfig.config = config;
		panoConfigService.update(panoConfig);
		AjaxResponseUtil.returnData(response, "ok");
	}
}
