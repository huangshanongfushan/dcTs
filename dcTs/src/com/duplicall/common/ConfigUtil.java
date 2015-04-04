package com.duplicall.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.duplicall.entities.TsConfig;

public class ConfigUtil {
	/**
	 * 跟新配置文件，修改最后的更新时间
	 * 
	 * @param file
	 * @param endtime
	 * @throws IOException
	 */
	public  void updateConfig(File file, String endtime) throws IOException {
		
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element lastTimeElement = rootElement.element("lasttime");
		lastTimeElement.setText(endtime);
		XMLWriter writer = new XMLWriter(new FileOutputStream(file));
		writer.write(document);
		writer.close();
	}

	/**
	 * 读取配置文件
	 * 
	 * @param file
	 * @return
	 */
	public  TsConfig readConfig(File file) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document matchFiledocument = null;
		matchFiledocument = saxReader.read(file);
		Element rootElement = matchFiledocument.getRootElement();
		String enable = rootElement.attributeValue("enable");
		Element lastTimeElement = rootElement.element("lasttime");
		String lasttime = lastTimeElement.getTextTrim();
		Element freElement = rootElement.element("frequency");
		long interval = Long.parseLong(freElement.getTextTrim());
		TsConfig tsConfig = new TsConfig();
		tsConfig.setEnable(enable);
		tsConfig.setInterval(interval);
		tsConfig.setLastTime(lasttime);
		return tsConfig;
	}
}
