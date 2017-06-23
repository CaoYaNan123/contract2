package com.cont.service;

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
}