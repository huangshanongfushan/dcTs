package com.duplicall.dao.device.impl;

import org.junit.Test;

import com.duplicall.dao.device.IDeviceDao;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.CallDetail;

public class DeviceDaoImpl implements IDeviceDao {
	private DBUtil<CallDetail> dbUtil = new DBUtil<CallDetail>("ngp");

	@Override
	public Long getDeviceId(String deviceName) throws Exception {
		String sql = "select a.id from devices a,recordable_entities b where a.name='" + deviceName +"' AND a.id=b.id AND b.active=1";
		Long deviceId = (Long) dbUtil.queryForObject(sql, Long.class);
		return deviceId;
	}

	@Test
	public void testGetDevice() {
		try {
			System.out.println(getDeviceId("8001"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
