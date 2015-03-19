package com.duplicall.dao.common;

import java.util.List;

public interface IDBConnect<T> {
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @param args
     * @throws Exception;
     */
    public void update(String sql, String[] args)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @throws Exception;
     */
    public void update(String sql)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @param args
     * @return
     * @throws Exception;
     */
    public T queryForObject(String sql, String[] args, IRowMapper<T> mapper)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @return
     * @throws Exception;
     */
    public T queryForObject(String sql, IRowMapper<T> mapper)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @param args
     * @return
     * @throws Exception;
     */
    public List<T> queryForList(String sql, String[] args, IRowMapper<T> mapper)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @return
     * @throws Exception;
     */
    public List<T> queryForList(String sql, IRowMapper<T> mapper)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @param args
     * @return
     * @throws Exception;
     */
    public int insert(String sql, String[] args)
        throws Exception;;
    
    /**
     * 
     * @Description
     * @author mli
     * @param sql
     * @return
     * @throws Exception;
     */
    public int insert(String sql)
        throws Exception;;
    /**
     * 普通查询
     * @Description 
     * @author mli
     * @param sql
     * @param cls
     * @return
     * @throws Exception;
     */
    public Object queryForObject(String sql, Class cls)
        throws Exception;;
    /**
     * 
     * @Description 
     * @author mli
     * @param sql
     * @param cls
     * @return
     * @throws Exception;
     */
    public List<Object> queryForList(String sql,Class cls)
        throws Exception;
}
