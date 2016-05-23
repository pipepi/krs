<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="IE=edge" />
	<style>
		@-ms-viewport { width:device-width; }
		@media only screen and (min-device-width:800px) { html { overflow:hidden; } }
		html { height:100%; }
		body { height:100%; overflow:hidden; margin:0; padding:0; font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#FFFFFF; background-color:#000000; }
	</style>
	<script type="text/javascript">var ctx = "${ctx}";</script>
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="netconfig" value="${panoconfig}"></input>
<input type="hidden" name="edit" value="${edit }"></input>
<script src="${ctx}/resource/vtour/tour.js"></script>

<div id="pano" style="width:100%;height:100%;">
	<noscript><table style="width:100%;height:100%;"><tr style="vertical-align:middle;"><td><div style="text-align:center;">ERROR:<br/><br/>Javascript not activated<br/><br/></div></td></tr></table></noscript>
	<script>
		embedpano({swf:"${ctx}/resource/vtour/tour.swf", xml:"${ctx}/resource/vtour/tour.xml", target:"pano", html5:"prefer", mobilescale:1.0, passQueryParameters:true});
	</script>
</div>
<script type="text/javascript" src="${ctx}/resource/js/plugin/jquery.js" ></script>
<!-- <script type="text/javascript" src="${ctx}/resource/js/net_data.js" ></script> -->
<script type="text/javascript">
	function saveConfigSet(){
		var _config = $("input[name='netconfig']").val();
		console.log(_config);
		var _url = ctx+"/panoconfig/update";
		$.post(_url,{config:_config},function(data){
			if(data){
				  var datas = data.substring(data.indexOf('{')+1,data.lastIndexOf('}'));
		  		  datas = "{" + datas + "}";
		  		  var attr = eval('('+datas+')');
		  		  console.log(attr);
			}
		});
	}
	
</script>
</body>
</html>