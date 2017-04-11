package com.itransition.lyubin.controller;

import com.itransition.lyubin.dto.SexDTO;
import com.itransition.lyubin.model.Sex;
import com.itransition.lyubin.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sex")
public class SexController {

    @Autowired
    private SexRepository sexRepository;

    @Autowired
    private SexService sexService

    @GetMapping(value = "/getall")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(sexService.findAll());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> findOneById(@RequestParam int id) {
        return ResponseEntity.ok(sexService.findById(id));
    }

    @PostMapping(value = "/save")
        public ResponseEntity<String> save(@RequestBody SexDTO sexDTO){
        sexService.save(toSex(SexDTO));
        return new ResponseEntity("good", HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> deleteSexById (@RequestBody int id){
        sexService.delete(id);
        return ResponseEntity.ok("ok");
    }
    public Sex toSex(SexDTO sexDTO){
        Sex sex = new Sex();
        sex.setName(sexDTO.getName());
        return sex;
    }
}
