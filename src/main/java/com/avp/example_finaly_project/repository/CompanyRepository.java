package com.avp.example_finaly_project.repository;

import com.avp.example_finaly_project.bean.Cargo;
import com.avp.example_finaly_project.bean.City;
import com.avp.example_finaly_project.bean.Company;
import com.avp.example_finaly_project.bean.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAll();
    Company findByName(String name);
    Company findById(int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Company s WHERE s.id = ?1")
    void deleteCompanyById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Company s SET s.cargo = ?2, s.city = ?3, s.status = ?4 WHERE s.id = ?1")
    void setNewData(Integer id, Cargo cargo, City city, Status status);

    @Query(value = "SELECT s FROM Company s WHERE s.name LIKE %?1%")
    List<Company> searchCompanyByName(String name);

    @Query(value = "SELECT s FROM Company s WHERE s.id = ?1")
    Company searchCompanyById(Integer id);

}
