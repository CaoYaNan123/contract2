package com.cont.utils;

import java.util.List;

/**
 * Page类，
 * 里面封装的是记录总条数results(int类型)和每条记录(List<T>类型)
 * 		
 * @param <T> 泛型
 */
public class Page<T> {

	private int results;
	
	private List<T> rows;
	
	
	public Page() {
		super();
	}
	public Page(int results, List<T> rows) {
		super();
		this.results = results;
		this.rows = rows;
	}



	public int getResults() {
		return results;
	}



	public void setResults(int results) {
		this.results = results;
	}



	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	

}
