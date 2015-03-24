package com.duplicall.dao.extension;

import java.util.List;

import com.duplicall.entities.Extension;

public interface IExtensionDao {
	
	  /**
     * 
     * @Description 
     * @author mli
     * @return
     * @throws Exception
     */
    public List<Extension> getExtensionList()
        throws Exception;
    /**
     * 
     * @Description 
     * @author mli
     * @return
     * @throws Exception
     */
    public Extension getExtensionByExtension(String extension)
        throws Exception;
}
