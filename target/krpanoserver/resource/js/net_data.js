/**
 * 加载网络配置数据
 */
function loadConfig(){
	$.post(
		"",
		{},
		function (data){
		if(data){
			  var datas = data.substring(data.indexOf('{')+1,data.lastIndexOf('}'));
	  		  datas = "{" + datas + "}";
	  		  var attr = eval('('+datas+')');
	  		  $('textarea').val(attr);
		}
	});
}