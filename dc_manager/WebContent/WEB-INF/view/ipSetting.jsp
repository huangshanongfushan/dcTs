<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="rootPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
function updateVoip() {
var enablePort0 ;
var enablePort1 ;
var rtpTimeoutEnable;
var rtpTimeout;
var rtcpQos;
if (document.getElementById("enablePort0").checked) {
	enablePort0 = 0;
	} else {
		enablePort0 = 1;
	}
if (document.getElementById("enablePort1").checked) {
	enablePort1 = 0;
	} else {
		enablePort1 = 1;
	}
if(document.getElementById("rtpTimeoutEnable").checked){
	rtpTimeoutEnable =0;
}else{
	rtpTimeoutEnable=1;
}
if(document.getElementById("rtcpQos").checked){
	rtcpQos =0;
}else{
	rtcpQos=1;
}
rtpTimeout = $("#rtpTimeout").val();
var monitorProt0Selected = $("#monitorProt0Selected").val();
var monitorProt1Selected = $("#monitorProt1Selected").val();
$.ajax({
		url : "system/updateVoip.do",
		type : "POST",
		dataType : "text",
		data : {
			"rtpEnable" : rtpTimeoutEnable,
			"rtpTimeOut" : rtpTimeout,
			"rtcpQos" : rtcpQos,
			"monitorPort0Enable": enablePort0,
			"monitorPort1Enable":enablePort1,
			"monitor0Selected":monitorProt0Selected,
			"monitor1Selected":monitorProt1Selected
		},
		success : function(responseText) {
			alert("Success");
		},
		error : function() {
			alert("Fail");
		}
	});
	

}
</script>
</head>
<body>
<div id="container" style="font-family: Arial;">
<div id="content">
<table align="CENTER">
<tr >
<td >
<fieldset style="width: 900px;border-color: blue;" >
 <legend style="margin-left: 15px;">Information</legend>
<div id="board1" >
								<span>Board Type:${voIPSmart.boardType }</span> <span style="padding-left: 100px">Board Version:${voIPSmart.boardVersion}</span> 
								<span style="padding-left: 100px">Board Build:${voIPSmart.boadrdBuild}</span><p/>
<!-- 								monitoring0 -->
								<p/>
								<fieldset style="border: 1px solid; width: 600px;border-color: blue;">
							<legend style="margin-left: 15px;">
								Monitoring Port0
							</legend>
							<table align="center" width="870px">
							<tr >
							<c:choose>
							<c:when test="${voIPSmart.monitorPort0Enable==0 }">
							<td style="padding: 10px"><input type="radio" id="enablePort0" name="inputEnable0" value="0" checked="checked">Disable</td>
							<td style="padding: 10px"><input type="radio" name="inputEnable0" value="1" >Enable</td>
							</c:when>
							<c:otherwise>
							<td style="padding: 10px"><input type="radio" id="enablePort0" name="inputEnable0" value="0" >Disable</td>
							<td style="padding: 10px"><input type="radio" name="inputEnable0" value="1" checked="checked">Enable</td>
							</c:otherwise>
							</c:choose>
							<td style="padding: 10px">Adapter: 
							
							<select id="monitorProt0Selected">
							<c:forEach var="netCard" items="${voIPSmart.port0NicList }">
							<c:choose>
							<c:when test="${voIPSmart.monitorPort0Selected.serviceName==netCard.serviceName }">
							<option value="${netCard.serviceName }" selected="selected">${netCard.description }</option>
							</c:when>
							<c:otherwise>
							<option value="${netCard.serviceName }">${netCard.description }</option>
							</c:otherwise>
							</c:choose>
							</c:forEach>
							</select></td>
							</tr>
							</table>
						</fieldset>
						<!-- 							monitoring1 -->
						<p/>
							<fieldset style="border: 1px solid; width: 600px; border-color: blue;">
							<legend style="margin-left: 15px;">
								Monitoring Port1
							</legend>
							<table align="center"  width="870px">
							<tr >
							<c:choose>
							<c:when test="${voIPSmart.monitorPort1Enable==0 }">
							<td style="padding: 10px"><input type="radio" id="enablePort1" name="inputEnable1" value="0"  checked="checked">Disable</td>
							<td style="padding: 10px"><input type="radio" name="inputEnable1" value="1" >Enable</td>
							</c:when>
							<c:otherwise>
							<td style="padding: 10px"><input type="radio" id="enablePort1" name="inputEnable1" value="0" >Disable</td>
							<td style="padding: 10px"><input type="radio" name="inputEnable1" value="1" checked="checked">Enable</td>
							</c:otherwise>
							</c:choose>
							<td style="padding: 10px">Adapter: 
							<select id="monitorProt1Selected">
							<c:forEach var="netCard" items="${voIPSmart.port1NicList }">
							<c:choose>
							<c:when test="${voIPSmart.monitorPort1Selected.serviceName==netCard.serviceName }">
							<option value="${netCard.serviceName }" selected="selected">${netCard.description }</option>
							</c:when>
							<c:otherwise>
							<option value="${netCard.serviceName }">${netCard.description }</option>
							</c:otherwise>
							</c:choose>
							</c:forEach>
							</select></td>
							</tr>
							</table>
						</fieldset>
<!-- 						monitoring1結束 -->
<!-- rtptime开始 -->
<p/>
						<fieldset style="border: 1px solid; width: 600px;border-color: blue; ">
							<legend style="margin-left: 15px;">
								Passive NetWork Settings
							</legend>
							<table align="center" width="870px">
							<tr>
							<td >RTP Timeout</td>
							<c:choose>
							<c:when test="${voIPSmart.rtpEnable==0 }">
							<td >
							<input type="radio" id="rtpTimeoutEnable" name="rtpTimeoutEnable" value="0" checked="checked"/>Disable</td>
							<td style="padding: 10px">
							<input type="radio" name="rtpTimeoutEnable" value="1"/>Enable</td>
							</c:when>
							<c:otherwise>
							<td >
							<input type="radio" id="rtpTimeoutEnable" name="rtpTimeoutEnable" value="0"/>Disable</td>
							<td style="padding: 10px">
							<input type="radio" name="rtpTimeoutEnable" value="1" checked="checked"/>Enable</td>
							</c:otherwise>
							</c:choose>
							
							<td style="padding: 10px">Time: <input name="rtpTimeout" id="rtpTimeout" value="${voIPSmart.rtpTimeOut }">ms</td>
							</tr>
							<tr>
							<td >RTCP QoS</td>
							<c:choose>
							<c:when test="${voIPSmart.rtcpQos==0 }">
							<td ><input type="radio" id="rtcpQos" name="rtcpQos" value="0" checked="checked"/>Disable</td>
							<td style="padding: 10px">
							<input type="radio" name="rtcpQos" value="1"/>Enable</td>
							</c:when>
							<c:otherwise>
							<td ><input type="radio" id="rtcpQos" name="rtcpQos" value="0" />Disable</td>
							<td style="padding: 10px">
							<input type="radio" name="rtcpQos" value="1" checked="checked"/>Enable</td>
							</c:otherwise>
							</c:choose>
						<td style="padding: 10px"></td>
							</tr>
						</table>
						</fieldset>
<!-- 						rtptime结束 -->
								</div>
								</fieldset>
								</td>
								</tr>
								<tr align="center">
								<td>
								<input type="button" value="Apply" onclick="updateVoip()" style="width: 60px; height: 25px;"></input> 
								<input type="button" value="Cancel" style="width: 60px; height: 25px;"><p/>
								Setting will take effect after reboot<p/>
								</td>
								</tr>
								</table>
								</div>
								</div>
</body>

</html>