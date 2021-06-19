package com.avp.example_finaly_project.controller.rest.api;

import com.avp.example_finaly_project.bean.City;
import com.avp.example_finaly_project.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("api/cities")
    public ResponseEntity <List<City>> fetchCities() {
        return ResponseEntity.ok(cityRepository.findAll());
    }

    @GetMapping("api/city/{id}")
    public ResponseEntity <City> fetchCity(@PathVariable int id) {
        return ResponseEntity.ok(cityRepository.getById(id));
    }
}
