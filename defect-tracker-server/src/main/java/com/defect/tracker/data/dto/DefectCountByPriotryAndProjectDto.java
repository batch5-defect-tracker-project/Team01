package com.defect.tracker.data.dto;

public class DefectCountByPriotryAndProjectDto {
	private Long priorityHigh;
	private Long priorityMedium;
	private Long priorityLow;
	private Long severityHigh;
	private Long severityMedium;
	private Long severityLow;
	private Long prioritySeverityHigh;
	private Long totalDefect;

	public Long getPriorityHigh() {
		return priorityHigh;
	}

	public void setPriorityHigh(Long priorityHigh) {
		this.priorityHigh = priorityHigh;
	}

	public Long getPriorityMedium() {
		return priorityMedium;
	}

	public void setPriorityMedium(Long priorityMedium) {
		this.priorityMedium = priorityMedium;
	}

	public Long getPriorityLow() {
		return priorityLow;
	}

	public void setPriorityLow(Long priorityLow) {
		this.priorityLow = priorityLow;
	}

	public Long getSeverityHigh() {
		return severityHigh;
	}

	public void setSeverityHigh(Long severityHigh) {
		this.severityHigh = severityHigh;
	}

	public Long getSeverityMedium() {
		return severityMedium;
	}

	public void setSeverityMedium(Long severityMedium) {
		this.severityMedium = severityMedium;
	}

	public Long getSeverityLow() {
		return severityLow;
	}

	public void setSeverityLow(Long severityLow) {
		this.severityLow = severityLow;
	}

	public Long getPrioritySeverityHigh() {
		return prioritySeverityHigh;
	}

	public void setPrioritySeverityHigh(Long prioritySeverityHigh) {
		this.prioritySeverityHigh = prioritySeverityHigh;
	}

	public Long getTotalDefect() {
		return totalDefect;
	}

	public void setTotalDefect(Long totalDefect) {
		this.totalDefect = totalDefect;
	}

}
