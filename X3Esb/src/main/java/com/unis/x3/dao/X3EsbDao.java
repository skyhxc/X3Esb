package com.unis.x3.dao;

import java.util.List;

import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

/**
 * 
 * @author 胡晓聪
 * @description x3查询dao接口
 *
 */
public interface X3EsbDao {
	/**
	 * 
	 * @param condition
	 * @param page
	 * @return 使用entity进行分页查询
	 * @throws Exception
	 */
	PageResult<Entity> pageQueryByEntity(Entity condition, Page page) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return 使用Entity进行普通查询
	 * @throws Exception
	 */
	List<Entity> commonQueryByEntity(Entity condition) throws Exception;

	/**
	 * 
	 * @param condition
	 * @param page
	 * @return 使用普通sql进行分页查询
	 * @throws Exception
	 */
	List<Entity> pageQueryBySql(String condition, Page page) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return 使用普通sql进行普通查询
	 * @throws Exception
	 */
	List<Entity> commonQueryBySql(String condition) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return 查询记录数
	 * @throws Exception
	 */
	Long count(String condition) throws Exception;
}
