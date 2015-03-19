<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="rootPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M1 System</title>
<!-- <link href="css/lrtk.css" rel="stylesheet" typse="text/css"> -->
<!-- <link href="css/button.css" rel="stylesheet" type="text/css"> -->
<script src="js/js.js" type="text/javascript"></script>
<script src="js/updateIP.js" type="text/javascript"></script>
<script src="js/jquery.1.3.2.js" type="text/javascript"
	language="javascript"></script>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"
	language="javascript"></script>
<link href="css/sys_param.css" rel="stylesheet" type="text/css">
<script src="js/initAuth.js" type="text/javascript"></script>
<script src="js/event.js" type="text/javascript"></script>
<script src="js/tween.js" type="text/javascript"></script>
</head>
<script type="text/javascript" language="javascript">
	function show() {
		var divContent = document.getElementById("tab");
		divContent.style.display = "block";
	}
</script>
<body>
<!-- <div class="tabmain" id=""></div> -->
	<div class="tabmain" style="font-family: Arial;">
		<div id="outerWrap">
			<div id="sliderParent"></div>
			<div class="blueline" id="blueline" style="top: 0px;"></div>
			<ul class="tabGroup">
				<!-- 			遍历所有网卡名 -->
				<c:forEach items="${ipList}" var="ip" varStatus="status">
					<c:choose>
						<c:when test="${status.index==0}">
							<li class="tabOption selectedTab">LAN 1</li>
						</c:when>
						<c:otherwise>
							<li class="tabOption">LAN ${status.index+1}</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 				遍历网卡名结束 -->
				<li class="tabOption">Shutdown</li>
				<li class="tabOption">Restart</li>
			</ul>
			<div id="container">
				<div id="content">
<!-- 				遍历网卡 -->
				<c:forEach items="${ipList}" var="ip" varStatus="status">
				<c:choose >
				<c:when test="${status.index==0}">
				<div class="tabContent selectedContent"
						style="" >
						<table align="center">
						<tr><td>
						<fieldset style="width:900px;border: 2px solid; height: 250px;border-color: blue;" id="lan1Div">
							<legend style="margin-left: 15px;">
								LAN ${status.index+1}
							</legend>
							<div align="center">
							<form id="ipForm1" action="ip/updateIp.do" method="post" >
								<input name="nicName" value="${ip.nicName}" style="display: none">
								<input name="nicId" value="${status.index+1}" style="display: none">
								<table width="335" height="124" align="center">
									<tr>
										<td>IP Address(I)</td>
										<td><input name="ipAddress" size="15"
											value="${ip.ipAddress}"></td>
									</tr>
									<tr>
										<td>Subnet Mask(U)</td>
										<td><input name="mask" size="15" value="${ip.mask}"></td>
									</tr>
									<tr>
										<td>Default Gateway(D)</td>
										<td><input name="defaultGeteWay" size="15"
											value="${ip.defaultGeteWay}"></td>
									</tr>
									<tr>
										<td>Preferred DNS server(P)</td>
										<td><input name="firstDNS" size="15"
											value="${ip.firstDNS}"></td>
									</tr>
									<tr>
										<td height="21">Secondary DNS server(A)</td>
										<td style="display: inline"><input name="ip"
											size="15" value="${ip.subDNS}">
											<div id="ip1Results" style="display: none"></div></td>
									</tr>
								</table>
								<br /> <input type="button" onclick="updateIp(this)" value="Submit and Restart" align="left" style="outline-color:bule;height:25px;"/>
							</form>
							</div>
						</fieldset>
						</td></tr>
						</table>
						<div  id="tipMessagelan1" align="center" style="display:none"><img alt="" src="images/loading.GIF"><p/>
						<font size="3" style="font-style:normal;">IP is changing，windows is restarting，please login in 1 miute</font></div>
					</div>	
				</c:when>
					<c:otherwise>
					<div class="tabContent"
						style="height: 200px;" >
						<table align="center">
						<tr><td>
						<fieldset style="border: 2px solid;width:900px;border-color: blue; height: 250px;">
							<legend style="margin-left: 15px;">
								LAN ${status.index+1}
							</legend>
							<div align="center">
							<form id="ipForm" action="ip/updateIp.do" method="post">
								<input name="nicName" value="${ip.nicName}" style="display: none">
								<input name="nicId" value="${status.index+1}" style="display: none">
								<table width="335" height="124" align="center">
									<tr>
										<td>IP Address(I)</td>
										<td><input name="ipAddress" size="15"
											value="${ip.ipAddress}"></td>
									</tr>
									<tr>
										<td>Subnet Mask(U)</td>
										<td><input name="mask" size="15" value="${ip.mask}"></td>
									</tr>
									<tr>
										<td>Default Gateway(D)</td>
										<td><input name="defaultGeteWay" size="15"
											value="${ip.defaultGeteWay}"></td>
									</tr>
									<tr>
										<td>Preferred DNS server(P)</td>
										<td><input name="firstDNS" size="15"
											value="${ip.firstDNS}"></td>
									</tr>
									<tr>
										<td height="21">Secondary DNS server(A)</td>
										<td style="display: inline"><input name="ip"
											size="15" value="${ip.subDNS}">
											<div id="ip1Results" style="display: none"></div></td>
									</tr>
								</table>
								<br /> <input type="button" onclick="updateIp(this)" value="submit" align="left" style="outline-color:bule;height:25px;width:80px;"/>
							</form>
							</div>
						</fieldset>
						</td></tr>
						</table>
					</div>
					</c:otherwise>
					</c:choose>
					</c:forEach>
<!-- 					遍历网卡结束 -->
					<!--  第二部分  -->
					
					<div class="tabContent"   >
						<fieldset style="border: 2px solid; border-color: blue; width:900px; height: 250px;" id="shutdownDiv">
							<legend style="margin-left: 15px;">
								Shutdown
							</legend>
							<div align="center">
							<br /> 
							Are you sure to shutdown?<p/>&nbsp;<p/>
							<input type="button" value="shutdown"
								onclick="shutdownOs()" align="left" style="outline-color:bule;height:30px;width:80px;">
							</div>
						</fieldset>
						<div  id="tipMessageShutdown" align="center" style="display:none"><img alt="" src="images/loading.GIF"><p/>
						<font size="3" style="font-style:normal;">Shutdown...</font></div>
					</div>
					<div class="tabContent" >
						<fieldset style="border: 2px solid; width:900px; border-color: blue;height: 250px;" id="restartDiv">
							<legend style="margin-left: 15px;">
								Restart
							</legend>
							<div align="center">
							<br />
							Are you sure to restart? <p/>&nbsp;<p/>
							<input type="button" value="Restart" style="outline-color:bule;height:30px;width:80px;"
								onclick="restartOs()" align="left">
								</div>
						</fieldset>
						<div  id="tipMessageRestart" align="center" style="display:none"><img alt="" src="images/loading.GIF"><p/>
						<font size="3" style="font-style:normal;">System is restarting,please login in 1 minute</font></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var container = document.getElementById('container');
		var content = document.getElementById('content');
		var oDivs = DOM.children(content, "div");
		oDivs[0].st = 0;
		for (var i = 1; i < oDivs.length; i++) {
			oDivs[i].st = oDivs[i].offsetTop;
		}
		var oLis = DOM.getElesByClass("tabOption");
		var flag = 0;
		var upFlag = oLis.length;
		;
		(function() {
			function fn(e) {
				e = e || window.event;
				if (e.wheelDelta) {
					var n = e.wheelDelta;
				} else if (e.detail) {
					var n = e.detail * -1;
				}
				if (n > 0) {
					container.scrollTop -= 12;
				} else if (n < 0) {
					container.scrollTop += 12;
				}
				slider.style.top = container.scrollTop * container.offsetHeight
						/ content.offsetHeight + "px";
				slider.offsetTop
						* (content.offsetHeight / container.offsetHeight);
				var st = container.scrollTop;
				if (st > this.preSt) {
					for (var j = 0; j < oLis.length; j++) {
						if (st < oDivs[j].st)
							break;
					}
					if (oLis[j - 2] && this.preLi !== j) {
						if ((j) > (flag + 1)) {
							DOM.removeClass(oLis[j - 2], "selectedTab");
							DOM.addClass(oLis[j - 1], "selectedTab");
							animate(blueline, {
								top : (j - 1) * 48
							}, 500, 2);
						}
					}
					flag = j - 1;
				} else if (st < this.preSt) {
					for (var j = oLis.length - 1; j >= 0; j--) {
						if (st > oDivs[j].st)
							break;
					}
					if (oLis[j + 2] && this.preLi !== j) {
						if (flag === undefined)
							return;
						if ((j) < (flag)) {
							for (var k = 0; k < oLis.length; k++) {
								DOM.removeClass(oLis[k], "selectedTab");
							}
							;
							DOM.addClass(oLis[j + 1], "selectedTab");
							animate(blueline, {
								top : (j + 1) * 48
							}, 500, 2);
							upFlag = j + 1;
						}
					}
				}
				this.preSt = st;
				if (e.preventDefault)
					e.preventDefault();
				return false;
			}
			container.onmousewheel = fn;
			if (container.addEventListener)
				container.addEventListener("DOMMouseScroll", fn, false);
			slider = document.createElement('span');
			slider.id = "slider";
			slider.style.height = container.offsetHeight
					* (container.offsetHeight / content.offsetHeight) + "px";
			sliderParent.appendChild(slider);
			on(slider, "mousedown", down);
			var blueline = document.getElementById("blueline");
			function changeTab() {
				var index = DOM.getIndex(this);
				for (var i = 0; i < oLis.length; i++) {
					DOM.removeClass(oLis[i], "selectedTab");
				}
				DOM.addClass(this, "selectedTab");
				animate(container, {
					scrollTop : oDivs[index].st
				}, 500, 1);
				var t = oDivs[index].st * container.offsetHeight
						/ content.offsetHeight;
				animate(slider, {
					top : t
				}, 500);
				animate(blueline, {
					top : index * 48
				}, 500, 2);
			}
			var tabPannel1 = document.getElementById("outerWrap");
			var oLis = DOM.children(DOM.children(tabPannel1, "ul")[0], "li");
			for (var i = 0; i < oLis.length; i++) {
				oLis[i].onclick = changeTab;
			}
			;
		})();
	</script>
</body>
</html>