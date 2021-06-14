package com.avp.example_finaly_project.controller;

import com.avp.example_finaly_project.bean.Status;
import com.avp.example_finaly_project.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(value = "/addStatus")
    public ModelAndView addStatus() {
        ModelAndView modelAndView = new ModelAndView("/addStatus");
        return modelAndView;
    }

    @PostMapping(value = "/addStatus")
    public ModelAndView addStatusPost(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView("/addStatus");
        statusRepository.save(new Status(name));
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
