package com.cont.dao;

import java.util.List;

import com.cont.model.CategoryModel;

/**
 * 类别Dao层
 * @author Cao YaNan
 * @time 2017年6月26日上午8:58:43
 *
 */
public interface CategoryDao {

	/**
	 * 查询类别总条数
	 */
	public int getAllCounts ();

	/**
	 * 分页条件查询
	 * @param category
	 * @return
	 */
	public List<CategoryModel> selectByPage(CategoryModel category);
	
	/**
	 * 根据cat_id获取cat_level
	 */
	public Integer getCatLevelById (Long pid);
	
	/**
	 * save
	 */
	public Integer save (CategoryModel category);
	
	/**
	 * 通过主键ID获取类别信息
	 */
	public CategoryModel getCatById(Long catId);
	
	/**
	 * 通过主键更新cat_name,cat_desc,parent_cat_id,cat_level
	 */
	public Integer update (CategoryModel category);
	
	/**
	 * 删除
	 */
	public Integer delete (List<Long> ids);
	
	/**
	 * 通过主键删除一条类别
	 */
	public Integer deleteById (Long catId);
	
	/**
	 * 通过主键获取姓名
	 */
	public String getNameById (Long catId);
}
