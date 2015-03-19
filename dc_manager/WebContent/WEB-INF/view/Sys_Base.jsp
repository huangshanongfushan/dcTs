<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table>
	<tr>
		<td>Board Type</td>
		<td>HPX</td>
		<td>Service Name</td>
		<td>SmrtWrksSrvc</td>
	</tr>
	<tr>
		<td>Board Version</td>
		<td>05.10.01</td>
		<td>Service Version</td>
		<td>05.10.01</td>
	</tr>
	<tr>
		<td>Board Build</td>
		<td>4320</td>
		<td>Service Build</td>
		<td>4320</td>
	</tr>
	<tr>
		<td rowspan="4">Copynight(c)2008-2014 AudioCodes Inc All right
			reserved.</td>
	</tr>
</table>
<fieldset style="border: 1px solid;border-color: blue;">
	<legend style="margin-left: 15px;">
		<input id="adv" type="button" value="Monitoring Port0" />
	</legend>
	<div id="advances">
		<input type="radio" name="able" />Disable <input type="radio"
			name="able" />Enable Adapter:<select>
			<option>Realtek PCIe GBE Family Controller</option>
			<option>111</option>
		</select>
	</div>
</fieldset>
<fieldset style="border: 1px solid;border-color: blue;">
	<legend style="margin-left: 15px;">
		<input id="adv" type="button" value="Monitoring Port1" />
	</legend>
	<div id="advances">
		<input type="radio" name="able" />Disable <input type="radio"
			name="able" />Enable Adapter:<select>
			<option>Realtek PCIe GBE Family Controller</option>
			<option>111</option>
		</select>
	</div>
</fieldset>

<fieldset style="border: 1px solid;border-color: blue;">
	<legend style="margin-left: 15px;">
		<input id="adv" type="button" value="Passive Network Settings" />
	</legend>
	<div id="advances">
		<table>
			<tr>
				<td>Passive VLAN</td>
				<td><input type="radio" name="able2" />Disable<input
					type="radio" name="able2" />Enable</td>
				<td>ID:</td>
				<td><input type="text" value="      0      " /></td>
			</tr>
			<tr>
				<td>RTP Timeout</td>
				<td><input type="radio" name="able2" />Disable<input
					type="radio" name="able2" />Enable</td>
				<td>Time:</td>
				<td><input type="text" value="      600      " /></td>
			</tr>
			<tr>
				<td>RTCP Qos</td>
				<td><input type="radio" name="able2" />Disable<input
					type="radio" name="able2" />Enable</td>
			</tr>
			<tr>
				<td>NAT Topology</td>
				<td><input type="radio" name="able2" />Disable<input
					type="radio" name="able2" />Enable</td>
			</tr>
		</table>
	</div>
</fieldset>

<fieldset style="border: 1px solid;border-color: blue;">
	<legend style="margin-left: 15px;">
		<input id="adv" type="button" value="Deadlock Detection" />
	</legend>
	<div id="advances">
		<table>
			<tr>
				<td>Deadlock Detection Enable</td>
				<td><input type="checkbox" /></td>
			</tr>
			<tr>
				<td>Shut Down on Deadlock</td>
				<td><input type="checkbox" /></td>
			</tr>
		</table>
	</div>
</fieldset>
