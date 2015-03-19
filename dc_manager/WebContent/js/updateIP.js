/**
 * 网卡1Ip修改
 */
function updateIp(a) {
	var jButton = $(a);
	var jIpform = jButton.parent();
	var dataString = jIpform.serialize();
	$.ajax({
		type : "POST",
		url : "updateIp.do",
		data : dataString,
		dataType : "text",
		success : function(data) {
			if (data == "success") {
				if(jIpform.attr("id")=="ipForm1"){
					$("#lan1Div").hide();
					$("#tipMessagelan1").show();
				}
			} else {
				alert("Fail!");
			}
		}
	});
}

function restartOs() {
	$.ajax({
		type : "POST",
		url : "restartOs.do",
		dataType : "text",
		success : function(data) {
			if (data == "success") {
					$("#restartDiv").hide();
					$("#tipMessageRestart").show();
			} else {
				alert("Fail!");
			}
		}
	});
}

function shutdownOs() {
	$.ajax({
		type : "POST",
		url : "shutdown.do",
		dataType : "text",
		success : function(data) {
			if (data == "success") {
					$("#shutdownDiv").hide();
					$("#tipMessageShutdown").show();
			} else {
				alert("Fail");
			}
		}
	});
}