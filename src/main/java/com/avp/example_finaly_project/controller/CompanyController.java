package com.avp.example_finaly_project.controller;

import com.avp.example_finaly_project.bean.Company;
import com.avp.example_finaly_project.repository.CargoRepository;
import com.avp.example_finaly_project.repository.CityRepository;
import com.avp.example_finaly_project.repository.CompanyRepository;
import com.avp.example_finaly_project.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/addCompany")
    public ModelAndView addCompany() {
        ModelAndView modelAndView = new ModelAndView("/addCompany");
        modelAndView.addObject("cargoList", cargoRepository.findAll());
        modelAndView.addObject("cityList", cityRepository.findAll());
        modelAndView.addObject("statusList", statusRepository.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/addCompany")
    public ModelAndView addCompanyPost(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "city", required = false) String city,
                                       @RequestParam(value = "cargo", required = false) String cargo,
                                       @RequestParam(value = "status", required = false) String status) {
        ModelAndView modelAndView = new ModelAndView("/addCompany");
        Company company = Company.builder()
                .name(name)
                .city(cityRepository.findByName(city))
                .cargo(cargoRepository.findByName(cargo))
                .status(statusRepository.findByName(status))
                .build();
        companyRepository.save(company);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }

    @GetMapping(value = "delete" + "/{id}")
    public ModelAndView deleteCompany(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        companyRepository.deleteCompanyById(id);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }

    @GetMapping(value = "searchName")
    public ModelAndView searchName(@ModelAttribute(name = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.searchCompanyByName(name));
        return modelAndView;
    }

    @GetMapping(value = "searchId")
    public ModelAndView searchId(@ModelAttribute(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listCompany", companyRepository.searchCompanyById(id));
        return modelAndView;
    }

    @GetMapping(value = "/update" + "/{id}")
    public ModelAndView updateCompany(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("/updateCompany");
        Company company = companyRepository.findById(id);
        modelAndView.addObject("myCompany", company);
        modelAndView.addObject("cityList", cityRepository.findAll());
        modelAndView.addObject("cargoList", cargoRepository.findAll());
        modelAndView.addObject("statusList", statusRepository.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/update" + "/{id}")
    public ModelAndView updateCompanyPost(@PathVariable(name = "id") int id,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "city", required = false) String city,
                                          @RequestParam(value = "cargo", required = false) String cargo,
                                          @RequestParam(value = "status", required = false) String status) {
        ModelAndView modelAndView = new ModelAndView("/updateCompany");
        companyRepository.setNewData(id, cargoRepository.findByName(cargo), cityRepository.findByName(city), statusRepository.findByName(status), name);
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }


}
