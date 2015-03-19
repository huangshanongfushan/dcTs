<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="rootPath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<!-- <link href="css/lrtk.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="css/button.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="css/sys_param.css" rel="stylesheet" type="text/css"> -->

<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	function updateNgx() {
		var url = "system/updateNgx.do";
		var tdmEncoding = $("input[name='tdmEncoding']:checked").val();
		var startIndex = $("input[name='startingIdex']:checked").val();
		var basePbxType = $("#basePbxType").val().trim();
		var baseTermination = $("input[name='basetermination']:checked").val();
		var configurationId = $("#configurationId").val();
		var basedcchanel;
		var chk_value = [];
		$('input[name="basedchanel"]:checked').each(function() {
			chk_value.push($(this).val());
		});
		if (chk_value.length == 2) {
			basedcchanel = 3;
		} else if (chk_value[0] == 0) {
			basedcchanel = 1;
		} else {
			basedcchanel = 2;
		}

		url = url + "?tdmEncoding=" + tdmEncoding + "&startingIndex="
				+ startIndex + "&basePbxType=" + basePbxType
				+ "&baseTermination=" + baseTermination + "&basedcchanel="
				+ basedcchanel+"&configurationId="+configurationId;
		//dc1
		if ($("#dc1").is(":visible")) {
			var dc1PbxType = $("#dc1PbxType").val().trim();
			var dc1Termination = $("input[name='dc1termination']:checked")
					.val();
			var dc1dcchanel;
			var chk_value1 = [];
			$('input[name="dc1dchanel"]:checked').each(function() {
				chk_value1.push($(this).val());
			});
			if (chk_value1.length == 2) {
				dc1dcchanel = 3;
			} else if (chk_value1[0] == 0) {
				dc1dcchanel = 1;
			} else {
				dc1dcchanel = 2;
			}
			url = url + "&dc1PbxType=" + dc1PbxType + "&dc1Termination="
					+ dc1Termination + "&dc1dcchanel=" + dc1dcchanel;
		}

		if ($("#dc2").is(":visible")) {
			var dc2PbxType = $("#dc2PbxType").val().trim();
			var dc2Termination = $("input[name='dc2termination']:checked")
					.val();
			var dc2dcchanel;
			var chk_value2 = [];
			$('input[name="dc2dcchanel"]:checked').each(function() {
				chk_value2.push($(this).val());
			});
			if (chk_value2.length == 2) {
				dc2dcchanel = 3;
			} else if (chk_value2[0] == 0) {
				dc2dcchanel = 1;
			} else {
				dc2dcchanel = 2;
			}
			url = url + "&dc2PbxType=" + dc2PbxType + "&dc2Termination="
					+ dc2Termination + "&dc2dcchanel=" + dc2dcchanel;
		}
		$.get(url, function(data) {
			alert(data);
		});
		// 		alert(tdmEncoding);		
	}
</script>
</head>
<body>
	<div id="container" style="font-family: Arial;">
		<div id="content">
		<c:forEach items="${ngxSmartControlList}" var="ngxSmartControl" end="0">
		<input id="configurationId" value="${ngxSmartControl.configurationId}" style="display: none"/>
			<table align="center">
				<tr>
					<td>
						<fieldset style="width: 900px;border-color: blue;">
							<legend>Information</legend>
							<table width="900px" align="center">
								<tr>
									<td>Board Number:</td>
									<td></td>
									<td>PCI Bus No:${ngxSmartControl.busNo}</td>
									<td></td>
									<td>PCI Slot No:${ngxSmartControl.slotNo}</td>
									<td></td>
								</tr>
							</table>
							<fieldset style="border: 1px solid; width: 600px;border-color: blue;">
								<legend style="margin-left: 15px;">Base</legend>
								<table width="870px" align="center" id="base">
									<tr>
										<td>PBX Type</td>
										<td><select id="basePbxType">
												<c:forEach var="item" items="${boardTypeMap}">
													<c:choose>
														<c:when
															test="${item.key==ngxSmartControl.boardBase.pbxType}">
															<option value="${item.key} 　" selected="selected">${item.value}
															</option>
														</c:when>
														<c:otherwise>
															<option value="${item.key} 　">${item.value}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<td>PBX Version</td>
										<td>${ngxSmartControl.boardBase.firmwareVersion }</td>
									</tr>
									<tr>
										<td>Board Type</td>
										<td>${ngxSmartControl.boardBase.boardType }</td>
									</tr>
									<tr>
										<td>Chanles</td>
										<td>${ngxSmartControl.boardBase.channels }</td>
									</tr>
									<tr>
										<td>Serial Number</td>
										<td>${ngxSmartControl.boardBase.servialNumber }</td>
									</tr>
									<tr>
										<td>DateCode</td>
										<td>${ngxSmartControl.boardBase.dateCode }</td>
									</tr>
									<tr>
										<td>FirmWare Version</td>
										<td>${ngxSmartControl.boardBase.firmwareVersion }</td>
									</tr>
									<tr>
										<td>D-Chanel Options</td>
										<td><c:choose>
												<c:when test="${ngxSmartControl.boardBase.dChannel==0 }">
													<input type="checkbox" name="basedchanel" value="0"> D-Chanel &nbsp;
								<input type="checkbox" name="basedchanel" value="1">Event Updates &nbsp;
								<input type="checkbox" name="basedchanel" disabled="disabled"
														value="2">Call Control &nbsp;
								</c:when>
												<c:when test="${ngxSmartControl.boardBase.dChannel==1 }">
													<input type="checkbox" name="basedchanel" checked="checked"
														value="0"> D-Chanel &nbsp;
								<input type="checkbox" name="basedchanel" value="1">Event Updates &nbsp;
								<input type="checkbox" name="basedchanel" disabled="disabled"
														value="2">Call Control &nbsp;
								</c:when>
												<c:otherwise>
													<input type="checkbox" name="basedchanel" checked="checked"
														value="0"> D-Chanel &nbsp;
								<input type="checkbox" name="basedchanel" checked="checked"
														value="1">Event Updates &nbsp;
								<input type="checkbox" name="basedchanel" disabled="disabled"
														value="2">Call Control &nbsp;
								</c:otherwise>

											</c:choose></td>

									</tr>
									<tr>
										<td>Termination</td>
										<td><c:choose>
												<c:when test="${ngxSmartControl.boardBase.termination=='0'}">
													<input type="radio" value="1" name="basetermination"> 120 Ohm &nbsp;
								<input type="radio" value="0" name="basetermination"
														checked="checked"> HI-Z &nbsp;
								</c:when>
												<c:otherwise>
													<input type="radio" value="1" name="basetermination"
														checked="checked"> 120 Ohm&nbsp;
								<input type="radio" value="0" name="basetermination"> HI-Z &nbsp;
								</c:otherwise>
											</c:choose></td>
									</tr>
								</table>
							</fieldset>
							<p />
							<c:if test="${ngxSmartControl.boardDC1!=null }">
								<fieldset style="border: 1px solid; width: 600px;border-color: blue;">
									<legend style="margin-left: 15px;">DC1</legend>
									<table width="870px" align="center" id="dc1">
										<tr>
											<td>PBX Type</td>
											<td><select id="dc1PbxType">
													<c:forEach var="item" items="${boardTypeMap}">
														<c:choose>
															<c:when
																test="${item.key==ngxSmartControl.boardDC1.pbxType}">
																<option value="${item.key} 　" selected="selected">${item.value}
																</option>
															</c:when>
															<c:otherwise>
																<option value="${item.key} 　">${item.value}</option>
															</c:otherwise>
														</c:choose>

													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td>PBX Version</td>
											<td>${ngxSmartControl.boardDC1.firmwareVersion }</td>
										</tr>
										<tr>
											<td>Board Type</td>
											<td>${ngxSmartControl.boardDC1.boardType }</td>
										</tr>
										<tr>
											<td>Chanles</td>
											<td>${ngxSmartControl.boardDC1.channels }</td>
										</tr>
										<tr>
											<td>Serial Number</td>
											<td>${ngxSmartControl.boardDC1.servialNumber }</td>
										</tr>
										<tr>
											<td>DateCode</td>
											<td>${ngxSmartControl.boardDC1.dateCode }</td>
										</tr>
										<tr>
											<td>FirmWare Version</td>
											<td>${ngxSmartControl.boardDC1.firmwareVersion }</td>
										</tr>
										<tr>
											<td>D-Chanel Options</td>
											<td><c:choose>
													<c:when test="${ngxSmartControl.boardDC1.dChannel==0 }">
														<input type="checkbox" value="0" name="dchanel"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dchanel">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dchanel"
															disabled="disabled">Call Control &nbsp;
								</c:when>
													<c:when test="${ngxSmartControl.boardDC1.dChannel==1 }">
														<input type="checkbox" value="0" name="dc1dchanel"
															checked="checked"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dc1dchanel">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dc1dchanel"
															disabled="disabled">Call Control &nbsp;
								</c:when>
													<c:otherwise>
														<input type="checkbox" value="0" name="dc1dchanel"
															checked="checked"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dc1dchanel"
															checked="checked">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dc1dchanel"
															disabled="disabled">Call Control &nbsp;
								</c:otherwise>

												</c:choose></td>

										</tr>
										<tr>
											<td>Termination</td>
											<td><c:choose>
													<c:when test="${ngxSmartControl.boardDC1.termination=='0'}">
														<input type="radio" value="1" name="dc1termination"> 120 Ohm &nbsp;
								<input type="radio" value="0" name="dc1termination"
															checked="checked"> HI-Z &nbsp;
								</c:when>
													<c:otherwise>
														<input type="radio" value="1" name="dc1termination"
															checked="checked"> 120 Ohm&nbsp;
								<input type="radio" value="0" name="dc1termination"> HI-Z &nbsp;
								</c:otherwise>
												</c:choose></td>
										</tr>
									</table>
								</fieldset>
								<p />
							</c:if>
							<c:if test="${ngxSmartControl.boardDC2!=null }">
								<fieldset style="border: 1px solid; width: 600px;border-color: blue;">
									<legend style="margin-left: 15px;">DC2</legend>
									<table width="870px" align="center" id="dc2">
										<tr>
											<td>PBX Type</td>
											<td><select id="dc2PbxType">
													<c:forEach var="item" items="${boardTypeMap}">
														<c:choose>
															<c:when
																test="${item.key==ngxSmartControl.boardDC2.pbxType}">
																<option value="${item.key} 　" selected="selected">${item.value}
																</option>
															</c:when>
															<c:otherwise>
																<option value="${item.key} 　">${item.value}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td>PBX Version</td>
											<td>${ngxSmartControl.boardDC2.firmwareVersion }</td>
										</tr>
										<tr>
											<td>Board Type</td>
											<td>${ngxSmartControl.boardDC2.boardType }</td>
										</tr>
										<tr>
											<td>Chanles</td>
											<td>${ngxSmartControl.boardDC2.channels }</td>
										</tr>
										<tr>
											<td>Serial Number</td>
											<td>${ngxSmartControl.boardDC2.servialNumber }</td>
										</tr>
										<tr>
											<td>DateCode</td>
											<td>${ngxSmartControl.boardDC2.dateCode }</td>
										</tr>
										<tr>
											<td>FirmWare Version</td>
											<td>${ngxSmartControl.boardDC2.firmwareVersion }</td>
										</tr>
										<tr>
											<td>D-Chanel Options</td>
											<td><c:choose>
													<c:when test="${ngxSmartControl.boardDC2.dChannel==0 }">
														<input type="checkbox" value="0" name="dc2dcchanel"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dc2dcchanel">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dc2dcchanel"
															disabled="disabled">Call Control &nbsp;
								</c:when>
													<c:when test="${ngxSmartControl.boardDC2.dChannel==1 }">
														<input type="checkbox" value="0" name="dc2dcchanel"
															checked="checked"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dc2dcchanel">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dc2dcchanel"
															disabled="disabled">Call Control &nbsp;
								</c:when>
													<c:otherwise>
														<input type="checkbox" value="0" name="dc2dcchanel"
															checked="checked"> D-Chanel &nbsp;
								<input type="checkbox" value="1" name="dc2dcchanel"
															checked="checked">Event Updates &nbsp;
								<input type="checkbox" value="2" name="dc2dcchanel"
															disabled="disabled">Call Control &nbsp;
								</c:otherwise>

												</c:choose></td>

										</tr>
										<tr>
											<td>Termination</td>
											<td><c:choose>
													<c:when test="${ngxSmartControl.boardDC2.termination=='0'}">
														<input type="radio" value="1" name="dc2termination"> 120 Ohm &nbsp;
								<input type="radio" value="0" name="dc2termination"
															checked="checked"> HI-Z &nbsp;
								</c:when>
													<c:otherwise>
														<input type="radio" value="0" name="dc2termination"
															checked="checked"> 120 Ohm&nbsp;
								<input type="radio" value="0" name="dc2termination"> HI-Z &nbsp;
								</c:otherwise>
												</c:choose></td>
										</tr>
									</table>
								</fieldset>
							</c:if>
							<p />
							<fieldset style="border: 1px solid; width: 600px;border-color: blue;">
								<legend style="margin-left: 15px;">Common</legend>
								<table width="870px" align="center">
									<tr>
										<td align="center" valign="middle">TDM Encoding :<c:choose>
												<c:when test="${ngxSmartControl.boardBase.tdmEncoding==0}">
													<input type="radio" name="tdmEncoding" checked="checked"
														value="0" id="tdmEncoding">u-law 
														<input type="radio" name="tdmEncoding" value="FFFFFFFF">a-law<p />
												</c:when>
												<c:otherwise>
													<input type="radio" name="tdmEncoding" value="0"
														id="tdmEncoding">u-law 
														<input type="radio" name="tdmEncoding" checked="checked"
														value="FFFFFFFF">a-law<p />
												</c:otherwise>
											</c:choose>

										</td>
										<td align="center" valign="middle">GCI Starting Index :<c:choose>
												<c:when test="${startingIndex==0 }">
													<input type="radio" name="startingIdex" checked="checked"
														value="0">0 
														<input type="radio" name="startingIdex" value="1">1<p />
												</c:when>
												<c:otherwise>
													<input type="radio" name="startingIdex" value="0">0
														<input type="radio" name="startingIdex" checked="checked"
														value="1">1<p />
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</table>
							</fieldset>
						</fieldset>
						<table align="center">
							<tr align="center">
								<td><input type="button" value="Apply"
									onclick="updateNgx()" style="width: 60px; height: 25px;"></input>
									<input type="button" value="Cancel"
									style="width: 60px; height: 25px;"></td>
							</tr>
							<tr>
								<td><p />Setting will take effect after reboot</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</c:forEach>
		</div>
	</div>
</body>
</html>