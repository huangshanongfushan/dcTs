package com.duplicall.dao.message.impl;

import org.junit.Test;

import com.duplicall.dao.mapper.MessageMapper;
import com.duplicall.dao.message.IMessageDao;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.CallMessage;

public class MessageDaoImpl implements IMessageDao {
	private DBUtil<CallMessage> dbUtil = new DBUtil<CallMessage>("ngp");
	@Override
	public long getMessageId(long callId) throws Exception {
		String sql = "select id from laes_messages where laes_call_id ="
				+ callId + " and message_type='TERMINATION_ATTEMPT' ";
		Long messageId = (Long) dbUtil.queryForObject(sql, Long.class);
		return messageId;
	}

	@Override
	public CallMessage getOrginationMessage(long messageId) throws Exception {
		String sql = "select * from termination_attempt_messages where id = "
				+ messageId;
		CallMessage message = dbUtil.queryForObject(sql,new MessageMapper());
		return message;
	}
	
	

	@Override
	public void insertOriginationMessage(CallMessage callMessage)
			throws Exception {
		String sql = "insert into origination_messages (id,calling_network_party_id,called_network_party_id)"
				+ " values("+callMessage.getId()+","+callMessage.getCallingPartyId()+","+callMessage.getCalledPartyId()+")";
		dbUtil.update(sql);
	}
	@Test
	public void testGetAttem()
	{
		try {
			CallMessage message = new CallMessage();
			message.setCalledPartyId(1889);
			message.setCallingPartyId(1890);
			message.setId(2846);
			this.insertOriginationMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTeminalMessage(long temialMessageId) throws Exception {
		String sql ="delete from termination_attempt_messages where id = "+temialMessageId;
		dbUtil.update(sql);
	}
}
