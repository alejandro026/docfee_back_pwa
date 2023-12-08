package com.docfee.admin.utng.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenSwDTO {

    private String endpoint;
    private String expirationTime;
    
    private KeysDTO keys;

}
