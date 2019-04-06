package com.codefactory.classmanagement.Fees.serviceimpl;

import static com.codefactory.classmanagement.Fees.model.FeesPredicates.searchFeesPredicate;

import java.io.IOException;
import java.util.HashMap;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codefactory.classmanagement.Fees.dao.FeesRepo;
import com.codefactory.classmanagement.Fees.model.FeeSearchCriteria;
import com.codefactory.classmanagement.Fees.model.Fees;
import com.codefactory.classmanagement.Fees.service.FeesService;
import com.codefactory.classmanagement.Report.factory.ReportDatasource;
import com.querydsl.core.types.Predicate;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRProperties;

@Service("FeesServiceImpl")
@Transactional
public class FeesServiceImpl implements FeesService {

    @Autowired
    private FeesRepo feesRepo;

    @Autowired
    private Logger logger;
    
    @Autowired
    @Qualifier("FeeReceipt")
    JasperReport report;
    
   
    
    
    @Override
    public Page<Fees> searchFees(FeeSearchCriteria searchCriteria) {

        Predicate predicate = searchFeesPredicate(searchCriteria);
        Page<Fees> feesList = feesRepo.findAll(predicate, 
        PageRequest.of(searchCriteria.getPage()
        ,searchCriteria.getPageSize(), Sort.by(Sort.Direction.DESC, "dtFeeReceipt")));
        return feesList;
    }

	@Override
	@Transactional(rollbackOn = {Exception.class})
	public byte[] saveFees(Fees fees) throws IOException, JRException {
		
		
		byte[] bytes = null;
		fees.setUpdatedBy(fees.getCreatedBy());
		fees = feesRepo.save(fees);
		HashMap parameter = new HashMap();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(ReportDatasource.generateCollection(fees));
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameter,beanColDataSource);
		bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		return bytes;
	}

}