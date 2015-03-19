package com.duplicall.smartControl.service.common;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.duplicall.smartControl.entity.Ngx;

/**
 * 
 * @author mli
 *
 */
public class ParseManagerConfig {
	
	public static Ngx parseManager(String path){
		File managerFile = new File(path);
		SAXReader saxReader =  new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(managerFile);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element ngxElement = rootElement.element("ngx");
		Element boardNumElement = ngxElement.element("boarNumber");
		Element busNumElement = ngxElement.element("busNumber");
		Element totalChanelsElement = ngxElement.element("totalChanels");
		Element mtxBrdNumElement = ngxElement.element("mtxBrdNumber");
		Ngx ngx = new Ngx();
		ngx.setBoarNumber(boardNumElement.getTextTrim());
		ngx.setBusNumber(busNumElement.getTextTrim());
		ngx.setMtxBrdNumber(Integer.parseInt(mtxBrdNumElement.getTextTrim()));
		ngx.setTotalChanels(Integer.parseInt(totalChanelsElement.getTextTrim()));
		return ngx;
	}
	public static void main(String[] args) {
		ParseManagerConfig.parseManager("c://manager/config/config.xml");
	}

}
