package com.duplicall.dao.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public interface Pool extends DataSource{
    /**
     * 用以关闭rs和ps的
     * @Description 
     * @author mli
     * @param rs
     * @param ps
     */
    public void colseRsPs(ResultSet rs, PreparedStatement ps);
    /**
     * 用以关闭ps
     * @Description 
     * @author mli
     * @param ps
     */
    public void colsePs(PreparedStatement ps);
    
}
