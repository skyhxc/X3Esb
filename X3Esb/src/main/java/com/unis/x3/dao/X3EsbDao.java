package com.unis.x3.dao;

import java.util.List;

import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;

/**
 * 
 * @author ������
 * @description x3��ѯdao�ӿ�
 *
 */
public interface X3EsbDao {
	/**
	 * 
	 * @param condition
	 * @param page
	 * @return ʹ��entity���з�ҳ��ѯ
	 * @throws Exception
	 */
	PageResult<Entity> pageQueryByEntity(Entity condition, Page page) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return ʹ��Entity������ͨ��ѯ
	 * @throws Exception
	 */
	List<Entity> commonQueryByEntity(Entity condition) throws Exception;

	/**
	 * 
	 * @param condition
	 * @param page
	 * @return ʹ����ͨsql���з�ҳ��ѯ
	 * @throws Exception
	 */
	List<Entity> pageQueryBySql(String condition, Page page) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return ʹ����ͨsql������ͨ��ѯ
	 * @throws Exception
	 */
	List<Entity> commonQueryBySql(String condition) throws Exception;

	/**
	 * 
	 * @param condition
	 * @return ��ѯ��¼��
	 * @throws Exception
	 */
	Long count(String condition) throws Exception;
}
