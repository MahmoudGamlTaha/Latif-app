package com.commerce.backend.service;

import com.commerce.backend.model.dto.ColorDTO;
import com.commerce.backend.model.entity.Color;
import com.commerce.backend.model.response.color.ProductColorResponse;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ColorService {
    List<ColorDTO> findAll();
    Color CreateNewColor();
}
