package com.commerce.backend.model.dto;

import com.commerce.backend.model.entity.ItemObjectCategory;
import com.commerce.backend.model.response.category.ItemObjectCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemObjectCategoryVO {
	private long id;
    private String name;
    private String nameAr;
    private String icon;
    private String iconSelect;
    private Integer type;
    private Boolean isExternalLink;
    private ItemObjectCategoryResponse parent;
    private Boolean ShowInterest;
    public ItemObjectCategoryVO(ItemObjectCategory entity) {
    	this.id = entity.getId();
    	this.icon = entity.getIcon();
    	this.name = entity.getName();
    	this.nameAr = entity.getNameAr();
    	this.ShowInterest = entity.getShowInterest();
    	this.type = entity.getType();
    	this.iconSelect = entity.getIcon_select();
    	this.icon = entity.getIcon();
    	this.nameAr = entity.getNameAr();
    	this.ShowInterest = entity.getShowInterest();
   // 	this.isExternalLink = entity.getIsExternalLink();
   
    }
    
    
}
