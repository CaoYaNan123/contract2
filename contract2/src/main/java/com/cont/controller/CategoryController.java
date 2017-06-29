package com.cont.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cont.dao.CategoryDao;
import com.cont.model.CategoryModel;
import com.cont.model.ContractModel;
import com.cont.model.UserModel;
import com.cont.service.BillService;
import com.cont.service.ICategoryService;
import com.cont.service.imp.CategoryServiceImpl;
import com.cont.utils.Page;

/**
 * 设备种类控制层开发
 * 
 * @author Cao YaNan
 * @time 2017年6月26日下午10:34:40
 *
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	/**
	 * 获取要搜索条件的父类别的参数,结果是url，使用转发
	 */
	@RequestMapping("/getSearchParam")
	public ModelAndView getSearchParam() {
		ModelAndView view = new ModelAndView();

		// 设置父类别cat_id和父类别名称parent_cat_id
		view.addObject("category", categoryService.getClassifyList(null , 0));
		// device/category.jsp
		view.setViewName("/device/category");
		return view;
	}

	@ResponseBody
	@RequestMapping("/query")
	public Page<CategoryModel> query(CategoryModel category) {
		
		Page<CategoryModel> page = categoryService.selectByPage(category);
		return page;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Map<String, Boolean> save(CategoryModel category) {
		// 设置类别的创建时间
		category.setCreateTime(new Date());
		// 得到父类级别
		int parentLevel = categoryService.getCatLevelById(category.getParentCatId());
		// 设置类别级别
		category.setCatLevel(parentLevel + 1);

		Integer count = categoryService.save(category);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (count == 1) {
			// 增加成功
			map.put("success", true);
		} else {
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 获取要添加的父类别的参数(添加的第一步),结果是url，使用转发
	 */
	@RequestMapping("/getSaveParam")
	public ModelAndView getSaveParam() {
		ModelAndView view = new ModelAndView();

		// 设置父类别cat_id和父类别名称parent_cat_id
		view.addObject("category", categoryService.getClassifyList(null , 0));
		view.setViewName("/device/categoryAdd");
		return view;
	}

	/**
	 * 获取要更新操作的参数,结果是url，使用转发
	 */
	@RequestMapping("/getUpdateParam")
	public ModelAndView getUpdateParam(CategoryModel category) {

		category = categoryService.getCatById(category.getCatId());

		ModelAndView view = new ModelAndView();

		view.addObject("category", category);
		// 设置父类别cat_id和父类别名称parent_cat_id
		view.addObject("catList", categoryService.getClassifyList(null , 0));
		// device/category.jsp
		view.setViewName("/device/categoryUpdate");
		return view;
	}
	
	
	/**
	 * 更新，结果转成json
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Boolean> update(CategoryModel category) {
		int parentLevel = categoryService.getCatLevelById(category.getParentCatId());
		// 设置类别级别
		category.setCatLevel(parentLevel + 1);
		//级别已设置，类别名称、类别描述、类别父类已填写，主键已隐藏，创建时间不变

		Integer count = categoryService.update(category);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (count == 1) {
			// 增加成功
			map.put("success", true);
		} else {
			map.put("success", false);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("delete")
	public Map<String,String> delete (@RequestBody List<String> ids, HttpServletRequest request) {
		//返回的map
		Map<String, String> map = new HashMap<String, String>();
		
		//是否询问确认删除
		boolean isConfirm = false;
		//将要删除的类别名字
		StringBuffer confirmDelete = new StringBuffer(); 
		
		//是否最终已经删除
		boolean isAlready = false;
		//已经删除的类别的名字
		StringBuffer alreadyDelete = new StringBuffer();
		
		//是否删除的时候出现意外
		boolean isError = false;
		StringBuffer errorDelete = new StringBuffer();
		
		List<Long> list = new ArrayList<>();
		for (String id : ids) {
			long catId = Long.parseLong(id);
			
			List<CategoryModel> childs = categoryService.getClassifyList(null, catId);
			
			if (childs.size() != 0) {
				isConfirm = true;
				confirmDelete.append(categoryService.getNameById(catId)+"具有有子类别：");
				for (CategoryModel child : childs) {
					confirmDelete.append(child.getCatName()+'、');
				}
				confirmDelete.deleteCharAt(confirmDelete.length()-1);
			} else {
				isAlready = true;
				alreadyDelete.append(categoryService.getNameById(catId)+"、");
				
				if (categoryService.deleteById(catId) != 1) {
					isError = true;
					errorDelete.append(categoryService.getNameById(catId));
				}
			}
		}
		
		map.put("isError", String.valueOf(isError));
		map.put("isConfirm", String.valueOf(isConfirm));
		map.put("isAlready", String.valueOf(isAlready));
		
		if (isError) {
			map.put("errorDelete", errorDelete.substring(0, errorDelete.length()-1));
		}
		if (isConfirm) {
			map.put("confirmDelete", confirmDelete.toString());
		}
		if (isAlready) {
			map.put("alreadyDelete", alreadyDelete.substring(0, alreadyDelete.length()-1));
		}
		
		return map;
	}

}
