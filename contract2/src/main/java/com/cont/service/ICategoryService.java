package com.cont.service;

import java.util.List;
import java.util.Map;

import com.cont.model.CategoryModel;
import com.cont.utils.Page;

/**
 * 设备种类服务层接口设计
 * @author Cao YaNan
 * @time 2017年6月26日下午10:31:15
 *
 */
public interface ICategoryService {

	/**
	 * 查询类别总条数
	 */
	public int getAllCounts ();

	/**
	 * 分页条件查询
	 * @param category
	 * @return
	 */
	public Page<CategoryModel> selectByPage(CategoryModel category);
	
	/**
	 * 根据cat_id获取cat_level
	 */
	public Integer getCatLevelById (Long id);
	
	/**
	 * 保存
	 */
	public Integer save (CategoryModel category);
	
	
	/**
	 * 通过主键ID获取类别信息
	 */
	public CategoryModel getCatById(long catId);
	
	/**
	 * 通过主键更新cat_name,cat_desc,parent_cat_id,cat_level
	 */
	public Integer update (CategoryModel category);
	
	/**
	 * 返回分类集合
	 */
	public List<CategoryModel> getClassifyList(List<CategoryModel> list, long pid);
	
	/**
	 * 删除list集合里面的数据
	 */
	public Integer delete (List<Long> ids);
	
	
	/**
	 * 通过主键删除一个类别
	 */
	public int deleteById (long id);
	
	/**
	 * 通过主键获取姓名
	 */
	public String getNameById (Long catId);
	
}
