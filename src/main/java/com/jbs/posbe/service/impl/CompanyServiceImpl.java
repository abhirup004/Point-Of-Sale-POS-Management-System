package com.jbs.posbe.service.impl;

import org.springframework.stereotype.Service;

import com.jbs.posbe.service.CompanyService;
import com.jbs.posbe.repository.CompanyRepository;
import com.jbs.posbe.entity.Company;
import org.springframework.data.domain.Page;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;

	@Override
	public Company saveCompany(Company company) 	{
		if (company == null) {
			throw new IllegalArgumentException("Company cannot be null");
		}
		return companyRepository.save(company);
	}

	@Override
	public Page<Company> getCompany(
			org.springframework.data.domain.Pageable pageable) {
		if (pageable == null) {
			throw new IllegalArgumentException("Pageable parameter cannot be null");
		}
		return companyRepository.findAll(pageable);
	}

	@Override
	public Company getCompanyById(java.lang.Long companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
		return company;
	}

	@Override
	public Company updateCompany(Long companyId, Company company) {
		if (!companyRepository.existsById(companyId)) {
			throw new RuntimeException("Company not found with id: " + companyId);
		}

		return companyRepository.save(company);
	}

	@Override
	public void deleteCompany(Long companyId) {
		if (!companyRepository.existsById(companyId)) {
			throw new RuntimeException("Company not found with id: " + companyId);
		}
		companyRepository.deleteById(companyId);
	}

}
