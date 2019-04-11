package com.codefactory.classmanagement.Fees.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codefactory.classmanagement.Fees.model.FeeSearchCriteria;
import com.codefactory.classmanagement.Fees.model.Fees;
import com.codefactory.classmanagement.Fees.service.FeesService;
import com.codefactory.classmanagement.util.Exception.ValidationException;
import com.codefactory.classmanagement.util.model.ErrorMessages;
import com.codefactory.classmanagement.util.model.Message;

import net.sf.jasperreports.engine.JRException;

@RestController("FeesController")
public class FeesController{


    @Autowired
    private FeesService feesService;

    @Autowired
    private Logger logger;

    @RequestMapping(value = "/fee", method = RequestMethod.POST)
    public ResponseEntity<byte[]> saveFees(@Valid @RequestBody Fees fees, Errors errors) throws IOException, JRException{
    	
    	if(errors.hasErrors()) {
    		List<FieldError> fieldErrors = errors.getFieldErrors();
    		List<Message> errorMessages = new ArrayList<>();
    		for(FieldError error : fieldErrors) {
    			Message msg = new Message();
    			msg.setMessage(error.getDefaultMessage());
    			errorMessages.add(msg);
    		}
    		ErrorMessages errorMessage = new ErrorMessages();
    		errorMessage.setMessage(errorMessages);
    		
    		throw new ValidationException(errorMessage);
    	}
    	
    	logger.debug("The Received Request is:"+fees.toString());
    	byte[] bytes  = feesService.saveFees(fees);
        return ResponseEntity
        		.ok()
        		.header("Content-Type", "appication/pdf; charset=UTF-8")
        		.header("Content-Disposition", "inline;filename=\"" + fees.getId()+fees.getStudentName()+".pdf\"")
        		.body(bytes);
    }
    
    @RequestMapping(value = "fee/{feeId}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reprintFeeReceipt(@PathVariable long feeId) throws Exception {
    	
    	logger.debug("Fee Id: "+feeId);
    	byte [] bytes = feesService.reprintFees(feeId);
    	 return ResponseEntity
         		.ok()
         		.header("Content-Type", "appication/pdf; charset=UTF-8")
         		.header("Content-Disposition", "inline;filename=\"" + feeId +".pdf\"")
         		.body(bytes);
    	
    	
    }
    
    
    
    @RequestMapping(value = "fee", method = RequestMethod.GET)
    public ResponseEntity<Page<Fees>> getFees(
        @RequestParam(name = "feeReceiptId", required = false)Long feeReceiptId,
        @RequestParam(name = "studentName",required = false)String studentName,
        @RequestParam(name = "course",required = false) String course,
        @RequestParam(name = "paymentType",required = false) Short paymentType,
        @RequestParam(name = "receivedAmt",required = false) BigDecimal receivedAmt,
        @RequestParam(name = "feeReceiptDate",required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date feeReceiptDate,
        @RequestParam(name = "standard",required = false) Integer standard,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
        @RequestParam(name = "receivedBy", required = false)String receivedBy){

        logger.debug("Searching Fees on the search criteria");

        FeeSearchCriteria searchCriteria = new FeeSearchCriteria();
        if(feeReceiptId != null) {
            searchCriteria.setFeeReceiptId(feeReceiptId);
        }
        if(studentName != null) {
            searchCriteria.setStudentName(studentName);
        }

        if(course != null) {
            searchCriteria.setCourse(course);
        }

        if(paymentType != null) {
            searchCriteria.setPaymentType(paymentType);
        }

        if(receivedAmt != null) {
            searchCriteria.setReceivedAmt(receivedAmt);
        }

        if(feeReceiptDate != null) {
            searchCriteria.setFeeReceiptDate(feeReceiptDate);
        }
        if(standard != null) {
            searchCriteria.setStandard(standard);
        }
        
        if(receivedBy != null) {
        	searchCriteria.setReceivedBy(receivedBy);
        }

        searchCriteria.setPage(page);
        searchCriteria.setPageSize(pageSize);
        logger.debug("The search criteria is :"+ searchCriteria.toString());
        

        Page<Fees> feeSet = feesService.searchFees(searchCriteria);
        return new ResponseEntity<>(feeSet, HttpStatus.OK);
        

    }


   /* @RequestMapping(value = "/totalfee", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getTotalFees() {
        
        return new ResponseEntity<>(feesRepo.getTotalFeesCollected(), HttpStatus.OK);
    }*/


    

}
