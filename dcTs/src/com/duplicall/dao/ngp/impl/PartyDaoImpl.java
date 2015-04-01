package com.duplicall.dao.ngp.impl;

import org.junit.Test;

import com.duplicall.dao.ngp.IPartyDao;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.CallDetail;
import com.duplicall.pojo.Party;

public class PartyDaoImpl implements IPartyDao {
	private DBUtil<CallDetail> dbUtil = new DBUtil<CallDetail>("ngp");

	@Override
	public void updateAnsweringParty(long callId, Party party) throws Exception {
		String sql = "UPDATE party_identity d SET d.generic_digits = '"
				+ party.getGenericDigits()
				+ "' WHERE d.id IN ( SELECT e.id FROM ( SELECT c.id FROM laes_messages a, answer_messages b, party_identity c WHERE a.laes_call_id = "
				+ callId
				+ " AND a.message_type = 'ANSWER' AND b.id = a.id AND b.answering_network_party_id = c.id ) e )";
		dbUtil.update(sql);
	}

	@Override
	public void updateCallingParty(long callId, Party party) throws Exception {
		String sql = "update party_identity d set d.generic_digits='"
				+ party.getGenericDigits()
				+ "' where d.id in (select e.id from ( SELECT c.id FROM laes_messages a, termination_attempt_messages b, party_identity c WHERE a.laes_call_id = "
				+ callId
				+ " AND a.message_type = 'TERMINATION_ATTEMPT' AND b.id = a.id AND b.calling_network_party_id = c.id) e)";
		dbUtil.update(sql);
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCalledParty(long callId, Party party) throws Exception {
		String sql = "update party_identity d set d.generic_digits='"
				+ party.getGenericDigits()
				+ "' where d.id in (select e.id from ( SELECT c.id FROM laes_messages a, termination_attempt_messages b, party_identity c WHERE a.laes_call_id = "
				+ callId
				+ " AND a.message_type = 'TERMINATION_ATTEMPT' AND b.id = a.id AND b.called_network_party_id = c.id) e)";
		dbUtil.update(sql);

	}

	@Test
	public void testUpateCallingParty() {
		Party party = new Party();
		party.setGenericDigits("11");
		party.setIpAddress("192.159.2.222");
		try {
			this.updateAnsweringParty(103, party);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
