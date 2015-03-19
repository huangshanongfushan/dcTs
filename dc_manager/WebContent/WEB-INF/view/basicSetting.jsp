<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="rootPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M1 System</title>
<base href="<%=basePath%>">
<!-- <link href="css/lrtk.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="css/button.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="css/sys_param.css" rel="stylesheet" type="text/css"> -->
<style type="text/css">
fieldset { border-color:blue;} 
</style>
<script src="js/js.js" type="text/javascript"></script>
<script src="js/jquery.1.3.2.js" type="text/javascript"
	language="javascript"></script>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	language="javascript"></script>
<script src="js/initAuth.js" type="text/javascript"></script>
<script src="js/event.js" type="text/javascript"></script>
<script src="js/tween.js" type="text/javascript"></script>
</head>
<script type="text/javascript" language="javascript">
	
</script>
<body>
	<div id="content1" style="font-family: Arial;">
		<fieldset style="width: 1250px;border-color: blue" >
			<legend>Information</legend>
			<div id="baseDiv"
				style="width: 580px; padding-left: 5px; float: left;"
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue;" >
					<legend>Basic</legend>
					<table style="BORDER-COLLAPSE: collapse" cellPadding=1
						width="550px" align=center id="base" height="170px">
						<tr>
							<td>Driver Version</td>
							<td>${smartSystem.driverVersion }</td>
						</tr>
						<tr>
							<td>Driver Build</td>
							<td>${smartSystem.driverBuild }</td>
						</tr>
						<tr>
							<td>ControlPanel Version(R)</td>
							<td>n.a</td>
						</tr>
						<tr>
							<td>DC Panel Version(R):</td>
							<td>${smartSystem.dcPanelVersion}</td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div id="dc2" style="width: 580px; padding-left: 50px; float: left;"
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue">
					<legend>Smartworks Ntidrv.log</legend>
					<table style="BORDER-COLLAPSE: collapse;" cellPadding=1
						width="550px" align=center id="dc2" height="170px">
						<tr>
							<td>Trace Level</td>
							<td>7</td>
						</tr>
						<tr>
							<td>Trace Max Files</td>
							<td>50</td>
						</tr>
						<tr>
							<td>Trace Max File Size:</td>
							<td>1000000</td>
						</tr>
						<tr>
							<td>Trace PollInterval:</td>
							<td>20</td>
						</tr>
					</table>
				</fieldset>
			</div>

			<!-- 	<div id="DC1"
				style="width: 580px; padding-left: 5px; float: left; padding-top: 10px;"
				class="mainDiv">
				<fieldset style="border: 1px solid;">
					<legend>License Information</legend>
					<form>
						<table style="BORDER-COLLAPSE: collapse" cellPadding=1
							width="550px" align=center height="170px">
							<tr>
								<td>Load License
									<p /> Please specify a license file
									<p /> <input disabled="disabled" type="text" id="input1">
									<input class="dc_all_button"
									style="padding-left: 15px; padding-right: 15px;" type="button"
									id="btn1" onclick="myfile.click();" value="Browse"> <br />
									<input id="myfile" type="file" name="importuser"
									onchange="filechange();input1.value=this.value;" size="100"
									style="display: none; width: 180px; height: 22px; font-family: Verdana, Geneva, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 11px;" />
									<p /> <input type="button" value="load"
									style="width: 60px; height: 25px;">
								</td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div>
			<div id="dc2" style="width: 550px;padding-left: 50px;float:left;" class="mainDiv" >

			<div id="common"
				style="width: 580px; padding-left: 50px; padding-top: 10px; float: left;"
				class="mainDiv">
				<fieldset style="border: 1px solid;">
					<legend>Configuration file</legend>
					<form>
						<table style="BORDER-COLLAPSE: collapse" cellPadding=1
							width="550px" align=center height="170px">
							<tr>
								<td>Load License
									<p /> Please specify a license file
									<p /> <input disabled="disabled" type="text" id="input1">
									<input class="dc_all_button"
									style="padding-left: 15px; padding-right: 15px;" type="button"
									id="btn1" onclick="myfile.click();" value="Browse"> <br />
									<input id="myfile" type="file" name="importuser"
									onchange="filechange();input1.value=this.value;" size="100"
									style="display: none; width: 180px; height: 22px; font-family: Verdana, Geneva, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 11px;" />
									<p /> <input type="button" value="load"
									style="width: 60px; height: 25px;">
								</td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div> -->
<!-- 上传 common配置文件开始 -->
			<div id="commonConfFile"
				style="width: 580px; padding-left: 5px; float: left; padding-top: 10px;"
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue;">
					<legend>Upload Common Configurations</legend>
					<iframe src="commonUpload.jsp" scrolling="no" height="300px" width="550px" frameborder="0"></iframe>
				</fieldset>
			</div>
<!-- 			上传 common配置文件结束 -->
<!-- 			上传 pbx配置文件开始 -->
			<div id="pbxConfFile" style="width: 580px; padding-left: 50px; float: left;padding-top: 10px "
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue;">
					<legend>Upload Pbx Configurations</legend>
					<iframe src="pbxUpload.jsp" scrolling="no" height="300px" width="550px" frameborder="0"></iframe>
				</fieldset>
			</div>
<!-- 			上传 pbx配置文件结束 -->
<!-- 上传ngx配置文件开始 -->
		<div id="ngxConfFile"
				style="width: 580px; padding-left: 5px; float: left; padding-top: 10px;"
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue;">
					<legend>Upload Ngx Configurations</legend>
					<iframe src="ngxUpload.jsp" scrolling="no" height="300px" width="550px" frameborder="0"></iframe>
				</fieldset>
		</div>
<!-- 上传ngx配置文件结束 -->
<!-- 上传voip配置文件开始 -->
<div id="voipConfFile" style="width: 580px; padding-left: 50px; float: left;padding-top: 10px "
				class="mainDiv">
				<fieldset style="border: 1px solid;border-color: blue;">
					<legend>Upload Voip Configurations</legend>
					<iframe src="pbxUpload.jsp" scrolling="no" height="300px" width="550px" frameborder="0"></iframe>
				</fieldset>
			</div>
<!-- 			上传voip配置文件结束 -->
<!-- 			<div id="commonDownload" -->
<!-- 				style="width: 580px; padding-left: 5px; float: left; padding-top: 10px;" -->
<!-- 				class="mainDiv"> -->
<!-- 				<fieldset style="border: 1px solid;border-color: blue;"> -->
<!-- 					<legend>Configuration file(Common)</legend> -->
<!-- 					<form> -->
<!-- 						<table style="BORDER-COLLAPSE: collapse" cellPadding=1 -->
<!-- 							width="550px" align=center height="170px"> -->
<!-- 							<tr> -->
<!-- 								<td>Dowload -->
<!-- 									<p /> <a href="conf/downloadCommonConf.do">Click here to -->
<!-- 										download common configuration files</a> -->
<!-- 								</td> -->
<!-- 							</tr> -->
<!-- 						</table> -->
<!-- 					</form> -->
<!-- 				</fieldset> -->
<!-- 			</div> -->
		</fieldset>
	</div>
</body>
</html>