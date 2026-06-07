package com.jbs.posbe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jbs.posbe.dto.request.VendorPatchDto;
import com.jbs.posbe.dto.request.VendorRequestDto;
import com.jbs.posbe.entity.Vendor;

public interface VendorService {

    Vendor saveVendor(VendorRequestDto vendorRequestDto);
    Page<Vendor> getVendors(Pageable pageable);
    Vendor getVendorById(Long vendorId);
    Vendor updateVendor( Long vendorId, VendorPatchDto dto);
    void deleteVendor(Long vendorId);
}