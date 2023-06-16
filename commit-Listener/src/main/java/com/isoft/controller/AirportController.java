package com.isoft.controller;

import com.isoft.entity.Apot;
import com.isoft.entity.Meta;
import com.isoft.repository.ApotRepository;
import com.isoft.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    MetaRepository metaRepository;
    @Autowired
    ApotRepository apotRepository;

    @GetMapping("/APUE")
    public List<Object> getAPUE(){
        List<Object> apue = new ArrayList<>();
        List<Apot> apot = apotRepository.findAll();
        List<Meta> meta = metaRepository.findAPOTMeta();
        System.out.println(apot.size());
        apue.add(meta);
        apue.add(apot);
        return apue;

    }
}
