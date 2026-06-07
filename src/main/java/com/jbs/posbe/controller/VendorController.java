package com.jbs.posbe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jbs.posbe.dto.ManagedApiResponse;
import com.jbs.posbe.dto.request.VendorPatchDto;
import com.jbs.posbe.dto.request.VendorRequestDto;
import com.jbs.posbe.entity.Vendor;
import com.jbs.posbe.service.VendorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    // ---------------------------------------------------------------------
    @Operation(
            tags = "Vendors",
            summary = "Create a new vendor",
            description = "Creates a new vendor."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Vendor created successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error creating vendor"
            )
    })
    @PostMapping
    public ResponseEntity<ManagedApiResponse<Vendor>> saveVendor(@Valid @RequestBody VendorRequestDto dto) {

        Vendor vendor = new Vendor();

        vendor.setVname(dto.getVname());

        if (dto.getActive() != null) {
            vendor.setActive(dto.getActive());
        }

        Vendor savedVendor = vendorService.saveVendor(vendor);

        ManagedApiResponse<Vendor> response =
                new ManagedApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Vendor created successfully",
                        savedVendor
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // ---------------------------------------------------------------------
    @Operation(
            tags = "Vendors",
            summary = "List vendors",
            description = "Retrieves all vendors."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Vendors retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error retrieving vendors"
            )
    })
    @GetMapping("/page")
    public ResponseEntity<ManagedApiResponse<Page<Vendor>>> getVendors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Vendor> vendorPage = vendorService.getVendors(pageable);

        ManagedApiResponse<Page<Vendor>> response =
                new ManagedApiResponse<>(
                        HttpStatus.OK.value(),
                        "Vendors retrieved successfully",
                        vendorPage
                );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------------------------------
    @Operation(
            tags = "Vendors",
            summary = "Get a vendor",
            description = "Fetches a single vendor by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Vendor retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Vendor not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ManagedApiResponse<Vendor>> getVendorById(@PathVariable Long id) {

        Vendor vendor = vendorService.getVendorById(id);

        ManagedApiResponse<Vendor> response =
                new ManagedApiResponse<>(
                        HttpStatus.OK.value(),
                        "Vendor retrieved successfully",
                        vendor
                );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------------------------------
    @Operation(
            tags = "Vendors",
            summary = "Update vendor data",
            description = "Updates vendor details."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Vendor updated successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Vendor not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body"
            )
    })
    @PatchMapping("/{vendorId}")
    public ResponseEntity<ManagedApiResponse<Vendor>> updateVendor(
            @PathVariable Long vendorId,
            @Valid @RequestBody VendorPatchDto dto) {

        Vendor updatedVendor = vendorService.updateVendor(vendorId, dto);

        ManagedApiResponse<Vendor> response =
                new ManagedApiResponse<>(
                        HttpStatus.OK.value(),
                        "Vendor updated successfully",
                        updatedVendor
                );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------------------------------
    @Operation(
            tags = "Vendors",
            summary = "Delete a vendor by ID",
            description = "Deletes a vendor."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Vendor deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Vendor not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error deleting vendor"
            )
    })
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<ManagedApiResponse<Void>> deleteVendor(@PathVariable Long vendorId) {

        vendorService.deleteVendor(vendorId);

        ManagedApiResponse<Void> response =
                new ManagedApiResponse<>(
                        HttpStatus.NO_CONTENT.value(),
                        "Vendor deleted successfully",
                        null
                );

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(response);
    }
}