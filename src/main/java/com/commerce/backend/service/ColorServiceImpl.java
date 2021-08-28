package com.commerce.backend.service;

import com.commerce.backend.dao.ColorRepository;
import com.commerce.backend.model.dto.ColorDTO;
import com.commerce.backend.model.entity.Color;
import com.commerce.backend.model.response.color.ProductColorResponse;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ColorServiceImpl implements ColorService {
	@Autowired
	ColorRepository colorRepository;
   public List<ColorDTO> findAll(){
    	List<ColorDTO> colorVos = new LinkedList<ColorDTO>();
    	List<Color> colors = colorRepository.findAll();
    	if(colors != null) {
    		colors.stream().forEach(color ->{
    			ColorDTO colorVo = ColorDTO.builder()
    									   .name(color.getName())
    									   .id(color.getId())
    									   .hex(color.getHex())
    									   .build();
    			colorVos.add(colorVo);								   
    									
    		});
    	}
    	return colorVos;
    	
    }
   
 
@Override
public Color CreateNewColor() {
	// TODO Auto-generated method stub
	return null;
}
}
