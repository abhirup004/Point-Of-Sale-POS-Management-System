package com.jbs.posbe.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jbs.posbe.dto.request.VendorPatchDto;
import com.jbs.posbe.entity.Vendor;
import com.jbs.posbe.repository.VendorRepository;
import com.jbs.posbe.service.VendorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        if (vendor == null) {
            throw new IllegalArgumentException(
                    "Vendor cannot be null");
        }
        return vendorRepository.save(vendor);
    }

    @Override
    public Page<Vendor> getVendors(Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Pageable cannot be null");
        }
        return vendorRepository.findAll(pageable);
    }

    @Override
    public Vendor getVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    @Override
    public Vendor updateVendor(Long vendorId, VendorPatchDto dto) {
        Vendor vendor = getVendorById(vendorId);

        if (dto.getVname() != null) {
            vendor.setVname(dto.getVname());
        }
        if (dto.getActive() != null) {
            vendor.setActive(dto.getActive());
        }

        return vendorRepository.saveAndFlush(vendor);
    }

    @Override
    public void deleteVendor(Long vendorId) {
        Vendor vendor = getVendorById(vendorId);
        vendorRepository.delete(vendor);
    }
}