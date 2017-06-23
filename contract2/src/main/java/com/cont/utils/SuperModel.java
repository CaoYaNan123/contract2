package com.cont.utils;


import java.util.List;

/**
 * Created by lq on 2017/5/4.
 */
public abstract class SuperModel {

    private String create_u_id;
    private String create_name;
    private String create_cname;
    
    private String create_time;
    private String update_u_id;
    private String update_name;
    private String update_cname;
    private String update_time;
    //从第多少条开始
    private Integer pageIndex;

    //页面显示条数
    private Integer pageSize = 15;

	public String getCreate_u_id() {
		return create_u_id;
	}

	public void setCreate_u_id(String create_u_id) {
		this.create_u_id = create_u_id;
	}

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	public String getCreate_cname() {
		return create_cname;
	}

	public void setCreate_cname(String create_cname) {
		this.create_cname = create_cname;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_u_id() {
		return update_u_id;
	}

	public void setUpdate_u_id(String update_u_id) {
		this.update_u_id = update_u_id;
	}

	public String getUpdate_name() {
		return update_name;
	}

	public void setUpdate_name(String update_name) {
		this.update_name = update_name;
	}

	public String getUpdate_cname() {
		return update_cname;
	}

	public void setUpdate_cname(String update_cname) {
		this.update_cname = update_cname;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
