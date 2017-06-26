package com.cont.service;

import java.util.List;

import com.cont.model.ContractModel;
import com.cont.utils.Page;

/**
 * 合同service层接口
 * @author Cao YaNan
 * @time 2017年6月25日下午8:25:09
 *
 */
public interface ContractService {
	
	/**
	 * 分页查询合同表
	 * @param vo
	 * @return
	 */
	public Page<ContractModel> selectContract(ContractModel contract);
	
	/**
	 * 添加一条合同记录
	 * @return 影响的行数
	 */
	public int save (ContractModel contract);
	
	/**
	 * 根据主键查询一条合同
	 * @param id 主键
	 * @return 合同实体类
	 */
	public ContractModel getContractById (long id);
	
	/**
	 * 更新
	 * @param contract 实体类
	 * @return 影响的行数
	 */
	public int update (ContractModel contract);
	
	/**
	 * 通过主键删除一条合同
	 */
	public int deleteById (long id);
	
	
	/**
	 * 通过主键List集合删除多条合同
	 */
	public int deleteByIds (List<Long> ids);
}