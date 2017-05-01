package com.itransition.lyubin.controller;

import com.itransition.lyubin.localizaton.LocalizationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "localization")
public class LocalizationController {

    private LocalizationInterface ruLocalization;
    private LocalizationInterface enLocalization;

    @Autowired
    public LocalizationController(@Qualifier("localizationRU") LocalizationInterface ruLocalization,
                                  @Qualifier("localizationEN") LocalizationInterface enLocalization) {
        this.ruLocalization = ruLocalization;
        this.enLocalization = enLocalization;
    }

    @GetMapping(value = "get")
    public ResponseEntity<?> getLocal(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(this.getConcretLocal(name).getLocal());
    }

    private LocalizationInterface getConcretLocal(String name) {
        if (name.equals("ru")) return this.ruLocalization;
        return this.enLocalization;
    }

}