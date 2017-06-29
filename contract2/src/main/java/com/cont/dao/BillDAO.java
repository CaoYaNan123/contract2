package com.cont.dao;

import java.util.List;

import com.cont.model.BillModel;

/**
 * 保修单dao设计
 * 
 * @author Cao YaNan
 *
 */
public interface BillDAO {
	
	/**
	 * 查询全部维修单
	 * @param model
	 * @return 维修单list集合
	 */
	public List<BillModel> selectAll(BillModel model);
	
	/**
	 * 添加一个维修单
	 * 	用户前台报修提交
	 * @param model
	 * @return 是否成功提交
	 */
	public int insertBill(BillModel model);
	
	/**
	 * 维修单修改编辑
	 * @param model
	 * @return 是否成功修改
	 */
	public int updateByPk(BillModel model);
	
	/**
	 * 分页查询
	 * @param model
	 * @return 维修单list集合
	 */
	public List<BillModel> selectByPage(BillModel model);
	
	/**
	 * 维修单数量查询
	 * @param model
	 * @return 维修单数量
	 */
	public int selectCount(BillModel model);
	
	/**
	 * 删除维修单(逻辑删除)
	 * @param ids
	 * @return 是否成功删除
	 */
	public int deleteByPks(String ids);
	
	
	/**
	 * 审核通过
	 */
	public Integer pass(Long billId);
	
	/**
	 * 审核拒绝
	 */
	public Integer refuse(Long billId);
	
	/**
	 * 批量删除
	 */
	public Integer batchPass(List<Long> ids);
	
	/**
	 * 批量删除
	 */
	public Integer batchDelete(List<Long> ids);
	
}
