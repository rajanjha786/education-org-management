package com.codefactory.classmanagement.Fees.serviceimpl;

import static com.codefactory.classmanagement.Fees.model.FeesPredicates.searchFeesPredicate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codefactory.classmanagement.Fees.dao.FeesRepo;
import com.codefactory.classmanagement.Fees.model.FeeSearchCriteria;
import com.codefactory.classmanagement.Fees.model.Fees;
import com.codefactory.classmanagement.Fees.service.FeesService;
import com.querydsl.core.types.Predicate;

@Service("FeesServiceImpl")
@Transactional
public class FeesServiceImpl implements FeesService {

    @Autowired
    private FeesRepo feesRepo;

    @Override
    public Page<Fees> searchFees(FeeSearchCriteria searchCriteria) {

        Predicate predicate = searchFeesPredicate(searchCriteria);
        Page<Fees> feesList = feesRepo.findAll(predicate, 
        PageRequest.of(searchCriteria.getPage()
        ,searchCriteria.getPageSize(), Sort.by(Sort.Direction.DESC, "dtFeeReceipt")));
        return feesList;
    }

}