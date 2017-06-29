package com.cont.service.imp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.CategoryDao;
import com.cont.model.CategoryModel;
import com.cont.service.ICategoryService;
import com.cont.utils.Page;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public int getAllCounts() {
		return categoryDao.getAllCounts();
	}

	@Override
	public Page<CategoryModel> selectByPage(CategoryModel category) {
		// new出一个Page返回类
		Page<CategoryModel> page = new Page<CategoryModel>();
		// 查询总记录数
		int allCounts = categoryDao.getAllCounts();

		// Page类中的所有行
		List<CategoryModel> list = new ArrayList<CategoryModel>();

		if (allCounts > 0) {
			list = categoryDao.selectByPage(category);
			list = getClassifyList(list,category.getParentCatId());
		}
		page.setResults(allCounts);
		page.setRows(list);

		return page;
	}

	/**
	 * 根据cat_id获取cat_level
	 */
	public Integer getCatLevelById(Long id) {
		return categoryDao.getCatLevelById(id);
	}

	/**
	 * 保存
	 */
	public Integer save(CategoryModel category) {
		return categoryDao.save(category);
	}

	/**
	 * 返回分类集合
	 */
	public List<CategoryModel> getClassifyList(List<CategoryModel> list, long pid) {

		linkList.clear();
		
		if (list == null && pid == 0) {
			// 新增或者修改获取父类名称参数

			CategoryModel nullCategory = new CategoryModel();
			// 创建  "--请选择--"
			nullCategory.setCatId(0L);
			nullCategory.setParentCatId(-1L);
			nullCategory.setCatName("--请选择--");
			linkList.add(nullCategory);

			list = categoryDao.selectByPage(new CategoryModel());
		} else if (list == null && pid != 0) {
			//得到以此id为父id下所有的子类别
			
			list = categoryDao.selectByPage(new CategoryModel());
		}else if (list != null ) {
			//给定的集合，返还分类好的集合
			if (pid == 0 || pid == -1) {
				pid = 1;
			}
		}
		recursion(list, pid);

		return new ArrayList<CategoryModel>(linkList);
	}

	/**
	 * 递归显示类别
	 */
	private List<CategoryModel> linkList = new LinkedList<CategoryModel>();

	private void recursion(List<CategoryModel> list, long pid) {
		for (CategoryModel cat : list) {
			if (cat.getParentCatId() == pid) {
				// 说明找到，首先保存
				linkList.add(cat);
				// 改变条件，找到当前分类的后代分类，就是递归
				recursion(list, cat.getCatId());
			}
		}
	}

	/**
	 * 通过主键ID获取类别信息
	 */
	public CategoryModel getCatById(long catId) {
		return categoryDao.getCatById(catId);
	}

	/**
	 * 通过主键更新cat_name,cat_desc,parent_cat_id,cat_level
	 */
	public Integer update(CategoryModel category) {
		return categoryDao.update(category);
	}
	
	public Integer delete (List<Long> ids) {
		return categoryDao.delete(ids);
	}

	
	/**
	 * 通过主键删除一个类别
	 */
	public int deleteById (long id) {
		return categoryDao.deleteById(id);
	}
	
	/**
	 * 通过主键获取姓名
	 */
	public String getNameById (Long catId) {
		return categoryDao.getNameById(catId);
	}
}
