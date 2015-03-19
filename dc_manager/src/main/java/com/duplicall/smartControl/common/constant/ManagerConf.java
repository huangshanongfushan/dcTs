package com.duplicall.smartControl.common.constant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.duplicall.smartControl.pojo.Ngx;
import com.duplicall.smartControl.pojo.Pbx;
import com.duplicall.smartControl.pojo.Voip;

public class ManagerConf {
	private final static String CONFLOCATION = "D://commonConf.xml";
//	private static ManagerConf managerConf;
	private static List<Pbx> pbxList;
	private static List<Voip> voipList;
	private static List<Ngx> ngxList;
	private static void intial(){
	    pbxList = new ArrayList<Pbx>();
	    voipList = new ArrayList<Voip>();
	    ngxList = new ArrayList<Ngx>();
	}
	public static List<Pbx> getPbxList() {
        return pbxList;
    }

    public static List<Voip> getVoipList() {
        return voipList;
    }

    public static List<Ngx> getNgxList() {
        return ngxList;
    }
    static {
		// ParserFactory
	   intial();
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(CONFLOCATION)); // 读取XML文件,获得document对象
			Element rootElement = document.getRootElement();
			// List<Element> elementList = rootElement.elements("pbx");
			Element pbxListElement = rootElement.element("pbxlist");
			List<Element> pbxElementList = pbxListElement.elements("pbx");
			for(Element element:pbxElementList){
			    Pbx pbx = new Pbx();
			    pbx.setBoardNumber(element.attributeValue("boardnumber"));
			    pbx.setBusno(element.attributeValue("busno"));
			    pbx.setSlotno(element.attributeValue("slotno"));
			    pbxList.add(pbx);
			}
			
			Element voipListElement = rootElement.element("voiplist");
			List<Element> voipElementList = voipListElement.elements("voip");
			for(Element element:voipElementList){
                Voip voip = new Voip();
                voip.setBoardNumber(element.attributeValue("boardnumber"));
                voip.setBusno(element.attributeValue("busno"));
                voip.setSlotno(element.attributeValue("slotno"));
                voipList.add(voip);
            }
			
			Element ngxListElement = rootElement.element("ngxlist");
			List<Element> ngElementxList = ngxListElement.elements("ngx");
			for(Element element:ngElementxList){
                Ngx ngxp = new Ngx();
                ngxp.setBoardNumber(element.attributeValue("boardnumber"));
                ngxp.setBusno(element.attributeValue("busno"));
                ngxp.setSlotno(element.attributeValue("slotno"));
                ngxList.add(ngxp);
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
