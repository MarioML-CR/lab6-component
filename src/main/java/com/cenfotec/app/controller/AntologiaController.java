package com.cenfotec.app.controller;

import com.cenfotec.app.domian.Antologia;
import com.cenfotec.app.service.AntologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AntologiaController {
    @Autowired
    AntologiaService anthologiaService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Antologia());
        return "insertar";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarAction(Antologia antologia, BindingResult result, Model model) {
        anthologiaService.save(antologia);
        return "index";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("antologias",anthologiaService.getAll());
        return "listar";
    }
}
