package com.madder.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao<T> {

	/**
	 * 保存
	 * @param obj
	 * @return
	 */
	Object save(Object obj);
	
	/**
	 * 删除
	 * @param obj
	 */
	void delete(Object obj);
	
	/**
	 * 更新
	 * @param obj
	 */
	void update(Object obj);
	
	/**
	 * 保存或更新，实体无主键时保存
	 * @param obj
	 */
	void saveOrUpdate(Object obj);
	
	/**
	 * 保存所有实体
	 * @param obj
	 */
	void saveAll(Collection<?> obj);
	
	/**
	 * 删除所有实体
	 * @param obj
	 */
	void deleteAll(Collection<?> obj);
	
	/**
	 * 更新所有实体
	 * @param obj
	 */
	void updateAll(Collection<?> obj);
	
	/**
	 * 保存或更新所有实体
	 * @param obj
	 */
	void saveorUpdateAll(Collection<?> obj);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	T getById(String className, Serializable id);
	
	/**
	 * 通过sql语句和参数获取实体
	 * @param sqlString
	 * @param params
	 * @return
	 */
	T get(String sqlString, Object... params);
	
	/**
	 * 通过sql语句和参数获取全部实体
	 * @param sqlString
	 * @param params
	 * @return
	 */
	List<T> findAll(String sqlString, Object... params);
	
	/**
	 * 分页查询
	 * @param start
	 * @param count
	 * @param sqlString
	 * @param params
	 * @return
	 */
	List<T> findByPage(int start, int count, String sqlString, Object... params);
	
	/**
	 * 统计记录数
	 * @param sqlString
	 * @param params
	 * @return
	 */
	int count(String sqlString, Object... params);
}
