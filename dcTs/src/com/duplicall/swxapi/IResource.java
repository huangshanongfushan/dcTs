package com.duplicall.swxapi;

import java.util.Map;

public interface IResource {
    /**
     * 
     * @Description
     * @author mli
     * @return
     * @throws Exception
     */
    public String getResources(String uri, int timeOut)
        throws Exception;
    
    /**
     * 
     * @Description
     * @author mli
     * @param uri
     * @param timeOut
     * @return
     * @throws Exception
     */
    public Map<Boolean, String> getResource(String uri, int timeOut)
        throws Exception;
    
}
