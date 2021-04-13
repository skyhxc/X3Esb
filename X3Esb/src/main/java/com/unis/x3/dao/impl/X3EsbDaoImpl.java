package com.unis.x3.dao.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.unis.x3.dao.X3EsbDao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

/**
 * 
 * @author 胡晓聪
 * @description x3查询dao实现类
 *
 */
@Repository
public class X3EsbDaoImpl implements X3EsbDao {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public PageResult<Entity> pageQueryByEntity(Entity condition, Page page) throws Exception {

		try {
			return Db.use().page(condition, page);
		} catch (SQLException e) {

			log.error("---分页查询--:" + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Entity> commonQueryByEntity(Entity condition) throws Exception {
		try {
			return Db.use().find(condition);
		} catch (SQLException e) {

			log.error("---普通查询--:" + e.getMessage());
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> pageQueryBySql(String condition, Page page) throws Exception {
		try {
			return Db.use().query(condition, Collections.EMPTY_MAP);
		} catch (SQLException e) {

			log.error("---分页查询--:" + e.getMessage());
			throw e;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> commonQueryBySql(String condition) throws Exception {
		try {
			return Db.use().query(condition, Collections.EMPTY_MAP);
		} catch (SQLException e) {

			log.error("---普通查询--:" + e.getMessage());
			throw e;
		}
		
	}
    
	@Override
	public Long count(String condition) throws Exception {
		try {
			Entity rec = Db.use().queryOne(condition, new Object[] {});
			Long cnt = rec.getLong("cnt");
			return cnt;
		} catch (SQLException e) {

			log.error("---普通查询--:" + e.getMessage());
			throw e;
		}
		
	}

	
}
