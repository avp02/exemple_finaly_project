package com.avp.example_finaly_project.repository;

import com.avp.example_finaly_project.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAll();
    City findByName(String name);

    @Query(value = "select c from City c where c.id = ?1")
    City getById(int id);
}
