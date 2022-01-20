package com.aldeamo.prueba.business.controller;

import com.aldeamo.prueba.business.service.ArraysService;
import com.aldeamo.prueba.model.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aldemo/web/v1/arrays")
public class ArraysController {
    @Autowired
    ArraysService arraysService;
    @GetMapping("/")
    public ResponseEntity<String> getArrayById(@RequestBody RequestDTO peticion) throws Exception {
        return new ResponseEntity(arraysService.calculateArray(peticion), HttpStatus.OK);
    }
}
