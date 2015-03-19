//全局变量
var bodyMain, homeMenu, callMenu, systemMenu, reportMenu, userMenu, vIfr;
// DC-Main.html初始化加载
function init_DC_Main() {
	// 显示时间
	showtime();
	// 全局变量初始化
	bodyMain = document.getElementById("change");
	homeMenu = document.getElementById("Contact_Tab");
	callMenu = document.getElementById("Account_Tab");
	systemMenu = document.getElementById("Opportunity_Tab");
	reportMenu = document.getElementById("report_Tab");
	userMenu = document.getElementById("Lead_Tab");

	vIfr = document.getElementById("ifrObj"); // 根据id找到Home页面
	vIfr.src = "ipInformation.do";
}

function toWindows() {
	// bodyMain根据不同Tab切换不同的border-bottom颜色
//	bodyMain.className = "hasMotif accountTab  overviewPage  ext-gecko ext-gecko3 sfdcBody brandQuaternaryBgr";
//	homeMenu.className = "zen-active";
//	reportMenu.className = null;
//	callMenu.className = null;
//	systemMenu.className = null;
//	userMenu.className = null;
	var windowArrow = $("#windowArrow");
	var pbxArrow = $("#pbxArrow");
	var ngxArrow = $("#ngxArrow");
	var voipArrow = $("#voipArrow");
	var basicArrow = $("#basicArrow");
	windowArrow.show();
	pbxArrow.hide();
	ngxArrow.hide(); 
	voipArrow.hide();
	basicArrow.hide();

//	homeMenu.style.background = "rgb(35,111,189)";
//	callMenu.style.background = "rgb(68,73,83)";
//	systemMenu.style.background = "rgb(68,73,83)";
//	reportMenu.style.background = "rgb(68,73,83)";
//	userMenu.style.background = "rgb(68,73,83)";
	vIfr.src = "ipInformation.do";
}
function toPbx() {
//	bodyMain.className = "hasMotif contactTab  overviewPage  ext-webkit ext-chrome sfdcBody brandQuaternaryBgr";
//	callMenu.className = "zen-active";
//	reportMenu.className = null;
//	homeMenu.className = null;
//	systemMenu.className = null;
//	userMenu.className = null;
	
	var windowArrow = $("#windowArrow");
	var pbxArrow = $("#pbxArrow");
	var ngxArrow = $("#ngxArrow");
	var voipArrow = $("#voipArrow");
	var basicArrow = $("#basicArrow");
	windowArrow.hide();
	pbxArrow.show();
	ngxArrow.hide(); 
	voipArrow.hide();
	basicArrow.hide();
	
//	callMenu.style.background = "#653584";
//	homeMenu.style.background = "rgb(68,73,83)";
//	systemMenu.style.background = "rgb(68,73,83)";
//	reportMenu.style.background = "rgb(68,73,83)";
//	userMenu.style.background = "rgb(68,73,83)";
	vIfr.src = "system/viewPbx.do";

}
function toNgx() {
//	bodyMain.className = "hasMotif opportunityTab  overviewPage  ext-gecko ext-gecko3 sfdcBody brandQuaternaryBgr";
//	systemMenu.className = "zen-active";
//	reportMenu.className = null;
//	homeMenu.className = null;
//	callMenu.className = null;
//	userMenu.className = null;
	
	var windowArrow = $("#windowArrow");
	var pbxArrow = $("#pbxArrow");
	var ngxArrow = $("#ngxArrow");
	var voipArrow = $("#voipArrow");
	var basicArrow = $("#basicArrow");
	windowArrow.hide();
	pbxArrow.hide();
	ngxArrow.show(); 
	voipArrow.hide();
	basicArrow.hide();
	
//	systemMenu.style.background = "rgb(238, 78, 16)";
//	callMenu.style.background = "rgb(68,73,83)";
//	homeMenu.style.background = "rgb(68,73,83)";
//	reportMenu.style.background = "rgb(68,73,83)";
//	userMenu.style.background = "rgb(68,73,83)";
	vIfr.src = "system/viewNgx.do";
}
function toVoIp() {
//	bodyMain.className = "hasMotif reportTab sfdcBody brandQuaternaryBgr  ext-webkit ext-chrome x-theme-aloha-esque";
//	reportMenu.className = "zen-active";
	callMenu.className = null;
	homeMenu.className = null;
	systemMenu.className = null;
	userMenu.className = null;

	var windowArrow = $("#windowArrow");
	var pbxArrow = $("#pbxArrow");
	var ngxArrow = $("#ngxArrow");
	var voipArrow = $("#voipArrow");
	var basicArrow = $("#basicArrow");
	windowArrow.hide();
	pbxArrow.hide();
	ngxArrow.hide(); 
	voipArrow.show();
	basicArrow.hide();
	
//	reportMenu.style.background = "rgb(240,176,23)";
//	callMenu.style.background = "rgb(68,73,83)";
//	homeMenu.style.background = "rgb(68,73,83)";
//	systemMenu.style.background ="rgb(68,73,83)";
//	userMenu.style.background = "rgb(68,73,83)";
	// 跳转report之间先进行查询所有Targets
	vIfr.src = "system/viewIp.do";

}

function toBasic() {
//	bodyMain.className = "hasMotif my_user_Tab sfdcBody brandQuaternaryBgr  ext-webkit ext-chrome x-theme-aloha-esque";
//	userMenu.className = "zen-active";
	callMenu.className = null;
	homeMenu.className = null;
	systemMenu.className = null;
	reportMenu.className = null;

	var windowArrow = $("#windowArrow");
	var pbxArrow = $("#pbxArrow");
	var ngxArrow = $("#ngxArrow");
	var voipArrow = $("#voipArrow");
	var basicArrow = $("#basicArrow");
	windowArrow.hide();
	pbxArrow.hide();
	ngxArrow.hide(); 
	voipArrow.hide();
	basicArrow.show();
	
//	userMenu.style.background = "rgb(138,183,27)";
//	callMenu.style.background = "rgb(68,73,83)";
//	homeMenu.style.background = "rgb(68,73,83)";
//	systemMenu.style.background ="rgb(68,73,83)";
//	reportMenu.style.background = "rgb(68,73,83)";
	vIfr.src = "system/viewBasic.do";

}

// 获得当前时间,刻度为一千分一秒
//function showtime() {
//	var date = new Date();
//	this.year = date.getFullYear();
//	this.month = date.getMonth() + 1;
//	this.date = date.getDate();
//	this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
//	"星期六")[date.getDay()];
//	/*this.day = new Array("Sun.", "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.")[date
//			.getDay()];*/
//	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
//	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date
//			.getMinutes();
//	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date
//			.getSeconds();
//	var E_month = "";
//	if (month == 1) {
//		E_month = "01";
//		//E_month = "January";
//	}
//	if (month == 2) {
//		E_month = "02";
//		//E_month = "February";
//	}
//	if (month == 3) {
//		E_month = "03";
//		//E_month = "March";
//	}
//	if (month == 4) {
//		E_month = "04";
//		//E_month = "April";
//	}
//	if (month == 5) {
//		E_month = "05";
//		//E_month = "May";
//	}
//	if (month == 6) {
//		E_month = "06";
//		//E_month = "June";
//	}
//	if (month == 7) {
//		E_month = "07";
//		//E_month = "July";
//	}
//	if (month == 8) {
//		E_month = "08";
//		//E_month = "August";
//	}
//	if (month == 9) {
//		E_month = "09";
//		//E_month = "September";
//	}
//	if (month == 10) {
//		E_month = "10";
//		//E_month = "October";
//	}
//	if (month == 11) {
//		E_month = "11";
//		//E_month = "November";
//	}
//	if (month == 12) {
//		E_month = "12";
//		//E_month = "December";
//	}
//	var currentTime =this.year+"-"+ E_month +"-"+ this.date +" "+this.hour + ":" + this.minute + ":" + this.second + " "
//			+ " "+ "(" + this.day
//			+ ")";
//	document.all.show.innerHTML = currentTime;
//	var timei = setTimeout(showtime, 1000);
//}
function showtime() {
	var date = new Date();
	this.year = date.getFullYear();
	this.month = date.getMonth() + 1;
	this.date = date.getDate();
	// this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
	// "星期六")[date.getDay()];
	this.day = new Array("Sun.", "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.")[date
			.getDay()];
	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date
			.getMinutes();
	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date
			.getSeconds();
	var E_month = "";
	if (month == 1) {
		E_month = "January";
	}
	if (month == 2) {
		E_month = "February";
	}
	if (month == 3) {
		E_month = "March";
	}
	if (month == 4) {
		E_month = "April";
	}
	if (month == 5) {
		E_month = "May";
	}
	if (month == 6) {
		E_month = "June";
	}
	if (month == 7) {
		E_month = "July";
	}
	if (month == 8) {
		E_month = "August";
	}
	if (month == 9) {
		E_month = "September";
	}
	if (month == 10) {
		E_month = "October";
	}
	if (month == 11) {
		E_month = "November";
	}
	if (month == 12) {
		E_month = "December";
	}
	var currentTime = this.hour + ":" + this.minute + ":" + this.second +"  "
			+" "+ E_month +" "+ this.date + ", " +" "+ this.year +" "+ "(" + this.day
			+ ")";
	document.all.show.innerHTML = currentTime;
	var timei = setTimeout(showtime, 1000);
}

