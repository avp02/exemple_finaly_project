package com.avp.example_finaly_project.controller;

import com.avp.example_finaly_project.bean.Cargo;
import com.avp.example_finaly_project.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping(value = "/addCargo")
    public ModelAndView addCargo() {
        ModelAndView modelAndView = new ModelAndView("/addCargo");
        return modelAndView;
    }

    @PostMapping(value = "/addCargo")
    public ModelAndView addCargoPost(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("/addCargo");
        cargoRepository.save(new Cargo(name));
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
