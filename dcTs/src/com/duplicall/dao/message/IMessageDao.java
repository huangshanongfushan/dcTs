package com.duplicall.dao.message;

import com.duplicall.entities.CallMessage;

public interface IMessageDao {
	/**
	 * 
	 * @param callId
	 * @return
	 * @throws Exception
	 */
	public long getMessageId(long callId) throws Exception ;
	/**
	 * 取主叫信息，TS情况下存在于Terminal_attemp 表中
	 * @param messageId
	 * @return
	 * @throws Exception
	 */
	public CallMessage getOrginationMessage(long messageId) throws Exception ;
	/**
	 * 从teminal_attempt_message 表中复制信息到Origination_message中
	 * @param callMessage
	 * @throws Exception
	 */
	public void insertOriginationMessage(CallMessage callMessage)
		throws Exception;
	/**
	 * 从teminal表中删除指定数据
	 * @param temialMessageId
	 * @throws Exception
	 */
	public void deleteTeminalMessage(long temialMessageId)
		throws Exception;
}
