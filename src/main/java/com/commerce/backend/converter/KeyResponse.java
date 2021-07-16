package com.commerce.backend.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KeyResponse {
	private String code;
    private String name;
    private String name_ar;
    private Object value;
    private Object value_ar;

    public KeyResponse(String fieldNameKey,String name, String name_ar, Object value, Object value_ar){
    	this.code  =fieldNameKey;
        this.name = name;
        this.name_ar = name_ar;
        this.value = value;
        this.value_ar = value_ar;
        if(this.value_ar == null) {
        	this.value_ar = this.value;
        }
    }
  
}
