
package com.codefactory.classmanagement.Fees.model;

import java.math.BigDecimal;
import java.util.Date;

import com.codefactory.classmanagement.util.model.PageSize;

public class FeeSearchCriteria extends PageSize{

    private Long feeReceiptId;

    private String studentName;

    private String course;

    private Short paymentType;

    private BigDecimal receivedAmt;

    private Date feeReceiptDate;

    private int standard;
    
    private String receivedBy;
    

    /**
	 * @return the receivedBy
	 */
	public String getReceivedBy() {
		return receivedBy;
	}

	/**
	 * @param receivedBy the receivedBy to set
	 */
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Long getFeeReceiptId() {
        return this.feeReceiptId;
    }

    public void setFeeReceiptId(Long feeReceiptId) {
        this.feeReceiptId = feeReceiptId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Short getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(Short paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getReceivedAmt() {
        return this.receivedAmt;
    }

    public void setReceivedAmt(BigDecimal receivedAmt) {
        this.receivedAmt = receivedAmt;
    }

    public Date getFeeReceiptDate() {
        return this.feeReceiptDate;
    }

    public void setFeeReceiptDate(Date feeReceiptDate) {
        this.feeReceiptDate = feeReceiptDate;
    }

    public int getStandard() {
        return this.standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }




    @Override
    public String toString() {
        return "{" +
            " feeReceiptId='" + getFeeReceiptId() + "'" +
            ", studentName='" + getStudentName() + "'" +
            ", course='" + getCourse() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", receivedAmt='" + getReceivedAmt() + "'" +
            ", feeReceiptDate='" + getFeeReceiptDate() + "'" +
            ", standard='" + getStandard() + "'" +
            "}";
    }


    
}