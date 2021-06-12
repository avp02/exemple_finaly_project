package com.avp.example_finaly_project.controller;

import com.avp.example_finaly_project.repository.CargoRepository;
import com.avp.example_finaly_project.repository.CityRepository;
import com.avp.example_finaly_project.repository.CompanyRepository;
import com.avp.example_finaly_project.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StatusRepository statusRepository;

    @GetMapping(value = "/list")
    public ModelAndView listPage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.findAll());
        return modelAndView;
    }
}
