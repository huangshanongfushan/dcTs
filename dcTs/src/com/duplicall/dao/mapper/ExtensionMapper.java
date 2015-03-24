package com.duplicall.dao.mapper;
import java.sql.ResultSet;

import com.duplicall.dao.common.IRowMapper;
import com.duplicall.entities.Extension;

public class ExtensionMapper implements IRowMapper<Extension> {
    
    @Override
    public Extension getResults(ResultSet rs)
        throws Exception
    {
        Extension extension = new Extension();
        extension.setExtension(rs.getString("extension"));
        extension.setExtensionName(rs.getString("extName"));
        return extension;
    }
    
}
