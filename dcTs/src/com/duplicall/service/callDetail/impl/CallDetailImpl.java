package com.duplicall.service.callDetail.impl;

import java.util.List;

import org.junit.Test;

import com.duplicall.dao.callDetail.ICallDetailDao;
import com.duplicall.dao.callDetail.impl.CallDetailDaoImpl;
import com.duplicall.entities.CallDetail;
import com.duplicall.exception.ServiceException;
import com.duplicall.service.callDetail.ICallDetail;

public class CallDetailImpl implements ICallDetail {
	private ICallDetailDao callDetailDaoImpl = new CallDetailDaoImpl();

	@Override
	public List<CallDetail> getCallDetail(String startTime, String endTime)
			throws ServiceException {
		List<CallDetail> detailList = null;
		try {
			// 查询出所有需要处理的通话
			detailList = callDetailDaoImpl.getCallDetail(startTime, endTime);
		} catch (Exception e) {
			throw new ServiceException();
		}
		return detailList;
	}

	@Test
	public void testCallDetail() {
		String starttime = "2015-03-16 12:47:23";
		String endtime = "2015-03-16 13:47:23";
		try {
			this.getCallDetail(starttime, endtime);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
