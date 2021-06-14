package com.defect.tracker.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefectCountByPriotryAndProjectDto {
	private Long priorityHigh;
	private Long priorityMedium;
	private Long priorityLow;
	private Long severityHigh;
	private Long severityMedium;
	private Long severityLow;
	private Long prioritySeverityHigh;
	private Long totalDefect;

}
