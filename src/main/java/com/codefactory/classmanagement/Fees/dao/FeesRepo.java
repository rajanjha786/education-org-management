
package com.codefactory.classmanagement.Fees.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.codefactory.classmanagement.Fees.model.Fees;

@Repository
public interface FeesRepo extends JpaRepository<Fees,Long>, QuerydslPredicateExecutor<Fees>{


    @Query("SELECT sum(fee.receivedAmt) from Fees fee")
    BigDecimal getTotalFeesCollected();

    
    
}