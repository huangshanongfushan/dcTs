<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="rootPath.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="SHORTCUT ICON" href="icons/favicon.ico">
<title>SmartBOX</title>
 <base href="<%=basePath%>">
<link href="css/zen-componentsCompatible.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/dStandard.css" rel="stylesheet" type="text/css">
<link href="css/extended.css" rel="stylesheet"type="text/css">
<link href="css/shou.css" rel="stylesheet"type="text/css">

<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="js/main.js"></script>
<!-- <script src="js/zh_CN.js"></script> -->
<script src="js/initAuth.js" type="text/javascript"></script>
<script src="js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>

<body style="background-color: rgb(46,49,56);" onLoad="bodyOnLoad();init_DC_Main();" onUnload="if(this.bodyOnUnload)bodyOnUnload();" id="change" class="accountTab" onFocus="if(this.bodyOnFocus)bodyOnFocus();" onbeforeunload="if(this.bodyOnBeforeUnload){var s=bodyOnBeforeUnload();if(s)return s;}">
<div style="wdith:1366px;height:650px;">

<!-- top start-->
<div style="wdith:1366px;height:130px;">
	<jsp:include page="MainFrame/top.jsp"></jsp:include>
</div>
<!-- top end-->

<div class="bodyDiv brdPalette" style="height:450px;width:1366px;margin-top: -27px;" >
<table class="outer" id="bodyTable" border="0" cellpadding="0" cellspacing="0" width="1146px" height="430px">
<tbody><tr>

<td class="oRight" id="bodyCell" width="1366px" height="450px">
<iframe id="ifrObj" width="1366px" height="450px" style="border: 0" scrolling="auto"></iframe>
<script language="javascript" type="text/javascript">
function bodyOnLoad(){
	 if (document.getElementById('sidebarDiv')){
		 	Sidebar.prototype.theSidebar = new Sidebar(document.getElementById('sidebarDiv'), true, true,false);
	 };
}
</script>
</td>

</tr>
</tbody>
</table>
<!-- bottom  start-->
<div style="width:1366px; height:70px;">
<jsp:include page="MainFrame/bottom.jsp"></jsp:include>
</div>
<!-- bottom end-->

</div>
</div>
</body>
</html>