package com.cont.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cont.dao.CategoryDao;
import com.cont.model.CategoryModel;

/**
 * 设备类别dao测试类
 * 
 * @author Cao YaNan
 * @time 2017年6月26日上午9:06:31
 *
 */
public class CategoryDaoTest {

	static CategoryDao categoryDao = null;
	static {
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		categoryDao = ac.getBean(CategoryDao.class);
	}
	
	/**
	 * getAllCounts方法测试
	 */
	@Test
	public void testGetAllCounts() throws Exception {
		int counts = categoryDao.getAllCounts();
		System.out.println(counts);
	}
	
	/**
	 * selectByPage方法测试
	 */
	/**
	 * @throws Exception
	 */
	@Test
	public void testSelectByPage() throws Exception {

		CategoryModel category = new CategoryModel();
		List<CategoryModel> list = categoryDao.selectByPage(category);
		for (CategoryModel l : list) {
			System.out.println(l);
		}
		tree(list, 0);
		for (CategoryModel l : linkList) {
			System.out.println(l);
		}
		System.out.println(linkList.size());
		
	}
	List<CategoryModel> linkList = new LinkedList<>();
	/**
	 * 递归
	    Row: 1, 总类别, 总类别, 0, 2017-06-20 13:49:22.0, 1
<==     Row: 2, 电器, 电器, 1, 2017-06-20 13:49:53.0, 2
<==     Row: 3, 家具, 家具, 1, 2017-06-20 13:49:56.0, 2
<==     Row: 4, 电视, 电视, 2, 2017-06-20 13:50:24.0, 3
<==     Row: 5, 电脑, 电脑, 2, 2017-06-20 13:50:43.0, 3
<==     Row: 6, 办公家具, 办公家具, 3, 2017-06-20 13:51:12.0, 3
	 */
	private void tree (List<CategoryModel> list, long pid) {
		
		for (CategoryModel cat : list) {
			
			if (cat.getParentCatId() == pid) {
				//说明找到，首先保存
				linkList.add(cat);
				//改变条件，找到当前分类的后代分类，就是递归
				tree (list, cat.getCatId());
			}
		}
	}
	
	
	/**
	 * getCatLevelByPId方法测试
	 */
	@Test
	public void testGetCatLevelByPId() throws Exception {
		int catLevel = categoryDao.getCatLevelById(2L);
		System.out.println(catLevel);
	}
	
	/**
	 * save方法测试
	 */
	@Test
	public void testSave() throws Exception {
		CategoryModel category = new CategoryModel();
		category.setCatName("数码");
		category.setParentCatId(1L);
		category.setCatDesc("数码高科技产品");
		category.setCatLevel(2);
		category.setCreateTime(new Date());
		
		int count = categoryDao.save(category);
		System.out.println(count);
	}
	/**
	 * getCatById方法测试
	 */
	@Test
	public void testGetCatById() throws Exception {
		CategoryModel category = categoryDao.getCatById(1L);
		
		System.out.println(category);
	}
	
	/**
	 * 更新方法测试
	 */
	@Test
	public void testUpdate() throws Exception {
		CategoryModel category = new CategoryModel();
		category.setCatId(12L);
		category.setCatName("哈哈");
		category.setCatDesc("哈哈哈哈哈");
		category.setParentCatId(10L);
		category.setCatLevel(5);
		
		Integer count = categoryDao.update(category);
		System.out.println("影响行数:"+count);
	}
	
	/**
	 * 删除方法测试
	 */
	@Test
	public void testDelete() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(19L);
		list.add(20L);
		list.add(22L);
		
		Integer counts = categoryDao.delete(list);
		System.out.println("影响行数:"+counts);
	}
	
	/**
	 * 删除方法测试
	 */
	@Test
	public void testDeleteById() throws Exception {
		Integer counts = categoryDao.deleteById(55L);
		System.out.println("影响行数:"+counts);
	}
	
	/**
	 * 通过主键得到姓名测试
	 */
	@Test
	public void testGetNameById() throws Exception {
		String name = categoryDao.getNameById(3L);
		System.out.println(name);
	}
}
