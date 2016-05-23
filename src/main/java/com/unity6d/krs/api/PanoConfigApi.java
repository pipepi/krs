package com.unity6d.krs.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unity6d.krs.model.PanoConfig;
import com.unity6d.krs.service.PanoConfigService;
import com.unity6d.krs.util.ajax.AjaxResponseUtil;

@Controller
@RequestMapping("/api/panoconfig")
public class PanoConfigApi {
	@Autowired
	PanoConfigService panoConfigService;
	@RequestMapping(value="/query",produces=MediaType.APPLICATION_JSON_VALUE)
	public void query(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		int id = 1;
		PanoConfig panoConfig = panoConfigService.query(id);
		AjaxResponseUtil.returnData(response, panoConfig.config);
		return;
	}
}
