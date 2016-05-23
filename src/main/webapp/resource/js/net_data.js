/**
 * 加载网络配置数据
 */
var krpanoplugin = function(){
	var local = this,krpano=null,plugin=null;
	local.registerplugin=function(krpanointerface,pluginpath,pluginobject){
		krpano = krpanointerface;
		plugin = pluginobject;
		// register methods
		plugin.loadconfig = loadconfig;
		plugin.updateconfig = updateconfig;
		plugin.edit = edit;
	}
	local.unloadplugin = function(){
		plugin = null;
		krpano = null;
	}
	// public methods
	function loadconfig(varName){
		krpano.set(varName,$("input[name='netconfig']").val());
	}
	function updateconfig(varName){
		$("input[name='netconfig']").val(varName);
		saveConfigSet();
	}
	function edit(varName){
		krpano.set(varName,$("input[name='edit']").val());
	}
}