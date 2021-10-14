package com.learning.coursemanagement.entrypoints.response.common;

import com.learning.coursemanagement.common.errors.base.Errors;

import java.util.List;

public class RestResponse<T> {

	private Errors errors;

	private List<T> data;

	private Integer limit;

	private Integer offset;

	public RestResponse() {
	}

	public Errors getErrors() {
		return this.errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	public List<T> getData() {
		return this.data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
