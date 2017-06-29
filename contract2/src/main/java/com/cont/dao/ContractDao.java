package com.cont.dao;

import java.util.List;

import com.cont.model.BillModel;
import com.cont.model.ContractModel;

/**
 * 合同contract dao接口
 * @author Cao YaNan
 * @time 2017年6月25日下午8:31:58
 *
 */
public interface ContractDao {
	

	/**
	 * 合同记录总数量查询
	 * @return 总记录数
	 */
	public int getAllCounts();
	
	
	/**
	 * 分页查询
	 * @param 合同pojo类
	 * @return 合同记录list集合
	 */
	public List<ContractModel> selectByPage(ContractModel contract);
	
	
	/**
	 * 增加一条合同
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
	
	/**
	 * 生成合同编号时需要获取当前的最大值(0001)
	 */
	public String getMaxNo(String currentDate);
}
