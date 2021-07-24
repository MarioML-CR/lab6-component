package com.cenfotec.app.controller;

import com.cenfotec.app.domian.Antologia;
import com.cenfotec.app.domian.Articulo;
import com.cenfotec.app.service.AntologiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AntologiaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @RequestMapping(value = "/insertarArticulo",  method = RequestMethod.GET)
    public String insertarArticuloPage(
            @RequestParam(value = "idAntologia", required = true) Long id,
            Model model) {
        model.addAttribute("idAntologia", id);
        model.addAttribute(new Articulo());
        return "insertarArticulo";
    }

    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarAction(Antologia antologia, BindingResult result, Model model) {
        anthologiaService.save(antologia);
        return "index";
    }
    @RequestMapping(value = "/insertarArticulo",  method = RequestMethod.POST)
    public String insertarArticuloAction(
            @RequestParam(value = "idAntologia", required = true) Long id,
            Articulo articulo, BindingResult result, Model model) {
        anthologiaService.saveArticulo(articulo, id);
        return "index";
    }


    @RequestMapping("/listar")
    public String listar(Model model) {
        logger.info("lista de antologias", anthologiaService.getAll());
        model.addAttribute("antologias",anthologiaService.getAll());
        return "listar";
    }
}
