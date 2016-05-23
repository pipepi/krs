package com.unity6d.krs.util.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.google.gson.Gson;

public class AjaxResponseUtil {
	/**
	 * 一般用于返回jsonp的json消息
	 * @param response
	 * @param jsonCallback
	 * @param responseData
	 */
	public static void jsonCallback(HttpServletResponse response,String jsonCallback, Map<String, Object> responseData){
		String msg = createJson(responseData);
		msg = jsonCallback + "(" + msg + ")";
		
		// 写入response
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(msg);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据 format参数，返回不同格式的消息
	 * @param response
	 * @param format:json,xml
	 * @param responseData
	 */
	public static void returnData(HttpServletResponse response, String format, Map<String, Object> responseData) {
		String msg = null;
		if (format.equals("json")) {
			msg = createJson(responseData);
		} else if(format.equals("xml")){
			msg = createXml(responseData);
		} 
		
		// 写入response
		returnData(response,msg);
	}
	/**
	 * 返回Map格式的json消息
	 * @param response
	 * @param returnData
	 */
	public static void returnData(HttpServletResponse response, Map<String,Object> returnData){
		returnData(response, createJson( returnData ));
	}
	
	public static void returnData(HttpServletResponse response, String msg) {
		// 写入response
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(msg);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
		}
	}
	
	
	private static String createXml(Map<String, Object> responseData){
		StringBuilder sb = new StringBuilder();

		sb.append("<data>");
		for (String key : responseData.keySet()) {
			sb.append("<").append(key).append(">");
			sb.append(responseData.get(key));
			sb.append("</").append(key).append(">");
		}
		sb.append("</data>");

		Document doc = null;
		try {
			doc = DocumentHelper.parseText(sb.toString());
		} catch (DocumentException e) {
			return null;
		}
		return doc.asXML();
	}

	
	public static String createJson(Map<String, Object> responseData){
		//return JsonEncoder.encode(responseData);
		Gson gson = new Gson();
		return gson.toJson(responseData);
	}
}
