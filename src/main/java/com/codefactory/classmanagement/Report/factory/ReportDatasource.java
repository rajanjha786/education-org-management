package com.codefactory.classmanagement.Report.factory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.codefactory.classmanagement.Fees.model.Fees;
import com.codefactory.classmanagement.Report.model.ReportModel;

@Component
public class ReportDatasource {
	
	
	private static ResourceLoader resourceLoader;
	
	



	/**
	 * @param resourceLoader the resourceLoader to set
	 */
	@Autowired
	public  void setResourceLoader(ResourceLoader resourceLoader) {
		ReportDatasource.resourceLoader = resourceLoader;
	}




	public static  Collection generateCollection(Fees fees) throws IOException {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		ReportModel model = new ReportModel();
		model.setAddress1("BALAJI ROW HOUSE BUILDING NO.2 AMLI SILVASSA");
		model.setAddress2("SILVASSA");
		model.setContactNo1("9824929403");
		model.setContactNo2("9723212346");
		model.setBatch(fees.getBranch());
		model.setStudentName(fees.getStudentName());
		model.setCourse(fees.getCourse());
		model.setStandard(fees.getStandard());
		model.setTotalFees(fees.getTotalFees());
		model.setTotalNoInstallment(fees.getTotalNoOfInstallments());
		model.setDownPayment(fees.getDownPayment());
		model.setNoOfInstallment(fees.getNumberOfInstallments());
		model.setReceivedAmt(fees.getReceivedAmt());
		model.setTotalAmtPaid(fees.getTotAmtPayed());
		model.setTotalAmtRemaining(fees.getTotRemainingAmt());
		
		//1 = Cash 2 = Cheque 3 = Bank Transfer
		
		if(fees.getPaymentType().equals(new Short("1"))) {
			model.setPaymentType("Cash");
		}
		else if(fees.getPaymentType().equals(new Short("2"))) {
			model.setPaymentType("Cheque");
		}
		else {
			model.setPaymentType("Bank Transfer");
		}
		
		model.setDtFeeReceipt(formatter.format(fees.getDtFeeReceipt()));
		model.setReceivedBy(fees.getCreatedBy());
		model.setClassName("Catalyst Classes");
		model.setId(fees.getId());
		String path = resourceLoader.getResource("classpath:amit.jpg").getURI().getPath();
		model.setLogo(path);
		
		Collection collection = new Vector();
		collection.add(model);
		return collection;
	}
	
	
	

}
