package com.codefactory.classmanagement.Fees.service;



import java.io.IOException;

import org.springframework.data.domain.Page;

import com.codefactory.classmanagement.Fees.model.FeeSearchCriteria;
import com.codefactory.classmanagement.Fees.model.Fees;

import net.sf.jasperreports.engine.JRException;

public interface FeesService{

	Page<Fees> searchFees(FeeSearchCriteria searchCriteria);

	byte[] saveFees(Fees fees) throws IOException, JRException;
    
}