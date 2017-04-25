package com.itransition.lyubin.controller;


import com.itransition.lyubin.service.TypeOfPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/typeofphoto")
public class TypeOfPhotoController {

    @Autowired
    private TypeOfPhotoService typeOfPhotoService;

    @GetMapping(value = "getAll")
    public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(typeOfPhotoService.findAll());
  }

}
