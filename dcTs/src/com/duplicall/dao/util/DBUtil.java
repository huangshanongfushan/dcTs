package com.duplicall.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.duplicall.dao.common.IDBConnect;
import com.duplicall.dao.common.IRowMapper;

/**
 * 数据库操作工具，负责增删改查
 * 
 * @Description
 * @author mli
 * @date 2015年3月13日 下午4:34:52
 * @version V1.3.1
 * @param <T>
 */
public class DBUtil<T> implements IDBConnect<T> {
    
    private Connection connec;
    
    private Pool pool;
    
    public DBUtil() {
        super();
    }
    
    public DBUtil(String dbName) {
        // 若果1，加载dclog数据库的连接池
        if ("dclog".equals(dbName)) {
            pool = new DClogPool();
            try {
                connec = pool.getConnection();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return;
        }
        // 若果2，加载ngp数据库连接池
        pool = new NgpPool();
        try {
            connec = pool.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
    
    @Override
    public void update(String sql, String[] args)
        throws Exception
    {
        PreparedStatement ps = connec.prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            ps.setString(i, args[i]);
        }
        ps.executeUpdate();
        pool.colsePs(ps);
        
    }
    
    @Override
    public void update(String sql)
        throws Exception
    {
         PreparedStatement ps = connec.prepareStatement(sql);
         ps.executeUpdate();
         pool.colsePs(ps);
        
    }
    
    @Override
    public int insert(String sql, String[] args)
        throws Exception
    {
//        PreparedStatement updateSales = con.prepareStatement("UPDATE COFFEES SET SALES = ? WHERE COF_NAME LIKE ? ");
//        updateSales.setInt(1, 75);
//        updateSales.setString(2, "Colombian");
//        updateSales.executeUpdate();
        return 0;
    }
    
    @Override
    public int insert(String sql)
        throws Exception
    {
        PreparedStatement ps = connec.prepareStatement(sql);
        connec.prepareStatement(sql);
        ps.execute();
        pool.colsePs( ps);
        return 0;
    }
    
    @Override
    public T queryForObject(String sql, String[] args, IRowMapper<T> mapper)
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public T queryForObject(String sql, IRowMapper<T> mapper)
        throws Exception
    {

        PreparedStatement ps = connec.prepareStatement(sql);
        ps = connec.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        T t = null;
        while (rs.next()) {
          t  = mapper.getResults(rs);
        }
        pool.colseRsPs(rs, ps);
        return t;
    }
    
    @Override
    public List<T> queryForList(String sql, String[] args, IRowMapper<T> mapper)
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<T> queryForList(String sql, IRowMapper<T> mapper)
        throws Exception
    {
        PreparedStatement ps = connec.prepareStatement(sql);
        ps = connec.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<T> result = new ArrayList<T>();
        while (rs.next()) {
            T t = mapper.getResults(rs);
            result.add(t);
        }
        pool.colseRsPs(rs, ps);
        return result;
        
    }

    @Override
    public Object queryForObject(String sql, Class cls)
        throws Exception
    {
        PreparedStatement ps = connec.prepareStatement(sql);
        ps = connec.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
//        cls.forName(cls.getSimpleName());
        while(rs.next()){
            return rs.getObject(1);
        }
        return null;
    }

    @Override
    public List<Object> queryForList(String sql,Class cls)
        throws Exception
    {
        PreparedStatement ps = connec.prepareStatement(sql);
        ps = connec.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
       
        List<Object> objectList = new ArrayList<Object>();
        while(rs.next()){
            objectList.add(rs.getObject(1));
        }
        return objectList;
    }
    
}
