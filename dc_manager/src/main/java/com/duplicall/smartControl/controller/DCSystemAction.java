package com.duplicall.smartControl.controller;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.ManagerCardInfor;
import com.duplicall.smartControl.pojo.NetInterCard;
import com.duplicall.smartControl.pojo.Ngx;
import com.duplicall.smartControl.pojo.NgxSmartControl;
import com.duplicall.smartControl.pojo.PBXSmartControl;
import com.duplicall.smartControl.pojo.Pbx;
import com.duplicall.smartControl.pojo.SmartBoard;
import com.duplicall.smartControl.pojo.SmartControlSystem;
import com.duplicall.smartControl.pojo.User;
import com.duplicall.smartControl.pojo.VoIPSmartControl;
import com.duplicall.smartControl.service.card.ISmartCard;
import com.duplicall.smartControl.service.common.BoardType;
import com.duplicall.smartControl.service.smartControl.impl.SmartControlImpl;

@Controller
@RequestMapping("system")
public class DCSystemAction implements Serializable {

	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = -3530340415803551754L;

	@Resource
	private SmartControlImpl smartControlImpl;
	@Resource
	private ISmartCard smartCardImpl;
	/**
	 * 
	 * @Description
	 * @author mli
	 * @return
	 */
	@RequestMapping("viewBasic.do")
	public String viewSystem(Model model) {
		SmartControlSystem smartSystem = null;
		PBXSmartControl pbxsmart = null;
		try {
			smartSystem = smartControlImpl.getSmartControlSystem();
//			pbxsmart = smartControlImpl.getPbxSmartControl();
			model.addAttribute("smartSystem", smartSystem);
			model.addAttribute("pbxsmart", pbxsmart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "basicSetting";
	}

	@RequestMapping("viewPbx.do")
	public String viewPbx(Model model) {
		List<PBXSmartControl> pbxSmartControlList = new ArrayList<PBXSmartControl>();
		try {
		    ManagerCardInfor managerCardInfo = smartCardImpl.initManagerCard();
		    List<Pbx> pbxList = managerCardInfo.getPbxList();
		    for(Pbx pbx:pbxList){
		        PBXSmartControl pbxsmart = new PBXSmartControl();
		        pbxsmart = smartControlImpl.getPbxSmartControl(pbx.getConfigurationId());
		        pbxsmart.setBusNo(Integer.parseInt(pbx.getBusno().trim()));
		        pbxsmart.setSlotNo(Integer.parseInt(pbx.getSlotno().trim()));
		        pbxsmart.setConfigurationId(pbx.getConfigurationId());
		        pbxSmartControlList.add(pbxsmart);
		    }
			model.addAttribute("pbxSmartControlList", pbxSmartControlList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("pbxSmartControlList", pbxSmartControlList);
		}
		return "pbxSetting";
	}

	@RequestMapping("updatePbx.do")
	public void updatePbx(String tdm, int gciIndex,int configurationId, PrintWriter out,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		try {
			// xi
			smartControlImpl.updatePbx(user, tdm, gciIndex,configurationId);
			out.write("success");
		} catch (Exception e) {
			e.printStackTrace();
			out.write("fail");
		} finally {
			out.close();
		}
	}

	@RequestMapping("viewIp.do")
	public String viewIp(Model model) {
		VoIPSmartControl voIPSmart = new VoIPSmartControl();
		try {
			voIPSmart = smartControlImpl.getVoIPSmartControl();
		} catch (Exception e) {
			model.addAttribute("voIPSmart", voIPSmart);
			e.printStackTrace();
		}
		model.addAttribute("voIPSmart", voIPSmart);
		return "ipSetting";
	}

	@RequestMapping("viewNgx.do")
	public String viewNgx(Model model) {
		Map<String, String> boardTypeMap = BoardType.BOARDTYPE;
		List<NgxSmartControl> ngxSmartControlList = new ArrayList<NgxSmartControl>();
		try {
		    ManagerCardInfor managerCI = smartCardImpl.initManagerCard();
		    List<Ngx> ngxList = managerCI.getNgxList();
		    for(Ngx ngx :ngxList){
		    NgxSmartControl ngxSmartControl = new NgxSmartControl();
			ngxSmartControl = smartControlImpl.getNgx(ngx);
			System.out.println(ngxSmartControl);
//			Long tdmEncoding = smartControlImpl.getEncoding(ngx.getConfigurationId());
//			ngxSmartControl.setTdmEncoding(tdmEncoding);
			ngxSmartControlList.add(ngxSmartControl);
		    }
			String gciIndex = smartControlImpl.getStartingIndex();
			model.addAttribute("ngxSmartControlList", ngxSmartControlList);
			model.addAttribute("boardTypeMap", boardTypeMap);
//			model.addAttribute("tdmEncoding", tdmEncoding);
			model.addAttribute("startingIndex", gciIndex);
		} catch (Exception e) {
			model.addAttribute("ngxSmartControl", ngxSmartControlList);
			model.addAttribute("boardTypeMap", boardTypeMap);
			return "ngxSetting";
		}
		return "ngxSetting";
	}
	@RequestMapping("updateNgx.do")
	public void updateNgx(String tdmEncoding, int startingIndex,int configurationId,
			String basePbxType, String baseTermination, String basedcchanel,
			String dc1PbxType, String dc1Termination, String dc1dcchanel,
			String dc2PbxType, String dc2Termination, String dc2dcchanel,
			PrintWriter out, HttpSession session) {
		User user = (User) session.getAttribute("user");
		// boardBase
		SmartBoard boardBase = new SmartBoard();
		boardBase.setTdmEncoding(tdmEncoding);
		boardBase.setPbxType(basePbxType);
		boardBase.setdChannel(basedcchanel);
		boardBase.setTermination(baseTermination);
		if (dc1PbxType == null) {
			try {
				smartControlImpl.updateNgx(user, boardBase, null, null,
						startingIndex,configurationId);
				out.print("success");
				return;
			} catch (ServiceException e) {
				out.print("fail");
			} catch (Exception e) {
				out.print("fail");
			}
			System.out.println("===");
		}
		// boardDc1
		SmartBoard boardDc1 = new SmartBoard();
		boardDc1.setPbxType(dc1PbxType);
		boardDc1.setdChannel(dc1dcchanel);
		boardDc1.setTermination(dc1Termination);

		if (dc2PbxType == null) {
			try {
				smartControlImpl.updateNgx(user, boardBase, boardDc1, null,
						startingIndex,configurationId);
				out.print("success");
				return;
			} catch (ServiceException e) {
				out.print("fail");
			} catch (Exception e) {
				out.print("fail");
			}
		}
		// boardDc2
		SmartBoard boardDc2 = new SmartBoard();
		boardDc2.setPbxType(dc2PbxType);
		boardDc2.setdChannel(dc2dcchanel);
		boardDc2.setTermination(dc2Termination);

		try {
			smartControlImpl.updateNgx(user, boardBase, boardDc1, boardDc2,
					startingIndex,configurationId);
			out.print("success");
			return;
		} catch (ServiceException e) {
			e.printStackTrace();
			out.print("fail");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("fail");
		} finally {
			out.close();
		}

	}

	@RequestMapping("updateSystem")
	public void updateSystem(String tdm, int gciIndex, PrintWriter out,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		PBXSmartControl pbxsmart = new PBXSmartControl();
		SmartControlSystem smartControlSystem = new SmartControlSystem();
		// smartControlSystem.setGciStartIndex(gciIndex);
		pbxsmart.setTdmEncoding(tdm);

		try {
			smartControlImpl.updateSmartControlSystem(user, smartControlSystem,
					pbxsmart, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.write("success");
	}
	/**
	 * 修改voip
	 * 
	 * @param out
	 * @param voIPSmartControl
	 * @param monitor0Selected
	 * @param monitor1Selected
	 * @param session
	 */
	@RequestMapping("updateVoip.do")
	public void updateVoip(PrintWriter out, VoIPSmartControl voIPSmartControl,
			String monitor0Selected, String monitor1Selected,
			HttpSession session) {
		// port0 所选择网卡
		NetInterCard port0Nic = new NetInterCard();
		port0Nic.setServiceName(monitor0Selected);
		// port1 所选择网卡
		NetInterCard port1Nic = new NetInterCard();
		port1Nic.setServiceName(monitor1Selected);
		// 设置端口所选择的网卡
		voIPSmartControl.setMonitorPort0Selected(port0Nic);
		voIPSmartControl.setMonitorPort1Selected(port0Nic);
		User user = (User) session.getAttribute("user");

		System.out.println(voIPSmartControl.getRtcpQos());
		try {
			// 更新voip
			smartControlImpl.updateVoIp(user, voIPSmartControl);
			out.print("success");
		} catch (Exception e) {
			out.print("fail");
		} finally {
			out.close();
		}
	}

}
