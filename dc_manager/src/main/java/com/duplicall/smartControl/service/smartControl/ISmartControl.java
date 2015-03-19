package com.duplicall.smartControl.service.smartControl;

import java.rmi.server.ServerCloneException;
import java.util.List;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.IP;
import com.duplicall.smartControl.pojo.Ngx;
import com.duplicall.smartControl.pojo.NgxSmartControl;
import com.duplicall.smartControl.pojo.PBXSmartControl;
import com.duplicall.smartControl.pojo.SmartBoard;
import com.duplicall.smartControl.pojo.SmartControlSystem;
import com.duplicall.smartControl.pojo.User;
import com.duplicall.smartControl.pojo.VoIPSmartControl;

/**
 * 
 * <一句话功能简述>
 * 
 * @author mli
 * @version [V1.00, 2014年7月11日]
 * @see [reference class/method]
 * @since V1.00
 */
public interface ISmartControl {
	/**
	 * 查询smartControl 系统模块的信息 <function> <description>
	 * 
	 * @return
	 * @throws ServerCloneException
	 * @see [类、类#方法、类#成员]
	 */
	public SmartControlSystem getSmartControlSystem() throws ServiceException;

	/**
	 * 获取board 信息
	 * 
	 * @Description
	 * @author mli
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public Object getBoard(String type) throws ServiceException;

	/**
	 * update smartControl
	 * 
	 * @param swxUser
	 * @param voIpSmartControl
	 * @throws ServiceException
	 */
	public void updateSmartControlSystem(User swxUser,
			SmartControlSystem smartControlSystem,
			PBXSmartControl pbxSmartControl, VoIPSmartControl voIpSmartControl,
			Object object) throws ServiceException;

	/**
	 * 查询网卡信息
	 * 
	 * @Description
	 * @author mli
	 * @return
	 * @throws ServiceException
	 */
	public List<String> getNICList() throws ServiceException;

	/**
	 * 抓取ip信息
	 * 
	 * @Description
	 * @author mli
	 * @param nicName
	 * @return
	 * @throws ServiceException
	 */
	public IP getIpInformation(String nicName) throws ServiceException;

	/**
	 * 重新启动机器
	 * 
	 * @Description
	 * @author mli
	 * @throws ServiceException
	 */
	public void restartOs() throws ServiceException;

	/**
	 * 设定IP信息
	 * 
	 * @Description
	 * @author mli
	 * @param ip
	 *            对象
	 * @param nicName
	 *            网卡名
	 * @return true 是修改成功，false 是修改失敗
	 * @throws ServiceException
	 */
	public Boolean updateIp(IP ip) throws ServiceException;

	/**
	 * 关机
	 * 
	 * @Description
	 * @author mli
	 * @throws ServerCloneException
	 */
	public void shutdownOs() throws ServiceException;

	/**
	 * 更新pbx，主要是tdm-encoding,gciIndex
	 * 
	 * @param user
	 * @param tdm
	 * @param gciIndex
	 * @throws ServerCloneException
	 */
	public void updatePbx(User user, String tdm, int gciIndex,int configurationId)
			throws ServiceException;

	/**
	 * 更新voip
	 * 
	 * @param user
	 * @param voIPSmartControl
	 * @throws ServiceException
	 */
	public void updateVoIp(User user, VoIPSmartControl voIPSmartControl)
			throws ServiceException;

	/**
	 * 获得ngx的信息
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public NgxSmartControl getNgx(Ngx ngx) throws ServiceException;

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Long getEncoding(int configurationId) throws ServiceException;

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String getStartingIndex() throws ServiceException;

	/**
	 * 更新ngx
	 * 
	 * @param boardBase
	 * @param boardDc1
	 * @param boardDc2
	 * @throws ServiceException
	 */
	public void updateNgx(User user, SmartBoard boardBase, SmartBoard boardDc1,
			SmartBoard boardDc2, int startingIndex,int configurationId) throws ServiceException;
	
}
