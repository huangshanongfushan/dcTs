package com.duplicall.dao.common;

import java.sql.ResultSet;

public interface IRowMapper<T> {
    public T getResults(ResultSet rs)
        throws Exception;
    
}
