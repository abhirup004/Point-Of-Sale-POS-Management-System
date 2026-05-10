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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
	
	private final CompanyService companyService;
	
	// ---------------------------------------------------------------------
	@Operation(tags = "Companies", summary = "Create a new company", description = "Creates a new company.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Company created successfully"),
			@ApiResponse(responseCode = "500", description = "Error creating ticket") })
	@PostMapping
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.saveCompany(company));
	}
	
	// ---------------------------------------------------------------------
	@Operation(tags = "Companies", summary = "List comments", description = "Retrieves all companies.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Companies retrieved successfully"),
			@ApiResponse(responseCode = "500", description = "Error retrieving tickets") })
	@GetMapping("/page")
	public ResponseEntity<Page<Company>> getDepartments(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(companyService.getCompany(pageable));
	}
	
	// ---------------------------------------------------------------------
	@Operation(tags = "Companies", summary = "Get a company", description = "Fetches a single company by its ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Company retrieved successfully"),
			@ApiResponse(responseCode = "404", description = "Company not found") })
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
		return ResponseEntity.ok(companyService.getCompanyById(id));
	}
	
	// ---------------------------------------------------------------------
	@Operation(tags = "Companies", summary = "Update company data", description = "Updates a company details.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Company updated successfully"),
		@ApiResponse(responseCode = "404", description = "Company not found"),
		@ApiResponse(responseCode = "400", description = "Invalid request body") })
	@PutMapping("/{companyId}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @RequestBody Company company) {
//		return ResponseEntity.ok(companyService.updateCompany(id, company));
		Company existingCompany =
	            companyService.getCompanyById(companyId);

	    existingCompany.setCname(company.getCname());
	    existingCompany.setCabbr(company.getCabbr());
	    existingCompany.setActive(company.isActive());

	    return ResponseEntity.ok(
	            companyService.saveCompany(existingCompany));
	    
	}
	
	// ---------------------------------------------------------------------
	@Operation(
		tags = "Companies",
		summary = "Delete a company by ID",
		description = "Deletes a company."
		)
		@ApiResponses(value = {
		    @ApiResponse(responseCode = "204",
		                 description = "Company deleted successfully"),
		    @ApiResponse(responseCode = "404",
		                 description = "Company not found"),

		    @ApiResponse(responseCode = "500",
		                 description = "Error deleting company")
		})
	@DeleteMapping("/{companyId}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
		companyService.deleteCompany(companyId);
		return ResponseEntity.noContent().build();
	}

}
