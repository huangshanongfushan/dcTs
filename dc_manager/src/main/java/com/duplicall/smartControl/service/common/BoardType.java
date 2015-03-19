
/**   
 * @Title: BoardType.java 
 * @Package: com.duplicall.smartControl.service.common 
 * @Description: TODO
 * @author mli 
 * @date 2014年12月8日 下午10:25:22 
 * @update 
 * @date 2014年12月8日 下午10:25:22
 * @version 1.3.1 
 */


package com.duplicall.smartControl.service.common;

import java.util.HashMap;
import java.util.Map;

/** 
 * @Description 
 * @author mli
 * @date 2014年12月8日 下午10:25:22 
 * @version V1.3.1
 */

public interface BoardType {
    //板卡类型
    public static Map<String,String> BOARDTYPE=new HashMap<String, String>(){
        
        /** @Fields serialVersionUID: */
          	
        private static final long serialVersionUID = -4047691497377178057L;

        {
            put("701", "Alcatel 4200/4400");    
            put("703", "Alcatel 4095 phone");
            put("1B01", "Ascotel Intelligate");
            put("601", "Aspect");
            put("201", "Avaya Definity 2W");
            put("202", "Avaya Definity 4W");
            put("204", "Avaya Index");
            
            put("203", "Avaya Merlin Magix");
            put("205", "Avaya MLX");
            put("206", "Avaya Definity Console302");
            put("801", "Bosch Integral 2W");
            put("802", "Bosch Integral 4W");
            put("803", "Bosch Integral 55 2W");
            put("804", "Bosch Integral-3 4W");
            put("1101", "BRI ISDN");
            put("1102", "BRI ISDN NI1");
            put("1801", "eOn-EQ");
            put("401", "Ericsson ELU25/ELU28");
            put("402", "Ericsson ELU5");
            put("403", "Ericsson BP50/250/MD150A MFC/ELU-D3");
            put("1D01", "ESI-100 Estech Systems");
            put("1401", "Fujitsu F9600");
            put("A01", "Intecom 2-Wire");
            
            put("A02", "Intecom 4-Wire");
            put("B01", "Inter-Tel");
            
            put("1701", "LG Starex CS");
            put("1702", "LG LDK-5");
            put("1001", "Mitel Sx2000");
            put("1C01", "NAKAYO iZ-V2");
            put("304", "NEC");
            put("306", "NEC CONSOLE");
            put("103", "Nortel Matra");
            put("101", "Nortel Meridian1");
            
            put("102", "Nortel Norstar");
            put("104", "Nortel Meridian console");
            
            put("F01", "Panasonic KX");
            put("F02", "Panasonic 7600 Special");
            put("1301", "Philips SOPHO iS3000 2W");
            put("1302", "Philips SOPHO iS3000 4W");
            
            put("1303", "Philips SOPHO iS3000 4W TMP Phone");
            put("1E01", "Polycom 550D");
            put("1501", "Rockwell Spectrum");
            put("1201", "Samsung DCS-828");
            put("1202", "Samsung INFOREX");
            put("502", "Siemens RolmLINK");
            
            put("501", "Siemens Hicom/Hipath");
            put("503", "Siemens Realitis DTI 4W");
            put("504", "Siemens Realitis iSDT 2W");
            put("1901", "Tadiran Coral");
            
            put("D01", "Telrad 2W");
            put("1A01", "Teltronics (Harris2020)");
            put("1A02", "Teltronics (Comdial)");
            put("1601", "Toshiba Strata DK/CTX");
            
        }
    };
    
}
