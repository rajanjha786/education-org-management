package com.codefactory.classmanagement.Fees.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.codefactory.classmanagement.util.JSONUtil.DateUtilDesirializer;
import com.codefactory.classmanagement.util.JSONUtil.DateUtilSerializer;
import com.codefactory.classmanagement.util.model.AuditModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
@Entity
@Table(name = "fee_receipt")
@Data
public class Fees extends AuditModel{

    @Id
    @GeneratedValue(generator = "fee_receipt_sequence_generator")
    @SequenceGenerator(
        name = "fee_receipt_sequence_generator",
        sequenceName = "fee_receipt_sequence",
        initialValue = 10000,
        allocationSize = 1
    )
    @Column(name = "fee_receipt_id")
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "payment_mode", nullable = false)
    //1 = Cash 2 = Cheque 3 = Bank Transfer
    private Short paymentType;

    @Column(name = "total_no_installments", nullable = false)
    private Short totalNoOfInstallments;

    @Column(name = "number_installment", nullable = false)
    private Short numberOfInstallments;

    @Column(name = "down_payment")
    private BigDecimal downPayment;

    @Column(name = "received_amount", nullable = false)
    private BigDecimal receivedAmt;


    @Column(name = "total_amt_payed", nullable = false)
    private BigDecimal totAmtPayed;

    @Column(name = "total_remaining_amt", nullable = false)
    private BigDecimal totRemainingAmt;

    @Column(name = "fee_receipt_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = DateUtilDesirializer.class)
    @JsonSerialize(using = DateUtilSerializer.class)
    private Date dtFeeReceipt;

    @Column(name = "standard", nullable = false)
    private int standard;

    @Column(name = "total_fees", nullable = false)
    private BigDecimal totalFees;



}