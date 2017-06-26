package com.cont.model;

import java.util.Date;

import com.cont.utils.SuperModel;

/**
 * 合同表实体类
 * 
 * 合同表字段
 * 
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `concat_person` varchar(50) DEFAULT NULL,
  `concat_phone` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_u_id` bigint(11) DEFAULT NULL,
  `concat_no` varchar(20) DEFAULT NULL,
  
 * @author Cao YaNan
 * @time 2017年6月24日下午5:11:15
 *
 */
public class ContractModel extends SuperModel{

	//主键id
	private Long id;
	
    //合同编号
    private String concatNo;

	//乙方姓名
    private String concatPerson;

    //乙方联系方式
    private String concatPhone;

    //合同创建时间
    private Date createTime;

    //合同创建人编号
    private Long createUId;

    //合同创建人姓名
    private String createUserName;

    public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcatPerson() {
        return concatPerson;
    }

    public void setConcatPerson(String concatPerson) {
        this.concatPerson = concatPerson == null ? null : concatPerson.trim();
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone == null ? null : concatPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUId() {
        return createUId;
    }

    public void setCreateUId(Long createUId) {
        this.createUId = createUId;
    }

    public String getConcatNo() {
        return concatNo;
    }

    public void setConcatNo(String concatNo) {
        this.concatNo = concatNo == null ? null : concatNo.trim();
    }

	@Override
	public String toString() {
		return "ContractModel [id=" + id + ", concatNo=" + concatNo + ", concatPerson=" + concatPerson
				+ ", concatPhone=" + concatPhone + ", createTime=" + createTime + ", createUId=" + createUId
				+ ", createUserName=" + createUserName + "]";
	}

	
    
}
