<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="rootPath.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<title>Insert title here</title>
<link href="css/manager.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript">
	function updatePbx() {
		var tdm;
		var gciIndex;
		var configurationId = $("#configurationId").val();
		if (document.getElementById("ulaw").checked) {
			tdm = 0;
		} else {
			tdm = "FFFFFFFF";
		}
		if (document.getElementById("gciIndex").checked) {
			gciIndex = 0;
		} else {
			gciIndex = 1;
		}
		$.ajax({
			url : "system/updatePbx.do",
			type : "POST",
			dataType : "text",
			data : {
				"tdm" : tdm,
				"gciIndex" : gciIndex,
				"configurationId":configurationId
			},
			success : function(responseText) {
				alert("Sucess");
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
		<c:forEach items="${pbxSmartControlList}" var="pbxsmart" end="0">
		<input id="configurationId" value="${pbxsmart.configurationId}" style="display: none">
			<table align="center">
				<tr>
					<td>
						<fieldset style="width: 900px;border-color: blue;" >
							<legend style="margin-left: 15px;">Information</legend>
							<table id="board0">
								<tr>
									<!-- 左侧 -->
									<td>
										<table width="800px">
											<tr>
												<td>Board Number : ${pbxsmart.boardNumber }</td>
												<td>PCI Bus No :${pbxsmart.busNo }</td>
												<td>PCI Slot No :${pbxsmart.slotNo }</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td></td>
											</tr>
											<tr>
												<td>Board Type : LD2409</td>
												<td>Total Channels : ${pbxsmart.totalChannels }</td>
												<td>Serial Number : ${pbxsmart.serialNumber }</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
												<td></td>
											</tr>
											<tr>
												<td>Firware Version :</td>
												<td rowspan="5" colspan="2">
													<!-- 	存放tdm encoding 和 gci index --> <!-- 						存放tdm encoding 和 gci index结束 -->
												</td>
											</tr>
										</table>
									</td>
									<!-- 右侧 -->
									<td style="width: 137px; padding-top: 38px; margin-left: 30px;">
									</td>
								</tr>
							</table>
							<fieldset style="border: 1px solid;border-color: blue;">
								<legend style="margin-left: 15px;">Common </legend>
								<table width="870px" align="center">
									<tr>
										<td valign="middle" align="center">TDM Encoding :<c:choose>
												<c:when test="${pbxsmart.tdmEncoding==0}">
													<input id="ulaw" type="radio" name="law" checked="checked" />&nbsp;u-law  
												<input id="alaw" type="radio" name="law" />&nbsp;A-law 
												</c:when>
												<c:otherwise>
													<input id="ulaw" type="radio" name="law">&nbsp;u-law  
												<input id="alaw" type="radio" name="law" checked="checked" />&nbsp;A-law 
													<br />
												</c:otherwise>
											</c:choose>
										</td>
										<td valign="middle" align="center">GCI Starting Index :<c:choose>
												<c:when test="${pbxsmart.gciStartIndex==0 }">
													<input id="gciIndex" type="radio" name="Index"
														checked="checked" />&nbsp;0 
												<input type="radio" name="Index" />&nbsp;1
												</c:when>
												<c:otherwise>
													<input id="gciIndex" type="radio" name="Index" />&nbsp;0
												<input type="radio" name="Index" checked="checked" />&nbsp;1
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</table>
							</fieldset>
						</fieldset>
					</td>
				</tr>
				<tr align="center">
					<td><input type="button" value="Apply"
						style="width: 60px; height: 25px;" onclick="updatePbx()" /> <input
						type="button" value="Cancel" style="width: 60px; height: 25px;"></input>
						<p /> <font size="2">Setting will take effect after reboot</font>
					</td>
				</tr>
			</table>
			</c:forEach>
		</div>
	</div>
</body>
</html>