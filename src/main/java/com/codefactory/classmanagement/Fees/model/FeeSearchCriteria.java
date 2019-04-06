
package com.codefactory.classmanagement.Fees.model;

import java.math.BigDecimal;
import java.util.Date;

import com.codefactory.classmanagement.util.model.PageSize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString
public class FeeSearchCriteria extends PageSize{

    private Long feeReceiptId;

    private String studentName;

    private String course;

    private Short paymentType;

    private BigDecimal receivedAmt;

    private Date feeReceiptDate;

    private int standard;
    
    private String receivedBy;
    

    
}