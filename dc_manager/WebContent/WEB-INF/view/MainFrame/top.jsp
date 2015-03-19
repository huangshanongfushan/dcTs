<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fs"%>
<div class="bPageHeader" id="AppBodyHeader" style="width:1366px;height:130px;">
<table class="phHeader" id="phHeader" border="0" cellpadding="0" cellspacing="0">
<tbody>
<tr>
<td style="width:1006px;padding-left: 15px; font-weight: bold;">
	<div style="display:inline-block">
		<img style="width:295px;height:69px;" src="images/annlog-underlog.png" >
	</div>
</td>
<td style="width:360px;padding-bottom: 10px; font-weight: bold;">
<div style="height:48px;"></div>
<!--放时间-->
<h1 style="color:white">
	<label id="show"></label>
	&nbsp;
</h1>
<h1 style="color:white">
	<a href="#" style="color:white;text-decoration: none;"></a>
	&nbsp;
</h1>
 &nbsp;<a href="user/exit.do" style="font-weight: bold; color:white; text-decoration: none;" >
 Logoff</a>&nbsp;
<!-- 	<a  onclick="changehelp()" style="font-weight: bold; color:white; text-decoration: none;" > -->
<!-- 	Help</a> -->
</td>
</tr>
</tbody>
</table>

<div class="zen">
<nav>
<ul class="zen-inlineList zen-tabMenu" id="tabBar">
	<!-- class设置初始化时Tab选中项为Home -->
	<li class="zen-active" style="background-color: rgb(35,111,189);" id="Contact_Tab">
		<a href="javaScript:toWindows();" title="Windows"><img src="images/triangle16.png" id="windowArrow" >&nbsp;<spring:message code="Windows"></spring:message>&nbsp;&nbsp;&nbsp;&nbsp;</a>
	</li>
	<c:if test="${fs:length(managerCardInfo.pbxList)>0}">
		<li id="Account_Tab" style="margin: 0 0px;">
			<a href="javaScript:toPbx();" title="Analog"><img src="images/triangle16.png" id="pbxArrow" hidden="true">&nbsp;Analog Setting&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</li>
		</c:if>
		<c:if test="${fs:length(managerCardInfo.ngxList)>0}">
		<li id="Opportunity_Tab" style="margin: 0 0px;">
			<a href="javaScript:toNgx();" title="Digital" ><img src="images/triangle16.png" id="ngxArrow" hidden="true">&nbsp;Digital Setting&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</li>
		</c:if>
		<li id="report_Tab" style="margin: 0 0px;">
			<a href="javaScript:toVoIp();" title="VoIP" ><img src="images/triangle16.png" id="voipArrow" hidden="true">&nbsp;VoIP Setting&nbsp;&nbsp;&nbsp;</a>
		</li>
	
		<li id="Lead_Tab" style="margin: 0 0px;">
			<a href="javaScript:toBasic();" title="About"><img src="images/triangle16.png" id="basicArrow" hidden="true">&nbsp;About&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</li>
</ul>
</nav>
</div>
</div>