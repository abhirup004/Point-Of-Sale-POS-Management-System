package com.jbs.posbe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbs.posbe.entity.Company;
import com.jbs.posbe.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
	
	private final CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.saveCompany(company));
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Company>> getDepartments(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(companyService.getCompany(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
		return ResponseEntity.ok(companyService.getCompanyById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
		return ResponseEntity.ok(companyService.updateCompany(id, company));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return ResponseEntity.noContent().build();
	}

}
