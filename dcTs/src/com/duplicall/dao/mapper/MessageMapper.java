package com.duplicall.dao.mapper;

import java.sql.ResultSet;

import com.duplicall.dao.common.IRowMapper;
import com.duplicall.entities.CallMessage;

public class MessageMapper implements IRowMapper<CallMessage> {

	@Override
	public CallMessage getResults(ResultSet rs) throws Exception {
		CallMessage message = new CallMessage();
		message.setId(rs.getLong("id"));
		message.setCallingPartyId(rs.getLong("calling_network_party_id"));
		message.setCalledPartyId(rs.getLong("called_network_party_id"));
		return message;
	}
}
