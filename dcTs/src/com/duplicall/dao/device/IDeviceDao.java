package com.duplicall.dao.device;

public interface IDeviceDao {
	/**
	 * 
	 * @param deviceName
	 * @return
	 * @throws Exception
	 */
	public Long getDeviceId(String deviceName) throws Exception;

}
