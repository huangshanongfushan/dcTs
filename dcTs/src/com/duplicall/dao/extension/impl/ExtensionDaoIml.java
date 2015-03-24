package com.duplicall.dao.extension.impl;

import java.util.List;

import com.duplicall.dao.extension.IExtensionDao;
import com.duplicall.dao.mapper.ExtensionMapper;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.Extension;

public class ExtensionDaoIml implements IExtensionDao{
	private DBUtil<Extension> dbUtil = new DBUtil<Extension>("dclog");

	@Override
	public List<Extension> getExtensionList() throws Exception {
		String sql = "select * from extension";
        List<Extension> extensionList = dbUtil.queryForList(sql, new ExtensionMapper());
        return extensionList;
	}

	@Override
	public Extension getExtensionByExtension(String extension) throws Exception {
		String sql = "select * from extension where extension='"+extension+"'";
        return dbUtil.queryForObject(sql, new ExtensionMapper());
	}
}
