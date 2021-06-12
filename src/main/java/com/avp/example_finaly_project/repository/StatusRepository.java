package com.avp.example_finaly_project.repository;

import com.avp.example_finaly_project.bean.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    List<Status> findAll();

    Status findByName(String name);
}
