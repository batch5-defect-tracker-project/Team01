package com.defect.tracker.data.dto;

public class DefectStatusCountDto {

	private Long New;
	private Long open;
	private Long reopen;
	private Long closed;
	private Long fixed;
	private Long reject;

	public Long getNew() {
		return New;
	}

	public void setNew(Long new1) {
		New = new1;
	}

	public Long getOpen() {
		return open;
	}

	public void setOpen(Long open) {
		this.open = open;
	}

	public Long getReopen() {
		return reopen;
	}

	public void setReopen(Long reopen) {
		this.reopen = reopen;
	}

	public Long getClosed() {
		return closed;
	}

	public void setClosed(Long closed) {
		this.closed = closed;
	}

	public Long getFixed() {
		return fixed;
	}

	public void setFixed(Long fixed) {
		this.fixed = fixed;
	}

	public Long getReject() {
		return reject;
	}

	public void setReject(Long reject) {
		this.reject = reject;
	}

}
