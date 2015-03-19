<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="rootPath.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" style="background-color: rgb(235, 60, 0);">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartBOX</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="PageID" content="i5030.2.0">
<meta name="SiteID" content="10">
<meta name="ReqLC" content="2052">
<meta name="LocLC" content="2052">
<meta name="mswebdialog-newwindowurl" content="*">
<link rel="SHORTCUT ICON" href="icons/favicon.ico">
<!--<base href="https://login.microsoftonline.com/pp2020/">-->
<!--<base href=".">-->
<base href=".">
<link href="css/login.ltr.css" rel="stylesheet" type="text/css">
<!--[if lte IE 10]>
  <link href="https://secure.aadcdn.microsoftonline-p.com/aad/20.200.19625/css/login.ie.css" rel="stylesheet" type="text/css" />
  <![endif]-->
<!--[if lte IE 7]>
  <style type='text/css'>
    .ie_legacy { display: none; }
    body { background-color: #0072C6; }
  </style>
  <![endif]-->
<script type="text/javascript">
      if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
          var msViewportStyle = document.createElement("style");
          msViewportStyle.appendChild(
              document.createTextNode(
                  "@-ms-viewport{width:auto!important}"
              )
          );
          msViewportStyle.appendChild(
              document.createTextNode(
                  "@-ms-viewport{height:auto!important}"
              )
          );
          document.getElementsByTagName("head")[0].appendChild(msViewportStyle);
      }
      
      document.onkeydown = function (e) {
          e = e || event;
          if (e.keyCode == 13) {  //判断是否单击的enter按键(回车键)
              document.getElementById("cred_sign_in_button").click();
              return false;
          }
 }
//       验证输入
      function validateLogin()
      {
      	var username=$("#cred_userid_inputtext").val().trim();
      	var password=$("#cred_password_inputtext").val().trim();
      	if(username.length == 0){
      		document.getElementById("error_msg").innerHTML="Login ID can not be empty";
      		$("#cred_userid_inputtext").focus();
      		return false;
      	}
      	if(password.length == 0){
      		document.getElementById("error_msg").innerHTML="Password can not be empty";
      		$("#cred_password_inputtext").focus();
      		return false;
      	}
      	return true;
      }

      function login()
      {
    	  if(validateLogin())
    		  {
    	  		$("#credentials").submit();
    		  }
      }
    </script>
<script src="js/jquery.1.5.1.min.js" type="text/javascript"></script>
<script src="js/aad.login.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<style> 
body { display: none; }
</style>
</head>
<body style="display: block;">
<script>
    if (self == top) {
      var body = $('body');
      body.css('display', 'block');
    } else {
      top.location = self.location;
    }
  </script>
<div id="background_branding_container" class="ie_legacy" style="background: rgb(235, 60, 0);"> 
<img id="background_background_image" usemap="#planetmap"  src="images/login_photo.png" style="width: 966px; height: 735px; visibility: visible; display: block; background-color: rgb(235, 60, 0);">
<img src="images/home_page1.png" usemap="#planetmap" style="z-index: 3;position: absolute;left: 0;right: 0;width: 966px; height: 735px;" >
<map name ="planetmap">
    <area shape ="rect" coords ="42,123,143,222" alt="Sun" title="Log"/>
  <area shape ="rect" coords ="243,21,295,72"  alt="Mercury" title="ACD" />
  <area shape ="rect" coords ="192,171,293,271" alt="Venus" title="DIALER"/>
  <area shape ="rect" coords ="300,127,351,178"  alt="Venus" title="IVR"/>
  <area shape ="rect" coords ="300,278,400,326"  alt="Venus" title="BILLING"/>
</map>
<!--   <div id="auto_low_bandwidth_background_notification" class="smalltext">It looks like you're on a slow connection. We've disabled some images to speed things up.</div> -->
<!--   <div id="background_company_name_text" class="background_title_text" style="opacity: 0;">DupliCALL</div> -->
</div>
<div id="background_page_overlay" class="overlay ie_legacy" style="visibility: visible; display: none; background-color: rgb(235, 60, 0);" aria-hidden="true"> </div>
<div id="login_no_script_panel" class="login_panel" aria-hidden="true" style="display: none;">
  <table class="login_panel_layout" style="height: 100%;">
    <tbody>
      <tr class="login_panel_layout_row" style="height: 100%;">
        <td id="login_panel_left"></td>
        <td id="login_panel_center"></td>
        <td id="login_panel_right"></td>
      </tr>
    </tbody>
  </table>
</div>
<div id="login_panel" class="login_panel" style="display: block;">
  <table class="login_panel_layout" style="height: 100%;">
    <tbody>
      <tr class="login_panel_layout_row" style="height: 100%;">
        <td id="login_panel_left"></td>
        <td id="login_panel_center"><script type="text/javascript">
      $(document).ready(function () {
        if ($.support.cookies) {
          $('.login_inner_container').removeClass('no_display');
          $('.no_cookie').addClass('no_display');
        } else {
          $('.login_inner_container').addClass('no_display');
          $('.no_cookie').removeClass('no_display');
        }
        $("#cred_userid_inputtext").select();
      });
    </script>
          <div class="login_inner_container no_cookie no_display" aria-hidden="true">
            <div class="inner_container cred" style="height: 100%;">
              <div class="login_workload_logo_container"> <img id="login_workload_logo_image" class="workload_img" alt="SmartBOX" style="visibility: visible;" src="images/logohead.png"></div>
            </div>
          </div>
          <script type="text/javascript">
      $(document).ready(function () {
                Constants.DEFAULT_LOGO = 'images/logohead.png';
        Constants.DEFAULT_LOGO_ALT = 'login';
                        Constants.DEFAULT_ILLUSTRATION = 'images/login_photo.png';
        Constants.DEFAULT_BACKGROUND_COLOR = '#EB3C00';
                 
        Context.TenantBranding.workload_branding_enabled = true;
        User.UpdateLogo(Constants.DEFAULT_LOGO, Constants.DEFAULT_LOGO_ALT);
        User.UpdateBackground(Constants.DEFAULT_ILLUSTRATION, Constants.DEFAULT_BACKGROUND_COLOR);
                        Context.TenantBranding.whr_key = '';
                jQuery('img#logo_img').attr('src', '');
        Context.use_instrumentation = true; 
        User.moveFooterToBottom('250px');
      });
    </script>
          <div class="login_inner_container">
            <div class="inner_container cred" style="height: 100%;">
              <div class="login_workload_logo_container"></div>
              <div id="login_error_container" class="login_error_container"> </div>
              <ul class="login_cred_container">
                <li class="login_cred_field_container">
                  <form id="credentials" method="post" action="user/login.do">
				  <table>
				  <tr><td colspan=2 ><div id="error_msg" style="color: red;" class="normaltext"><spring:message code="${ErrorMessage}"></spring:message></div></td></tr>
				  <tr>
				  <td>
				  <img src="images/AD_Glyph_Footer_30x30.png">
				  </td>
				  <td>
                    <div id="cred_userid_container" class="login_textfield textfield"> <span class="input_field textfield">
                      <div class="input_border">
                        <input tabindex="1" id="cred_userid_inputtext" class="login_textfield textfield required email field normaltext" name="username" placeholder="LoginID"  name="login"  aria-label="login Id"  autocomplete="off" value="${username}">
                      </div>
                      </span> </div>
                    <div id="cred_password_container" class="login_textfield textfield" style="opacity: 1;"> <span class="input_field textfield">
                      <div class="input_border">
                        <input tabindex="2" id="cred_password_inputtext" class="login_textfield textfield required field normaltext" name="password" placeholder="Password" spellcheck="false" aria-label="password" alt="password" type="password" name="passwd" value="">
                      </div>
                      </span> </div>
					  </td>
					  <tr>
                   </table>
                  </form>
                </li>
                <li class="login_cred_options_container">
                  <div id="cred_kmsi_container" class="subtext normaltext"> <span class="input_field "> </span> </div>
                  <span id="cred_sign_in_button" tabindex="11" onclick="login()" class="button normaltext cred_sign_in_button refresh_domain_state disabled_button" role="button" style="opacity: 1;">LOGIN</span>
                  <div id="recover_container" class="subtext smalltext" style="opacity: 1;"> </div>
                </li>
                
              </ul>
            </div>
          </div>
         
          <div id="login_prefetch_container" class="no_display" aria-hidden="true"></div></td>
        <td id="login_panel_right"></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>
