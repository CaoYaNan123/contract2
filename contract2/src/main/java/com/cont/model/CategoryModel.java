package com.cont.model;

import java.util.Date;

import com.cont.utils.SuperModel;

/**
  
  设备类别模型实体类
  
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) DEFAULT NULL,
  `cat_desc` varchar(100) DEFAULT NULL,
  `parent_cat_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cat_level` int(11) DEFAULT NULL,
  
 * @author Cao YaNan
 * @time 2017年6月26日上午8:53:44
 *
 */
public class CategoryModel extends SuperModel {

	//类别主键ID
    private Long catId;

    //类别名称
    private String catName;

    //类别描述
    private String catDesc;

    //父类别ID
    private Long parentCatId;

    //创建时间
    private Date createTime;

    //类别层级
    private Integer catLevel;
    
    public CategoryModel () {
    	this.setLimit(10000);
    	this.setPageIndex(0);
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc == null ? null : catDesc.trim();
    }

    public Long getParentCatId() {
        return parentCatId;
    }

    public void setParentCatId(Long parentCatId) {
        this.parentCatId = parentCatId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Integer catLevel) {
        this.catLevel = catLevel;
    }

	@Override
	public String toString() {
		return "CategoryModel [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", parentCatId="
				+ parentCatId + ", createTime=" + createTime + ", catLevel=" + catLevel + "]";
	}
    
}
