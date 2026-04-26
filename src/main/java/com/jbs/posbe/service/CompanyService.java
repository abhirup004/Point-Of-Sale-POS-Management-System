package com.jbs.posbe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jbs.posbe.entity.Company;

public interface CompanyService {
	
	Company saveCompany(Company company);
	Page<Company> getCompany(Pageable pageable);
	Company getCompanyById(Long companyId);
	Company updateCompany(Long companyId, Company company);
	void deleteCompany(Long companyId);

}
