package com.jbs.posbe.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorRequestDto {

    @NotBlank(message = "Vendor name cannot be blank")
    private String vname;
    
    @NotNull
    private Long companyId;

    private Boolean active = true;
}