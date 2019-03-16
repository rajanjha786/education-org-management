package com.codefactory.classmanagement.Fees.service;



import org.springframework.data.domain.Page;

import com.codefactory.classmanagement.Fees.model.FeeSearchCriteria;
import com.codefactory.classmanagement.Fees.model.Fees;

public interface FeesService{

	Page<Fees> searchFees(FeeSearchCriteria searchCriteria);
    
}