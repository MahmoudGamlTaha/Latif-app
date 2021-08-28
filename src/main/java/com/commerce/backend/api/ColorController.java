package com.commerce.backend.api;

import com.commerce.backend.constants.MessageType;
import com.commerce.backend.helper.resHelper;
import com.commerce.backend.model.dto.ColorDTO;
import com.commerce.backend.model.entity.Color;
import com.commerce.backend.model.response.BasicResponse;
import com.commerce.backend.model.response.color.ProductColorResponse;
import com.commerce.backend.service.ColorService;
import com.commerce.backend.service.ProductColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController extends PublicApiController {

    private final ColorService colorService;


    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }


    @GetMapping(value = "color/colors")
    public ResponseEntity<BasicResponse> getAllColors() {
        List<ColorDTO> colors = colorService.findAll();
        BasicResponse response = resHelper.res(colors, true, MessageType.Data.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
