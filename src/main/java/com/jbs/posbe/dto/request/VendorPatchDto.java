package com.jbs.posbe.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorPatchDto {

    private String vname;
    
    private Long companyId;

    private Boolean active;
}