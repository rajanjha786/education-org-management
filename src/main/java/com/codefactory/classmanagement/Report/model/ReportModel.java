package com.codefactory.classmanagement.Report.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReportModel {
	
	
	private String className;
	private String contactNo1;
	private String contactNo2;
	private String address1;
	private String address2;
	private String studentName;
	private String course;
	private String batch;
	private int standard;
	private BigDecimal totalFees;
	private Short totalNoInstallment;
	private BigDecimal downPayment;
	private Short noOfInstallment;
	private BigDecimal receivedAmt;
	private BigDecimal totalAmtPaid;
	private BigDecimal totalAmtRemaining;
	private String paymentType;
	private String dtFeeReceipt;
	private String receivedBy;
	private Long id;
	private String logo;
	

}
