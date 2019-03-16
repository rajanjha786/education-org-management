package com.codefactory.classmanagement.Fees.model;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public final class FeesPredicates{

    private FeesPredicates() {}

    public static Predicate searchFeesPredicate(FeeSearchCriteria searchCriteria) {

        BooleanBuilder builder = new BooleanBuilder();

        if(searchCriteria.getStudentName() != null && !searchCriteria.getStudentName().isEmpty()){
            builder.and(QFees.fees.studentName.containsIgnoreCase(searchCriteria.getStudentName()));
        }

        if(searchCriteria.getCourse() != null && !searchCriteria.getCourse().isEmpty()) {
            builder.and(QFees.fees.course.equalsIgnoreCase(searchCriteria.getCourse()));
        }

        if(searchCriteria.getStandard() != 0) {
            builder.and(QFees.fees.standard.eq(searchCriteria.getStandard()));
        }

        if(searchCriteria.getFeeReceiptId() != null ) {
            builder.and(QFees.fees.id.eq(searchCriteria.getFeeReceiptId()));
        }
        if(searchCriteria.getPaymentType() != null){ 
            builder.and(QFees.fees.paymentType.eq(searchCriteria.getPaymentType()));
        }
        if(searchCriteria.getFeeReceiptDate() != null) {
            builder.and(QFees.fees.dtFeeReceipt.eq(searchCriteria.getFeeReceiptDate()));
        }
        if(searchCriteria.getReceivedAmt() != null) {
            builder.and(QFees.fees.receivedAmt.eq(searchCriteria.getReceivedAmt()));
        }
        
        if(searchCriteria.getReceivedBy() != null) {
        	builder.and(QFees.fees.createdBy.containsIgnoreCase(searchCriteria.getReceivedBy()));
        }

        return builder.getValue();
    }
}