package com.isoft.controller;

import com.isoft.entity.Apot;
import com.isoft.repository.ApotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class EChartsController {
    @Autowired
    ApotRepository apotRepository;

    @GetMapping("/echartsAPUE")
    public List<String> echartAPUE(){
        System.out.println(apotRepository.findCountApat());
        return apotRepository.findCountApat();
    }
}
