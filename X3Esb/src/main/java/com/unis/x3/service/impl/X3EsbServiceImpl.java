package com.unis.x3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unis.x3.dao.X3EsbDao;
import com.unis.x3.service.X3EsbService;

import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

/**
 * 
 * @author 胡晓聪
 * @description x3查询serveice实现类
 *
 */
@Service
public class X3EsbServiceImpl implements X3EsbService {
	@Autowired
	private X3EsbDao dao;

	@Override
	public PageResult<Entity> pageQueryByEntity(Entity condition, Page page) throws Exception {

		return dao.pageQueryByEntity(condition, page);
	}

	@Override
	public List<Entity> commonQueryByEntity(Entity condition) throws Exception {

		return dao.commonQueryByEntity(condition);
	}

	@Override
	public List<Entity> pageQueryBySql(String condition, Page page) throws Exception {

		return dao.pageQueryBySql(condition, page);
	}

	@Override
	public List<Entity> commonQueryBySql(String condition) throws Exception {
		// TODO Auto-generated method stub
		return dao.commonQueryBySql(condition);
	}

	@Override
	public Long count(String condition) throws Exception {
		return dao.count(condition);
	}

}
