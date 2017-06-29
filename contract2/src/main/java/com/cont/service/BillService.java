package com.cont.service;

import java.util.List;

import com.cont.model.BillModel;
import com.cont.utils.Page;

/**
 * 报修单service层开发
 * @author Cao YaNan
 *
 */
public interface BillService {
	
	/**
	 * 分页查询维修单
	 * @param vo
	 * @return
	 */
	public Page<BillModel> selectBill(BillModel vo);
	
	/**
	 * 审核通过
	 */
	public int pass(long billId);
	
	/**
	 * 审核拒绝
	 */
	public int refuse(long billId);
	
	/**
	 * 批量通过
	 */
	public int batchPass(List<Long> billIds);
	/**
	 * 批量删除
	 */
	public int batchDelete(List<Long> billIds);
}