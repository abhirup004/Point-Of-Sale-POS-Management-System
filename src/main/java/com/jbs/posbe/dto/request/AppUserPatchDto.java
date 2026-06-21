package com.jbs.posbe.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserPatchDto {
	
	private String userName;
	
	private String userPassword;
	
	private String userRole;
	
	private Boolean active;

}
